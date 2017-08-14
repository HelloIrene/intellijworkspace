

import java.util.ArrayList;

public class Subject {
	public String subNo;//科目号
	public String subName;//科目名称
	public String remark;//备注
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
		return "科目号：" + this.subNo + "，科目名称：" + subName + "，备注：" + remark;
	}
	
	
}
