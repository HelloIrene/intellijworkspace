import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

//做一组小商品，key是我们的二维码，value就是我们的小商品（名称、品牌、单价）
//HashMap
//1.同一个品牌各自有多少小商品
//2.单价少于500的商品
//假设一种商品只有1件
public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapTest mt = new MapTest();
		HashMap<String, Goods> myhm = new HashMap<String, Goods>();
		myhm = mt.insertGoods();
		mt.displayGoods(myhm);
		System.out.println("******************************");
		mt.disPlayByPrice(myhm);
		System.out.println("******************************");
		mt.disPlayByBrand(myhm);
		;
	}

	// 添加商品
	public HashMap<String, Goods> insertGoods() {
		Goods good = new Goods("rice", "TianTang", 21);
		Goods goodOne = new Goods("knife", "zhangXiaoQuan", 16);
		Goods goodTwo = new Goods("soybean milk machine", "JiuYang", 512);
		Goods goodThree = new Goods("umbrella", "TianTang", 30);

		HashMap<String, Goods> hm = new HashMap<String, Goods>();
		hm.put("QR001", good);
		hm.put("QR002", goodOne);
		hm.put("QR003", goodTwo);
		hm.put("QR004", goodThree);
		return hm;
	}

	// 显示所有商品
	public void displayGoods(HashMap<String, Goods> hm) {
		Set<Entry<String, Goods>> entries = hm.entrySet();
		Iterator itEntry = entries.iterator();
		while (itEntry.hasNext()) {
			Entry<String, Goods> tmpEtr = (Entry<String, Goods>) itEntry.next();
			System.out.println(tmpEtr.getKey() + ":" + tmpEtr.getValue());
		}
	}

	// 通过品牌条件显示商品(其中调用brandCount方法)
	public void disPlayByBrand(HashMap<String, Goods> hm) {
		HashMap<String, Integer> count = new HashMap<String, Integer>();// 多少个品牌
		Set<Entry<String, Goods>> entries = hm.entrySet();// 全部商品
		Iterator itEntry = entries.iterator();
		while (itEntry.hasNext()) {
			Entry<String, Goods> tmpEtr = (Entry<String, Goods>) itEntry.next();
			if (!(count.containsKey(tmpEtr.getValue().brand))) {
				count.put(tmpEtr.getValue().getBrand(),
						this.brandCount(hm, tmpEtr.getValue().getBrand()));
			}
		}
		Set<Entry<String, Integer>> P = count.entrySet();
		Iterator itEntryP = P.iterator();
		while (itEntryP.hasNext()) {
			Entry<String, Integer> tmp = (Entry<String, Integer>) itEntryP
					.next();
			System.out.print(tmp.getKey() + "品牌有" + tmp.getValue() + "个\n");
		}
	}

	// 计同样的品牌有多少个
	public Integer brandCount(HashMap<String, Goods> hm, String brand) {
		Integer bCount = 0;// 计数
		Set<Entry<String, Goods>> entries = hm.entrySet();
		Iterator itEntry = entries.iterator();
		while (itEntry.hasNext()) {
			Entry<String, Goods> tmpEtr = (Entry<String, Goods>) itEntry.next();
			if (tmpEtr.getValue().getBrand() == brand) {// 判断得到的品牌是否是之前传进来的
				bCount += 1;
			}
		}
		// System.out.println( + ":" + bCount);
		return bCount;
	}

	// 通过价格条件显示商品
	public void disPlayByPrice(HashMap<String, Goods> temp) {
		Set<Entry<String, Goods>> entries = temp.entrySet();
		Iterator itEntry = entries.iterator();
		while (itEntry.hasNext()) {
			Entry<String, Goods> tmpEtr = (Entry<String, Goods>) itEntry.next();
			if (tmpEtr.getValue().price >= 500) {
				continue;
			}
			System.out.println(tmpEtr.getKey() + ":" + tmpEtr.getValue());
		}
	}

}
