package smallWare;

public class Good {
	//做一组小商品，key是我们的二维码，value就是我们的小商品（名称、品牌、单价）
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
		 return "小商品："+this.name+" 品牌："+this.brand+" 单价："+this.price+"\n";
	}
}
