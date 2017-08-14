import java.util.HashMap;

public class Goods {
	//做一组小商品，key是我们的二维码，value就是我们的小商品（名称、品牌、单价）
	//1.同一个品牌各自有多少小商品
	//2.单价少于500的商品
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
		return "种类"+kinds+","+"名称"+name+","+"单价"+prices+"\n";
		
	}
}
	
