package smallWare;

public class Good {
	//��һ��С��Ʒ��key�����ǵĶ�ά�룬value�������ǵ�С��Ʒ�����ơ�Ʒ�ơ����ۣ�
	public String name;
	public String brand;
	public float price;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Good (){
		this("aa","bb",0);
	}
	public Good (String name,String brand,float price){
		this.name=name;
		this.brand=brand;
		this.price=price;
	}
	public String toString(){
		 return "С��Ʒ��"+this.name+" Ʒ�ƣ�"+this.brand+" ���ۣ�"+this.price+"\n";
	}
}
