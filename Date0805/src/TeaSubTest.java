import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class TeaSubTest {
	//�����������һ��HashMap��������Ŀ�������Ǽ�����ʦ�ܽ���
	HashMap<Subject, ArrayList<Teacher>> subMap = new HashMap<>();
	//��֪��������һ��HashMap��������ʦ�ܽ�����Щ��Ŀ
	HashMap<Teacher, ArrayList<Subject>> teaMap = new HashMap<>();
 
	public void init() {
		//׼��ԭʼ��Ŀ
		Subject Chinese = new Subject("001", "����", "***");
		Subject Math = new Subject("002", "��ѧ", "***");
		Subject Java = new Subject("003", "Java", "*");
		Subject C_Program = new Subject("004", " C_Program", "*");
		//׼����ʼ��ʦ
		Teacher teaOne = new Teacher("t001", "��ʦ1");
		Teacher teaTwo = new Teacher("t002", "��ʦ2");
		Teacher teaThree = new Teacher("t003", "��ʦ3");
		HashMap<Subject,Teacher> hashMap = new HashMap<>();
		//������put��key��ͬ��ʱ�򣬺��߸���ǰ��
		//hashMap.put(Math, teaOne);
		//hashMap.put(Math, teaTwo);
		//System.out.println(hashMap);
		//����key���жϣ����key���������͵ı�������ô�ж��Ƿ���ͬ�Ͳ����ж�ֵ�����жϵ�ַ
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
		
//		//��ĳһλ��ʦ���ܽ��ڵĿ�Ŀ����ArrayList
//		ArrayList<Subject> subArrayList = new ArrayList<Subject>();
//		subArrayList.add(Chinese);
//		subArrayList.add(Math);
//		subArrayList.add(Java);
//		teaMap.put(teaOne, subArrayList);
//		teaMap.get(teaOne).add(C_Program);
//		System.out.println(subArrayList.size());
		
		
		//ͬ����������ĳһλ��ʦ���ܽ��ڵĿ�Ŀ����ArrayList
//		ArrayList<Subject> subArrayList1 = new ArrayList<Subject>();
//		subArrayList1.add(Chinese);
//		subArrayList1.add(Math);
//		subArrayList1.add(C_Program);
//		teaMap.put(teaTwo, subArrayList1);
//		//ͬ����������ĳһλ��ʦ���ܽ��ڵĿ�Ŀ����ArrayList
//		ArrayList<Subject> subArrayList2 = new ArrayList<Subject>();
//		subArrayList2.add(Chinese);
//		subArrayList2.add(Math);
//		teaMap.put(teaThree, subArrayList2);
//		//��ʼ������
//		
//		Set<Entry<Teacher, ArrayList<Subject>>> teaSet = teaMap.entrySet();
//		Iterator<Entry<Teacher, ArrayList<Subject>>> teaIt = teaSet.iterator();
//		while (teaIt.hasNext()) {
//			//��ĳλ��ʦ�������ܽ��ڵĿ�Ŀ�������
//			Entry<Teacher, ArrayList<Subject>> teaEnTry = teaIt.next();
//			Teacher tempTeacher = teaEnTry.getKey();
//			ArrayList<Subject> tempSub = teaEnTry.getValue();
//			System.out.println(tempTeacher);// ��ȡ��ʦ
//			System.out.println(tempSub);// ��ȡ�γ�
//			
//			// �Կγ�Ϊ���� ����ʦ�б�Ž�value�е�ArrayList��
//			for (int i = 0; i < tempSub.size(); i++) {
//				ArrayList<Teacher> tempTeacherList=new ArrayList<Teacher>();
//				//�жϸÿ�Ŀ�Ƿ��Ѿ��н�ʦ�б�����У��ͻ�ý�ʦ�б�
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

	//������Ŀ�Ŀ���ֽ��Ѿ����뵽�����е���ʦ�б�ȡ��
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
	//������Ŀ�Ŀ���ֽ��������Ѿ�����Ŀ�Ŀȡ��
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

	//��ӡ
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
