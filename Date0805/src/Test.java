import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
//��һ��С��Ʒ��key�����ǵĶ�ά�룬value�������ǵ�С��Ʒ�����ơ�Ʒ�ơ����ۣ�
//HashMap
//1.ͬһ��Ʒ�Ƹ����ж���С��Ʒ
//2.��������500����Ʒ
//����һ����Ʒֻ��1��
	public static void main(String[] args) {
		Shop shop = new Shop();
		Goods good = new Goods("����СС��", "����", 500,1);
		Goods good1 = new Goods("����ѩ��", "����", 655,1);
		Goods good2 = new Goods("AD����", "�޹���", 799,1);
		Goods good3 = new Goods("��ʦ��������", "��ʦ��", 5545,1);
		Goods good4 = new Goods("��ʦ�������", "��ʦ��", 21,1);
		shop.addGood(good);
		shop.addGood(good1);
		shop.addGood(good2);
		shop.addGood(good3);
		shop.addGood(good4);
   
        //����keys
//        Collection<Goods> goods = hmFinal.values();
//        Set<Entry<String,Goods>> entries = hmFinal.entrySet();
//		Iterator itEntry = entries.iterator();
		Iterator<Entry<String, Goods>> goodsIterator=shop.getshGoodsIterator();//��ʾ��Ʒ��Ϣ
		while(goodsIterator.hasNext()){
			Entry<String, Goods> tempEntry= goodsIterator.next();
			System.out.println("��ά�룺"+tempEntry.getKey()+"��Ʒ��Ϣ��"+tempEntry.getValue());
		}
		HashMap<String,Goods> tempGoods= shop.countkind("����");//��Ʒ��Ʒ��
		System.out.println(tempGoods);
		tempGoods=shop.minimumPrice(500);//��Ʒ�۸�С��500����Ʒ��Ϣ
		System.out.println(tempGoods);
		}
	}
//		{
//			MapTest mt = new MapTest();
//			mt.displayMap();
//		}
//	}
	//����Ԫ��
//	private void displayMap() {
//	          // TODO Auto-generated method stub
//        	Goods good = new Goods("����СС��", "����", 5);
//            Goods good1 = new Goods("����ѩ��", "����", 6);
//            Goods good2 = new Goods("AD����", "�޹���", 7);
//            Goods good3 = new Goods("��ʦ��������", "��ʦ��", 5);
//            Goods good4 = new Goods("��ʦ�������", "��ʦ��", 2);
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

	

