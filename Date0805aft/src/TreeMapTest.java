import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
//TreeSet:����Ԫ��
//TreeMap:����Ԫ�ؼ�����ͬ����Ϊԭ����ͬ�����ǻ��ڶ������ģ�Ҳ���Ƿ���������С�Ҵ��ԭ��
//HashTable:��ϣ��HashTable��HashMap֮��Ĺ�ϵ���൱��Vector��ArrayList֮��Ĺ�ϵ
//�ϰ汾���߳�ͬ����Ч�ʵ��£��������٣�����Ӧ��
//�Ƚ�ѧϰ���������ѧϰ����
public class TreeMapTest {

	public static void main(String[] args) {
		TreeMapTest.display();
	}
	//1.����keyԪ���Դ��ıȽ����Խ����������ղ�������
	public static void inputDataOne(){
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
		treeMap.put(25, "1ս��2");
		treeMap.put(10, "2��������ʮ���һ�");
		treeMap.put(8, "3������ҵ");		
		System.out.println(treeMap);
	}
	//2.���key���Զ����࣬û���Դ��ıȽ����ԣ�����ô��,���Զ�����ȥʵ��Comparable�Ľӿڷ�������
	public static void inputDataTwo(){
		TreeMap<Film,Integer> treeMap = new TreeMap<Film,Integer>();
		Film filmOne = new Film("ս��2","�⾩","20170728");
		Film filmTwo = new Film("��������ʮ���һ�","�����","20170803");
		Film filmThree = new Film("������ҵ","�ö���","20170728");
		treeMap.put(filmOne, 25);
		treeMap.put(filmTwo, 10);
		treeMap.put(filmThree, 8);		
		System.out.println(treeMap);
	}
	//3.���key���Զ����࣬û���Դ��ıȽ����ԣ�Ҳû���Զ���ıȽ����ԣ�����ô��,�ó�ʼ��TreeMap����Ƚ���
	public static void inputDataThree(){
		TreeMap<Film,Integer> treeMap = new TreeMap<Film,Integer>(new MyCompareByActor());
		Film filmOne = new Film("ս��2","�⾩","20170728");
		Film filmTwo = new Film("��������ʮ���һ�","�����","20170803");
		Film filmThree = new Film("������ҵ","�ö���","20170728");
		treeMap.put(filmOne, 25);
		treeMap.put(filmTwo, 10);
		treeMap.put(filmThree, 8);		
		System.out.println(treeMap);
	}
	
	public static void display(){
		TreeMap<Film,Integer> treeMap = new TreeMap<Film,Integer>(new MyCompareByActor());
		Film filmOne = new Film("ս��2","�⾩","20170728");
		Film filmTwo = new Film("��������ʮ���һ�","�����","20170803");
		Film filmThree = new Film("������ҵ","�ö���","20170728");
		treeMap.put(filmOne, 25);
		treeMap.put(filmTwo, 10);
		treeMap.put(filmThree, 8);	
		
		Set<Entry<Film,Integer>> entries = treeMap.entrySet();
		Iterator<Entry<Film,Integer>> it = entries.iterator();
		while(it.hasNext()){
			Entry<Film,Integer> tmpEntry = it.next();
			Film tmpFilm = tmpEntry.getKey();
			Integer price = tmpEntry.getValue();
			System.out.println("һ������"+tmpFilm.name+"�ĵ�Ӱ������"+tmpFilm.actor+"�����ݣ���"+tmpFilm.startDate+"����һ��������"+price+"���漣");
		}
	}
}
