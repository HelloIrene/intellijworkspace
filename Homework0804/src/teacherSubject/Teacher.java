package teacherSubject;

import java.util.ArrayList;

//�������ʵ����ֱ���ʦ�����ź��������Ϳ�Ŀ����Ŀ��ţ����ƣ���ע����
public class Teacher {
	public String teaNo;
	public String name;
	public ArrayList<Subject> subName;
	
	public void addSubject(Subject sub){
		this.getSubName().add(sub);
	}
	
	public String getTeaNo() {
		return teaNo;
	}

	public void setTeaNo(String teaNo) {
		this.teaNo = teaNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Subject> getSubName() {
		return subName;
	}

	public void setSubName(ArrayList<Subject> subName) {
		this.subName = subName;
	}

	public Teacher(String teaNo,String name){
		this.name=name;
		this.teaNo=teaNo;
		subName = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "���֣�"+this.name+" ���ţ�"+this.teaNo;
	}
}
