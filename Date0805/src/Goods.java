import java.util.HashMap;

public class Goods {
	//��һ��С��Ʒ��key�����ǵĶ�ά�룬value�������ǵ�С��Ʒ�����ơ�Ʒ�ơ����ۣ�
	//1.ͬһ��Ʒ�Ƹ����ж���С��Ʒ
	//2.��������500����Ʒ
	public String name;
	public String kinds;
	public int prices;
	public int count;
	public Goods(){
 
	}
	
	public Goods(String name,String kinds,int prices,int count){
		this.name=name;
		this.kinds=kinds;
		this.prices=prices;
		this.count=1;
	}
	
	public String toString(){
		return "����"+kinds+","+"����"+name+","+"����"+prices+"\n";
		
	}
}
	
