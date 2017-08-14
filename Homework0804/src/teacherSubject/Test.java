package teacherSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/*
 * ֪ʶ����ϰ������HashMap������¹��ܣ�
 * 1.�������ʵ����ֱ���ʦ�����ź��������Ϳ�Ŀ����Ŀ��ţ����ƣ���ע����
 * 2.��һ��HashMap��������ʦ�ܽ�����Щ��Ŀ��
 * 3.���ø���������HashMap��������Ŀ�ֱ�������Щ��ʦ���ڡ����ó�������ȷ��HashMap
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


