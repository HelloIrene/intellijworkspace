import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

//��һ��С��Ʒ��key�����ǵĶ�ά�룬value�������ǵ�С��Ʒ�����ơ�Ʒ�ơ����ۣ�
//HashMap
//1.ͬһ��Ʒ�Ƹ����ж���С��Ʒ
//2.��������500����Ʒ
//����һ����Ʒֻ��1��
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

	// �����Ʒ
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

	// ��ʾ������Ʒ
	public void displayGoods(HashMap<String, Goods> hm) {
		Set<Entry<String, Goods>> entries = hm.entrySet();
		Iterator itEntry = entries.iterator();
		while (itEntry.hasNext()) {
			Entry<String, Goods> tmpEtr = (Entry<String, Goods>) itEntry.next();
			System.out.println(tmpEtr.getKey() + ":" + tmpEtr.getValue());
		}
	}

	// ͨ��Ʒ��������ʾ��Ʒ(���е���brandCount����)
	public void disPlayByBrand(HashMap<String, Goods> hm) {
		HashMap<String, Integer> count = new HashMap<String, Integer>();// ���ٸ�Ʒ��
		Set<Entry<String, Goods>> entries = hm.entrySet();// ȫ����Ʒ
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
			System.out.print(tmp.getKey() + "Ʒ����" + tmp.getValue() + "��\n");
		}
	}

	// ��ͬ����Ʒ���ж��ٸ�
	public Integer brandCount(HashMap<String, Goods> hm, String brand) {
		Integer bCount = 0;// ����
		Set<Entry<String, Goods>> entries = hm.entrySet();
		Iterator itEntry = entries.iterator();
		while (itEntry.hasNext()) {
			Entry<String, Goods> tmpEtr = (Entry<String, Goods>) itEntry.next();
			if (tmpEtr.getValue().getBrand() == brand) {// �жϵõ���Ʒ���Ƿ���֮ǰ��������
				bCount += 1;
			}
		}
		// System.out.println( + ":" + bCount);
		return bCount;
	}

	// ͨ���۸�������ʾ��Ʒ
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
