import java.util.ArrayList;

/**
 * ������
 *
 * @autor Student Ross
 */
/*
֪ʶ����ϰ������TreeMap������¹��ܣ�
1.�������ʵ����ֱ���������ơ�ʱ�����������ڣ��͸��֣��������Ա𣬱�ע����
2.TreeMap���԰��ո������ơ�ʱ���ͷ��������������ʵ�����
3.ͳ��ĳλ���ֹ��������ٵ���
 */
public class Song implements Comparable{
    public String songName;
    public String songTime;
    public String releaseDate;
    public ArrayList<Singer> singer;

    public ArrayList<Singer> addSinger(Singer singer){
        this.singer.add(singer);
        return this.singer;
    }

    public ArrayList<Singer> getSinger() {
        return singer;
    }

    public void setSinger(ArrayList<Singer> singer) {
        this.singer = singer;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongTime() {
        return songTime;
    }

    public void setSongTime(String songTime) {
        this.songTime = songTime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Song(){
        this("Photograph","04:18","2014-06-20");
    }

    public Song(String songName, String songTime, String releaseDate) {
        this.songName = songName;
        this.songTime = songTime;
        this.releaseDate = releaseDate;
        singer = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "��������"+this.songName+" ʱ����"+this.songTime+" ����ʱ�䣺"+this.releaseDate;
    }

    //Ĭ�ϰ����������Ƚ�
    @Override
    public int compareTo(Object o) {
        return this.getSongName().compareTo(((Song) o).getSongName());
    }
}
