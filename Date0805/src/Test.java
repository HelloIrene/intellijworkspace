import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
//做一组小商品，key是我们的二维码，value就是我们的小商品（名称、品牌、单价）
//HashMap
//1.同一个品牌各自有多少小商品
//2.单价少于500的商品
//假设一种商品只有1件
	public static void main(String[] args) {
		Shop shop = new Shop();
		Goods good = new Goods("旺旺小小酥", "旺旺", 500,1);
		Goods good1 = new Goods("旺旺雪饼", "旺旺", 655,1);
		Goods good2 = new Goods("AD钙奶", "娃哈哈", 799,1);
		Goods good3 = new Goods("康师傅红烧面", "康师傅", 5545,1);
		Goods good4 = new Goods("康师傅冰红茶", "康师傅", 21,1);
		shop.addGood(good);
		shop.addGood(good1);
		shop.addGood(good2);
		shop.addGood(good3);
		shop.addGood(good4);
   
        //遍历keys
//        Collection<Goods> goods = hmFinal.values();
//        Set<Entry<String,Goods>> entries = hmFinal.entrySet();
//		Iterator itEntry = entries.iterator();
		Iterator<Entry<String, Goods>> goodsIterator=shop.getshGoodsIterator();//显示商品信息
		while(goodsIterator.hasNext()){
			Entry<String, Goods> tempEntry= goodsIterator.next();
			System.out.println("二维码："+tempEntry.getKey()+"商品信息："+tempEntry.getValue());
		}
		HashMap<String,Goods> tempGoods= shop.countkind("旺旺");//商品的品牌
		System.out.println(tempGoods);
		tempGoods=shop.minimumPrice(500);//商品价格小于500的商品信息
		System.out.println(tempGoods);
		}
	}
//		{
//			MapTest mt = new MapTest();
//			mt.displayMap();
//		}
//	}
	//插入元素
//	private void displayMap() {
//	          // TODO Auto-generated method stub
//        	Goods good = new Goods("旺旺小小酥", "旺旺", 5);
//            Goods good1 = new Goods("旺旺雪饼", "旺旺", 6);
//            Goods good2 = new Goods("AD钙奶", "娃哈哈", 7);
//            Goods good3 = new Goods("康师傅红烧面", "康师傅", 5);
//            Goods good4 = new Goods("康师傅冰红茶", "康师傅", 2);
//            HashMap<String,Goods> hmFinal = new HashMap<String,Goods>();
//            hmFinal.put("2017080401", good);
//            hmFinal.put("2017080402", good1);
//            hmFinal.put("2017080403", good2);
//            HashMap<String,Goods> hmPart  = new HashMap<String,Goods>();
//            hmFinal.put("2017080404", good3);
//            hmFinal.put("2017080405", good4);
//            hmFinal.putAll(hmPart);
//           System.out.print(hmFinal);
//         }

	

