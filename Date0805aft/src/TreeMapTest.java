import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
//TreeSet:插入元素
//TreeMap:插入元素几乎相同，因为原理相同，都是基于二叉树的，也就是符合我们左小右大的原则
//HashTable:哈希表，HashTable和HashMap之间的关系就相当于Vector和ArrayList之间的关系
//老版本，线程同步，效率低下，方法较少，不常应用
//比较学习方法、层次学习方法
public class TreeMapTest {

	public static void main(String[] args) {
		TreeMapTest.display();
	}
	//1.利用key元素自带的比较属性进行排序，最终插入数据
	public static void inputDataOne(){
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
		treeMap.put(25, "1战狼2");
		treeMap.put(10, "2三生三世十里桃花");
		treeMap.put(8, "3建军大业");		
		System.out.println(treeMap);
	}
	//2.如果key是自定义类，没有自带的比较属性，那怎么办,让自定义类去实现Comparable的接口方法即可
	public static void inputDataTwo(){
		TreeMap<Film,Integer> treeMap = new TreeMap<Film,Integer>();
		Film filmOne = new Film("战狼2","吴京","20170728");
		Film filmTwo = new Film("三生三世十里桃花","刘亦菲","20170803");
		Film filmThree = new Film("建军大业","好多人","20170728");
		treeMap.put(filmOne, 25);
		treeMap.put(filmTwo, 10);
		treeMap.put(filmThree, 8);		
		System.out.println(treeMap);
	}
	//3.如果key是自定义类，没有自带的比较属性，也没有自定义的比较属性，那怎么办,让初始化TreeMap传入比较器
	public static void inputDataThree(){
		TreeMap<Film,Integer> treeMap = new TreeMap<Film,Integer>(new MyCompareByActor());
		Film filmOne = new Film("战狼2","吴京","20170728");
		Film filmTwo = new Film("三生三世十里桃花","刘亦菲","20170803");
		Film filmThree = new Film("建军大业","好多人","20170728");
		treeMap.put(filmOne, 25);
		treeMap.put(filmTwo, 10);
		treeMap.put(filmThree, 8);		
		System.out.println(treeMap);
	}
	
	public static void display(){
		TreeMap<Film,Integer> treeMap = new TreeMap<Film,Integer>(new MyCompareByActor());
		Film filmOne = new Film("战狼2","吴京","20170728");
		Film filmTwo = new Film("三生三世十里桃花","刘亦菲","20170803");
		Film filmThree = new Film("建军大业","好多人","20170728");
		treeMap.put(filmOne, 25);
		treeMap.put(filmTwo, 10);
		treeMap.put(filmThree, 8);	
		
		Set<Entry<Film,Integer>> entries = treeMap.entrySet();
		Iterator<Entry<Film,Integer>> it = entries.iterator();
		while(it.hasNext()){
			Entry<Film,Integer> tmpEntry = it.next();
			Film tmpFilm = tmpEntry.getKey();
			Integer price = tmpEntry.getValue();
			System.out.println("一部叫做"+tmpFilm.name+"的电影，是由"+tmpFilm.actor+"来主演，自"+tmpFilm.startDate+"上演一来，创造"+price+"的奇迹");
		}
	}
}
