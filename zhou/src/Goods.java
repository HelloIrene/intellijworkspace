//С��Ʒ�����ơ�Ʒ�ơ����ۣ�
public class Goods {
	public String name;
	public String brand;
	public double price;
	
	public Goods(){
		
	}
	
	public Goods(String name, String brand, double price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "��Ʒ���ƣ�"+name+",��ƷƷ�ƣ�"+brand+",��Ʒ����"+price;
	}
	
}
