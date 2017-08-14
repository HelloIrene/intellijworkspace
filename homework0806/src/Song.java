import java.util.ArrayList;

/**
 * 歌曲类
 *
 * @autor Student Ross
 */
/*
知识点练习：利用TreeMap完成以下功能：
1.完成两个实体类分别歌曲（名称、时长、发布日期）和歌手（姓名，性别，备注）；
2.TreeMap可以按照歌曲名称、时长和发布日期来进行适当排序
3.统计某位歌手共发布多少单曲
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
        return "歌曲名："+this.songName+" 时长："+this.songTime+" 发行时间："+this.releaseDate;
    }

    //默认按歌曲名来比较
    @Override
    public int compareTo(Object o) {
        return this.getSongName().compareTo(((Song) o).getSongName());
    }
}
