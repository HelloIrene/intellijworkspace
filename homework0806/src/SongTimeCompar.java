import java.util.Comparator;

public class SongTimeCompar implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Song songOne = (Song) o1;
        Song songTwo = (Song) o2;
        return songOne.songTime.compareTo(songTwo.songTime);
    }
}
