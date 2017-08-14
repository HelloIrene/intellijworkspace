import java.util.ArrayList;

/**
 * 歌手类
 *
 * @author student Ross
 *
 */
/*
知识点练习：利用TreeMap完成以下功能：
1.完成两个实体类分别歌曲（名称、时长、发布日期）和歌手（姓名，性别，备注）；
2.TreeMap可以按照歌曲名称、时长和发布日期来进行适当排序
3.统计某位歌手共发布多少单曲
 */
public class Singer implements Comparable {
    public String name;
    public String sex;
    public String remark;
    public ArrayList<Song> songs;

    public ArrayList addSong(Song song){
        this.getSongs().add(song);
        return this.getSongs();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Singer() {
        this("ed sheeran","male","......");
    }

    public Singer(String name, String sex, String remark) {
        this.name = name;
        this.sex = sex;
        this.remark = remark;
        songs = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "歌手："+this.name;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Singer) o).getName());
    }
}
