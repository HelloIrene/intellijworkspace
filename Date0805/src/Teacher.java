

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
		return "��ʦ���ƣ�"+this.teaName+",��ʦ���:"+this.teaNo;
	}
}
