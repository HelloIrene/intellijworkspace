import java.util.Comparator;

public class SongDateCompare implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Song songOne = (Song) o1;
        Song songTwo = (Song) o2;
        return songOne.releaseDate.compareTo(songTwo.releaseDate);
    }
}
