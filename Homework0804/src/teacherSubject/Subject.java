package teacherSubject;

import java.util.ArrayList;

//�������ʵ����ֱ���ʦ�����ź��������Ϳ�Ŀ����Ŀ��ţ����ƣ���ע����
public class Subject {
	public String subNo;
	public String name;
	public String remake;
	public ArrayList<Teacher> teaName;

	public ArrayList addTeaName(Teacher teacher){
		this.teaName.add(teacher);
		return this.teaName;
	}
	
	public String getSubNo() {
		return subNo;
	}

	public void setSubNo(String subNo) {
		this.subNo = subNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemake() {
		return remake;
	}

	public void setRemake(String remake) {
		this.remake = remake;
	}

	public ArrayList<Teacher> getTeaName() {
		return teaName;
	}

	public void setTeaName(ArrayList<Teacher> teaName) {
		this.teaName = teaName;
	}

	public Subject(String subNo,String name,String remake){
		this.name=name;
		this.remake=remake;
		this.subNo=subNo;
		teaName = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "��Ŀ��ţ�"+this.subNo+" ���ƣ�"+this.name+" ��ע��"+this.remake;
	}
}
