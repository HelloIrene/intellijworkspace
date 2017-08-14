package smallWare;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * smallWare Sys
 * 
 * @author student Ross
 *
 */
/*
 * ��һ��С��Ʒ��key�����ǵĶ�ά�룬value�������ǵ�С��Ʒ�����ơ�Ʒ�ơ����ۣ�
 * HashMap
 * 1.ͬһ��Ʒ�Ƹ����ж���С��Ʒ
 * 2.��������500����Ʒ
 * ����һ����Ʒֻ��1��
 */
public class Test {

	public static void main(String[] args) {
		 Test te = new Test();
		 HashMap<String,Good> hmTest;
		 hmTest=te.setInf();
		 te.less500(hmTest);
		 te.brandCount(hmTest);
	}
	
	public HashMap<String,Good> setInf(){
		HashMap<String,Good> hm = new HashMap<>();
		hm.put("001", new Good("aa", "AA",100));
		hm.put("002", new Good("bb", "CC",200));
		hm.put("003", new Good("cc", "AA",500));
		hm.put("004", new Good("dd", "BB",550));
		hm.put("005", new Good("ee", "AA",1000));
		return hm;
	}
	
	public Integer brandCountBody(HashMap<String,Good> temp,String tempBrand){
		Integer brandCount=0;
		Set<Entry<String,Good>> entries = temp.entrySet();
		Iterator itEntry = entries.iterator();
		while(itEntry.hasNext()){	
			Entry<String,Good> tmpEtr = (Entry<String,Good>)itEntry.next();
			if(tmpEtr.getValue().getBrand()==tempBrand){
				brandCount+=1;
			}
		}
		return brandCount;	
	}
	
	//2.��������500����Ʒ
	public void less500(HashMap<String,Good> temp){
		Set<Entry<String,Good>> entries = temp.entrySet();
		Iterator itEntry = entries.iterator();
		while(itEntry.hasNext()){	
			Entry<String,Good> tmpEtr = (Entry<String,Good>)itEntry.next();
			if(tmpEtr.getValue().price>=500){
				continue;
			}
			System.out.print(tmpEtr.getKey() + ":" + tmpEtr.getValue());
		}	
	}
	
	//1.ͬһ��Ʒ�Ƹ����ж���С��Ʒ
	public void brandCount(HashMap<String,Good> temp){
		HashMap<String,Integer> count = new HashMap<>();
		Set<Entry<String,Good>> entries = temp.entrySet();
		Iterator itEntry = entries.iterator();
		while(itEntry.hasNext()){	
			Entry<String,Good> tmpEtr = (Entry<String,Good>)itEntry.next();
			if(!(count.containsKey(tmpEtr.getValue().getBrand()))){
				count.put(tmpEtr.getValue().getBrand(),this.brandCountBody(temp, tmpEtr.getValue().getBrand()));					
			}
		}
		this.print(count);
	}
	
	public void print(HashMap count){
		Set<Entry<String,Integer>> entries = count.entrySet();
		Iterator itEntry = entries.iterator();
		while(itEntry.hasNext()){	
			Entry<String,Integer> tmp = (Entry<String,Integer>)itEntry.next();
			System.out.print(tmp.getKey() + "Ʒ����" + tmp.getValue()+"��\n");
		}
	}
	
}
