package teacherSubject;

import java.util.ArrayList;

//完成两个实体类分别老师（工号和姓名）和科目（科目编号，名称，备注）；
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
		return "名字："+this.name+" 工号："+this.teaNo;
	}
}
