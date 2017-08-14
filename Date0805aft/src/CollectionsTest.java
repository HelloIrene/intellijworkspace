import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		//Collection�Ǹ��ӿڣ���List��Set�Ĺ淶��
		//Collections�Ǹ������࣬�кܶೣ�÷�������������������ԱЧ��
		//ArraysҲ��һ�������࣬Ҳ�кܶೣ�÷�������ԵĲ���List����Ե�������
		//Collection al = new ArrayList();		
		//Collections.sort(list);
		CollectionsTest.getMax();
//		Arrays.a
		Arrays.asList();
	}
	//sort�ͱȽ��������
	public static void collSort(){
		List<Film> films = new ArrayList<Film>();
		Film filmOne = new Film("ս��2","�⾩","20170728");
		Film filmTwo = new Film("��������ʮ���һ�","�����","20170803");
		Film filmThree = new Film("������ҵ","�ö���","20170728");
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
		Film filmOne = new Film("ս��2","�⾩","20170728");
		Film filmTwo = new Film("��������ʮ���һ�","�����","20170803");
		Film filmThree = new Film("������ҵ","�ö���","20170728");
		Film filmFour = new Film("test","test","20170728");
		films.add(filmOne);
		films.add(filmTwo);
		films.add(filmThree);
		Collections.sort(films,new MyCompareByActor());
		System.out.println(Collections.binarySearch(films,filmTwo));
	}
	
	public static void getMax(){
		List<Film> films = new ArrayList<Film>();
		Film filmOne = new Film("ս��2","�⾩","20170728");
		Film filmTwo = new Film("��������ʮ���һ�","�����","20170803");
		Film filmThree = new Film("������ҵ","�ö���","20170728");
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
