import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TeaSubTest {
	//结果容器：做一个HashMap来描述科目可以有那几个老师能教授
	HashMap<Subject, ArrayList<Teacher>> subMap = new HashMap<>();
	//已知条件：做一个HashMap来描述老师能教授哪些科目
	HashMap<Teacher, ArrayList<Subject>> teaMap = new HashMap<>();
 
	public void init() {
		//准备原始科目
		Subject Chinese = new Subject("001", "语文", "***");
		Subject Math = new Subject("002", "数学", "***");
		Subject Java = new Subject("003", "Java", "*");
		Subject C_Program = new Subject("004", " C_Program", "*");
		//准备初始老师
		Teacher teaOne = new Teacher("t001", "老师1");
		Teacher teaTwo = new Teacher("t002", "老师2");
		Teacher teaThree = new Teacher("t003", "老师3");
		HashMap<Subject,Teacher> hashMap = new HashMap<>();
		//当两次put的key相同的时候，后者覆盖前者
		//hashMap.put(Math, teaOne);
		//hashMap.put(Math, teaTwo);
		//System.out.println(hashMap);
		//对于key的判断，如果key是引用类型的变量，那么判断是否相同就不是判断值而是判断地址
		//hashMap.put(Subject.copy(Math), teaOne);
		//hashMap.put(Subject.copy(Math), teaTwo);
		//System.out.println(hashMap);
		hashMap.put(Subject.copy(Chinese), teaOne);
		hashMap.put(Subject.copy(Math), teaOne);
		hashMap.put(Subject.copy(Java), teaOne);
		hashMap.put(Subject.copy(Chinese), teaTwo);
		hashMap.put(Subject.copy(Math), teaTwo);
		hashMap.put(Subject.copy(C_Program), teaTwo);
		hashMap.put(Subject.copy(Chinese), teaThree);
		hashMap.put(Subject.copy(Math), teaThree);		
		HashMap<Subject, ArrayList<Teacher>> results = new HashMap<>();
		Set<Entry<Subject,Teacher>> subSet = hashMap.entrySet();
		Iterator<Entry<Subject,Teacher>> subIt = subSet.iterator();
		while (subIt.hasNext()) {
			Entry<Subject, Teacher> subEnTry = subIt.next();
			Subject tempSubject = subEnTry.getKey();
			Teacher tempTeacher = subEnTry.getValue();
			ArrayList<Teacher> tempTeachers = this.getTeacherListBySubjectName(tempSubject, results);			
			Subject insertSub = this.getSubjectBySubjectName(tempSubject, results);
			if(insertSub.subNo == null){
				insertSub = tempSubject;
			}
			tempTeachers.add(tempTeacher);				
			results.put(insertSub, tempTeachers);
		}
		this.display(results);
		
//		//将某一位老师的能教授的科目做成ArrayList
//		ArrayList<Subject> subArrayList = new ArrayList<Subject>();
//		subArrayList.add(Chinese);
//		subArrayList.add(Math);
//		subArrayList.add(Java);
//		teaMap.put(teaOne, subArrayList);
//		teaMap.get(teaOne).add(C_Program);
//		System.out.println(subArrayList.size());
		
		
		//同上所述：将某一位老师的能教授的科目做成ArrayList
//		ArrayList<Subject> subArrayList1 = new ArrayList<Subject>();
//		subArrayList1.add(Chinese);
//		subArrayList1.add(Math);
//		subArrayList1.add(C_Program);
//		teaMap.put(teaTwo, subArrayList1);
//		//同上所述：将某一位老师的能教授的科目做成ArrayList
//		ArrayList<Subject> subArrayList2 = new ArrayList<Subject>();
//		subArrayList2.add(Chinese);
//		subArrayList2.add(Math);
//		teaMap.put(teaThree, subArrayList2);
//		//初始化结束
//		
//		Set<Entry<Teacher, ArrayList<Subject>>> teaSet = teaMap.entrySet();
//		Iterator<Entry<Teacher, ArrayList<Subject>>> teaIt = teaSet.iterator();
//		while (teaIt.hasNext()) {
//			//将某位老师和他所能教授的科目存放下来
//			Entry<Teacher, ArrayList<Subject>> teaEnTry = teaIt.next();
//			Teacher tempTeacher = teaEnTry.getKey();
//			ArrayList<Subject> tempSub = teaEnTry.getValue();
//			System.out.println(tempTeacher);// 获取教师
//			System.out.println(tempSub);// 获取课程
//			
//			// 以课程为主键 将教师列表放进value中的ArrayList中
//			for (int i = 0; i < tempSub.size(); i++) {
//				ArrayList<Teacher> tempTeacherList=new ArrayList<Teacher>();
//				//判断该科目是否已经有教师列表，如果有，就获得教师列表
//				if(subMap.get(tempSub.get(i))!=null){
//					tempTeacherList.addAll(subMap.get(tempSub.get(i)));
//				}
//				tempTeacherList.add(tempTeacher);
//				subMap.put(tempSub.get(i), tempTeacherList);
//			}
//		}
//		System.out.println("==================");
//		Set<Entry<Subject, ArrayList<Teacher>>> subSet = subMap.entrySet();
//		Iterator<Entry<Subject, ArrayList<Teacher>>> subIt = subSet.iterator();
//		while (subIt.hasNext()) {
//			Entry<Subject, ArrayList<Teacher>> subEnTry = subIt.next();
//			Subject tempTeacher = subEnTry.getKey();
//			ArrayList<Teacher> tempSub = subEnTry.getValue();
//			System.out.println(tempTeacher);
//			System.out.println(tempSub);
//			
//		}
		
	}

	//根据你的科目名字将已经放入到集合中的老师列表取出
	public ArrayList<Teacher> getTeacherListBySubjectName(Subject sub,
			                    HashMap<Subject, ArrayList<Teacher>> results){
		ArrayList<Teacher> resultTeachers =new ArrayList<Teacher>();
		Set<Entry<Subject, ArrayList<Teacher>>> subSet = results.entrySet();
		Iterator<Entry<Subject, ArrayList<Teacher>>> subIt = subSet.iterator();
		while (subIt.hasNext()) {
			Entry<Subject, ArrayList<Teacher>> subEnTry = subIt.next();
			Subject tempSubject = subEnTry.getKey();
			ArrayList<Teacher> tempTeachers = subEnTry.getValue();
			if(tempSubject.subNo.equals(sub.subNo)){
				resultTeachers = tempTeachers;
			}
		}
		if(resultTeachers.size() == 0){
			results.put(sub, (ArrayList<Teacher>)resultTeachers);
		}
		return resultTeachers;
	}
	//根据你的科目名字将集合中已经插入的科目取出
	public Subject getSubjectBySubjectName(Subject sub,
					HashMap<Subject, ArrayList<Teacher>> results){
		Subject resultSub = new Subject();
		Set<Entry<Subject, ArrayList<Teacher>>> subSet = results.entrySet();
		Iterator<Entry<Subject, ArrayList<Teacher>>> subIt = subSet.iterator();
		while (subIt.hasNext()) {
			Entry<Subject, ArrayList<Teacher>> subEnTry = subIt.next();
			Subject tempSubject = subEnTry.getKey();
			ArrayList<Teacher> tempTeachers = subEnTry.getValue();
			if(tempSubject.subNo.equals(sub.subNo)){
				resultSub = tempSubject;
			}
		}
		return resultSub;
	}

//	public T ergodicBody(int method,Subject sub,Iterator iterator,T temp){
//		while (iterator.hasNext()) {
//			Entry<Subject, ArrayList<Teacher>> subEnTry = (Entry<Subject, ArrayList<Teacher>>) iterator.next();
//			Subject tempSubject = subEnTry.getKey();
//			ArrayList<Teacher> tempTeachers = subEnTry.getValue();
//			if(tempSubject.subNo.equals(sub.subNo)){
//				temp = method == 1 ? tempSubject : tempTeachers;
//			}
//		}
//		return temp;
//	}

	//打印
	public void display(HashMap<Subject, ArrayList<Teacher>> results){
			
			Set<Entry<Subject, ArrayList<Teacher>>> subSet = results.entrySet();
			Iterator<Entry<Subject, ArrayList<Teacher>>> subIt = subSet.iterator();
			while (subIt.hasNext()) {
				Entry<Subject, ArrayList<Teacher>> subEnTry = subIt.next();
				Subject tempSubject = subEnTry.getKey();
				ArrayList<Teacher> tempTeachers = subEnTry.getValue();
				System.out.println(tempSubject+"-----------------");
				System.out.println(tempTeachers);
			}
			
	}
	
	
	public static void main(String[] args) {
		TeaSubTest main1 = new TeaSubTest();
		main1.init();

	}
}
