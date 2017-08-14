package teacherSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/*
 * 知识点练习：利用HashMap完成以下功能：
 * 1.完成两个实体类分别老师（工号和姓名）和科目（科目编号，名称，备注）；
 * 2.做一个HashMap来描述老师能教授哪些科目；
 * 3.利用刚做出来的HashMap来作出科目分别能由哪些老师教授。最后得出两个正确的HashMap
 */
public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		HashMap<Teacher,ArrayList<Subject>> hm = new HashMap<>();
		HashMap<Subject,ArrayList<Teacher>> hmTwo ;

		Teacher teaOne=new Teacher("T001","aa");
		Teacher teaTwo=new Teacher("T002","bb");
		Teacher teaThr=new Teacher("T003","cc");
		
		Subject subOne=new Subject("S001","java","java");
		Subject subTwo=new Subject("S002","C#","C#");
		Subject subThr=new Subject("S003","DB","DB");
		
		teaOne.addSubject(subOne);
		teaOne.addSubject(subTwo);

		teaTwo.addSubject(subTwo);
		teaTwo.addSubject(subThr);

		teaThr.addSubject(subOne);
//		teaThr.addSubject(subThr);

		hm.put(teaOne,teaOne.getSubName());
		hm.put(teaTwo,teaTwo.getSubName());
		hm.put(teaThr,teaThr.getSubName());

		test.print(hm);
		hmTwo = test.setSubTeacher(hm);
		System.out.println();
		test.print(hmTwo);
	}

	public HashMap<Subject,ArrayList<Teacher>> setSubTeacher(HashMap<Teacher,ArrayList<Subject>> hashMap){
		HashMap<Subject,ArrayList<Teacher>> temp = new HashMap<>();
		Set<Entry<Teacher, ArrayList<Subject>>> entries = hashMap.entrySet();
		Iterator itEntry = entries.iterator();
		while(itEntry.hasNext()){
			Entry<Teacher,ArrayList<Subject>> tmpEtr = (Entry<Teacher,ArrayList<Subject>>)itEntry.next();
			int index = tmpEtr.getValue().size();
			for(int count = 0 ; count < index ; count++){
				temp.put(tmpEtr.getValue().get(count),tmpEtr.getValue().get(count).addTeaName(tmpEtr.getKey()));
			}
		}
		return temp;
	}

	public void print(HashMap temp){
		Set<Entry> entries = temp.entrySet();
		Iterator itEntry = entries.iterator();
		while(itEntry.hasNext()) {
			Entry tmpEtr = (Entry) itEntry.next();
			System.out.print(tmpEtr.getKey() + " : " + tmpEtr.getValue()+"\n");
			}
		}
	}


