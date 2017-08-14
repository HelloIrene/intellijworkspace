import java.util.*;
import java.util.Map.Entry;

/**
 * 测试类
 *
 * @author student Ross
 */
/*
知识点练习：利用TreeMap完成以下功能：
1.完成两个实体类分别歌曲（名称、时长、发布日期）和歌手（姓名，性别，备注）；
2.TreeMap可以按照歌曲名称、时长和发布日期来进行适当排序
3.统计某位歌手共发布多少单曲
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        TreeMap<Song,ArrayList<Singer>> songInf;
        System.out.println("按照名字排");
        songInf=test.sort("Name");
        test.print(songInf);
        System.out.print("\n");
        System.out.println("按照时长排");
        test.print(test.sort("Time"));
        System.out.print("\n");
        System.out.println("按照发行时间排");
        test.print(test.sort("Date"));
        System.out.print("\n");
        System.out.println("统计某位歌手共发布多少单曲");
        test.print(test.countSong(songInf));
    }

    public TreeMap<Song,ArrayList<Singer>> addSong(TreeMap<Song,ArrayList<Singer>> temp){
        Singer singerOne = new Singer("Ed Sheeran","male","English singer-songwriter");
        Singer singerTwo = new Singer("Taylor Swift","female","U.S. singer-songwriter");
        Singer singerThree = new Singer("ColdPlay","male","English rock band");
        Singer singerFour = new Singer("One Direction","male","English pop band");

        Song songOne = new Song("Everything Has Changed","04:05","2013-05-03");
        songOne.addSinger(singerOne);
        songOne.addSinger(singerTwo);
        Song songTwo = new Song("Castle on the Hill","04:20","2017-01-06");
        songTwo.addSinger(singerOne);
        Song songThree= new Song("Up&Up","06:45","2016-04-16");
        songThree.addSinger(singerThree);
        Song songFour = new Song("Drag Me Down","03:12","2015-08-07");
        songFour.addSinger(singerFour);
        Song songFive = new Song("Shake It Off","03:39","2014-08-18");
        songFive.addSinger(singerTwo);

        temp.put(songOne,songOne.getSinger());
        temp.put(songTwo,songTwo.getSinger());
        temp.put(songThree,songThree.getSinger());
        temp.put(songFour,songFour.getSinger());
        temp.put(songFive,songFive.getSinger());
        return temp;
    }
    //按照不同元素来设定比较器
    public TreeMap<Song,ArrayList<Singer>> sort(String compareBody){
        if(compareBody == "Time"){
            TreeMap<Song,ArrayList<Singer>> temp = new TreeMap<>(new SongTimeCompar());
            this.addSong(temp);
            return temp;
        }else if(compareBody == "Date"){
            TreeMap<Song,ArrayList<Singer>> temp = new TreeMap<>(new SongDateCompare());
            this.addSong(temp);
            return temp;
        }
        TreeMap<Song,ArrayList<Singer>> temp = new TreeMap<>();
        this.addSong(temp);
        return temp;
    }
    //记录每个歌手的歌曲TreeSet
    public TreeMap<Singer,ArrayList<Song>> countSong(TreeMap<Song,ArrayList<Singer>> tempSong){
        TreeMap<Singer,ArrayList<Song>> temp = new TreeMap<>();
        Set<Entry<Song,ArrayList<Singer>>> entries = tempSong.entrySet();
        Iterator itEntry = entries.iterator();
        while(itEntry.hasNext()){
            Entry<Song,ArrayList<Singer>> tmpEtr = (Entry<Song,ArrayList<Singer>>)itEntry.next();
            int index = tmpEtr.getValue().size();
            for(int count = 0 ; count < index ; count++){
                //如果有重复的歌手，会自行替换
                temp.put(tmpEtr.getValue().get(count),tmpEtr.getValue().get(count).addSong(tmpEtr.getKey()));
            }
        }
        return temp;
    }
    public void print(TreeMap temp){
        Set<Entry> entries = temp.entrySet();
        Iterator itEntry = entries.iterator();
        while(itEntry.hasNext()) {
            Entry tmpEtr = (Entry) itEntry.next();
            System.out.print(tmpEtr.getKey() + "::" + tmpEtr.getValue()+"\n");
        }
    }
}

