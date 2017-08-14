
public class Film implements Comparable<Film>
{
	public String name;
	public String actor;
	public String startDate;
	public Film(String name,String actor,String startDate){
		this.name = name;
		this.actor = actor;
		this.startDate = startDate;
	}
	public int compareTo(Film o){
//		if(!(o instanceof Film)){
//			return -1;
//		}
		Film film = (Film) o;
		return this.name.compareTo(film.name);			
	}
}
