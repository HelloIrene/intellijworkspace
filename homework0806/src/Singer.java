import java.util.ArrayList;

/**
 * ������
 *
 * @author student Ross
 *
 */
/*
֪ʶ����ϰ������TreeMap������¹��ܣ�
1.�������ʵ����ֱ���������ơ�ʱ�����������ڣ��͸��֣��������Ա𣬱�ע����
2.TreeMap���԰��ո������ơ�ʱ���ͷ��������������ʵ�����
3.ͳ��ĳλ���ֹ��������ٵ���
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
        return "���֣�"+this.name;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Singer) o).getName());
    }
}
