//小商品（名称、品牌、单价）
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
		return "商品名称："+name+",商品品牌："+brand+",商品单价"+price;
	}
	
}
