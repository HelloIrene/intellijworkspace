import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Shop {
	//做一组小商品，key是我们的二维码，value就是我们的小商品（名称、品牌、单价）
	//HashMap
	//1.同一个品牌各自有多少小商品
	//2.单价少于500的商品
	//假设一种商品只有1件
	public HashMap<String,Goods> shGoods;
	public String key;
	public Shop(){
		this.shGoods=new HashMap<String,Goods>();
		this.key="0001";
	}
	public boolean addGood(Goods good) {//新增的商品，二维码自动加一0002
		this.key = String.format("%04d", (Integer.valueOf(this.key) + 1));
		this.shGoods.put(this.key, good);
		return true;
	}
	public HashMap<String, Goods> minimumPrice(int prices) {
		// TODO Auto-generated method stub
		HashMap<String,Goods> tempGoods = new HashMap<String,Goods>();
		Set<Entry<String,Goods>>entrySet = this.shGoods.entrySet();
		Iterator<Entry<String,Goods>>itEntry = entrySet.iterator();
		while(itEntry.hasNext()){//价格的比较
			Entry<String,Goods> tempEntry = itEntry.next();
			if(prices>tempEntry.getValue().prices){
				tempGoods.put(tempEntry.getKey(), tempEntry.getValue());
			}
		}		
		return tempGoods;
	}
	public HashMap<String, Goods> countkind(String kinds) {
		// TODO Auto-generated method stub
		HashMap<String, Goods> tempGoods = new HashMap<String, Goods>();
		Set<Entry<String, Goods>> entrySet = shGoods.entrySet();
		Iterator<Entry<String, Goods>> itEntry = entrySet.iterator();
		while (itEntry.hasNext()) {//筛选同种商品
			Entry<String, Goods> tempEntry = itEntry.next();
			if (kinds.equals(tempEntry.getValue().kinds)) {
				tempGoods.put(tempEntry.getKey(), tempEntry.getValue());
				}
		}
		return tempGoods;
	
}
	
	@Override
	public String toString() {
		return "Shop [  shGoods=" + shGoods + ", key=" + key + "]";
	}
	public Iterator<Entry<String,Goods>> getshGoodsIterator(){
		return this.shGoods.entrySet().iterator();
	}
}
