import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Shop {
	//��һ��С��Ʒ��key�����ǵĶ�ά�룬value�������ǵ�С��Ʒ�����ơ�Ʒ�ơ����ۣ�
	//HashMap
	//1.ͬһ��Ʒ�Ƹ����ж���С��Ʒ
	//2.��������500����Ʒ
	//����һ����Ʒֻ��1��
	public HashMap<String,Goods> shGoods;
	public String key;
	public Shop(){
		this.shGoods=new HashMap<String,Goods>();
		this.key="0001";
	}
	public boolean addGood(Goods good) {//��������Ʒ����ά���Զ���һ0002
		this.key = String.format("%04d", (Integer.valueOf(this.key) + 1));
		this.shGoods.put(this.key, good);
		return true;
	}
	public HashMap<String, Goods> minimumPrice(int prices) {
		// TODO Auto-generated method stub
		HashMap<String,Goods> tempGoods = new HashMap<String,Goods>();
		Set<Entry<String,Goods>>entrySet = this.shGoods.entrySet();
		Iterator<Entry<String,Goods>>itEntry = entrySet.iterator();
		while(itEntry.hasNext()){//�۸�ıȽ�
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
		while (itEntry.hasNext()) {//ɸѡͬ����Ʒ
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
