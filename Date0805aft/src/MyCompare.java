import java.util.Comparator;

public class MyCompare implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		Film film = (Film) o1;
		Film filmOne = (Film) o2;	
		return film.name.compareTo(filmOne.name);	
	}
}


