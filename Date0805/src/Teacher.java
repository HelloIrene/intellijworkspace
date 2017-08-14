

public class Teacher {
	public String teaNo;
	public String teaName;
	public Teacher(){
		
	}
	public Teacher(String teaNo,String teaName){
		this.teaName=teaName;
		this.teaNo=teaNo;
	}
	public String toString(){
		return "教师名称："+this.teaName+",教师编号:"+this.teaNo;
	}
}
