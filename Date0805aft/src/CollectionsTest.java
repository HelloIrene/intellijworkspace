import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		//Collection是个接口，是List和Set的规范，
		//Collections是个工具类，有很多常用方法，有利于提升程序员效率
		//Arrays也是一个工具类，也有很多常用方法，针对的不是List，针对的是数组
		//Collection al = new ArrayList();		
		//Collections.sort(list);
		CollectionsTest.getMax();
//		Arrays.a
		Arrays.asList();
	}
	//sort和比较密切相关
	public static void collSort(){
		List<Film> films = new ArrayList<Film>();
		Film filmOne = new Film("战狼2","吴京","20170728");
		Film filmTwo = new Film("三生三世十里桃花","刘亦菲","20170803");
		Film filmThree = new Film("建军大业","好多人","20170728");
		films.add(filmOne);
		films.add(filmTwo);
		films.add(filmThree);
		Collections.sort(films,new MyCompareByActor());
		System.out.println(films.get(0).name);
		System.out.println(films.get(1).name);
		System.out.println(films.get(2).name);
	}
	
	public static void searchData(){
		List<Film> films = new ArrayList<Film>();
		Film filmOne = new Film("战狼2","吴京","20170728");
		Film filmTwo = new Film("三生三世十里桃花","刘亦菲","20170803");
		Film filmThree = new Film("建军大业","好多人","20170728");
		Film filmFour = new Film("test","test","20170728");
		films.add(filmOne);
		films.add(filmTwo);
		films.add(filmThree);
		Collections.sort(films,new MyCompareByActor());
		System.out.println(Collections.binarySearch(films,filmTwo));
	}
	
	public static void getMax(){
		List<Film> films = new ArrayList<Film>();
		Film filmOne = new Film("战狼2","吴京","20170728");
		Film filmTwo = new Film("三生三世十里桃花","刘亦菲","20170803");
		Film filmThree = new Film("建军大业","好多人","20170728");
		Film filmFour = new Film("test","test","20170728");
		films.add(filmOne);
		films.add(filmTwo);
		films.add(filmThree);
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(52);
		numbers.add(49);
		numbers.add(95);
		Collections.sort(numbers);
		System.out.println(Collections.max(numbers));
	}

}
