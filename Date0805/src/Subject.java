

import java.util.ArrayList;

public class Subject {
	public String subNo;//��Ŀ��
	public String subName;//��Ŀ����
	public String remark;//��ע
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	public Subject(String subNo,String subName,String remark) {
		// TODO Auto-generated constructor stub
		this.subNo=subNo;
		this.subName=subName;
		this.remark=remark;
	}
	
	public static Subject copy(Subject sub){
		Subject result = new Subject();
		result.subNo = sub.subNo;
		result.subName = sub.subName;
		result.remark = sub.remark;
		return result;
	}
	
	
	@Override
	public String toString() {
		return "��Ŀ�ţ�" + this.subNo + "����Ŀ���ƣ�" + subName + "����ע��" + remark;
	}
	
	
}
