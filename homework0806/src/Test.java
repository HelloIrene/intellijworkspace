import java.util.*;
import java.util.Map.Entry;

/**
 * ������
 *
 * @author student Ross
 */
/*
֪ʶ����ϰ������TreeMap������¹��ܣ�
1.�������ʵ����ֱ���������ơ�ʱ�����������ڣ��͸��֣��������Ա𣬱�ע����
2.TreeMap���԰��ո������ơ�ʱ���ͷ��������������ʵ�����
3.ͳ��ĳλ���ֹ��������ٵ���
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        TreeMap<Song,ArrayList<Singer>> songInf;
        System.out.println("����������");
        songInf=test.sort("Name");
        test.print(songInf);
        System.out.print("\n");
        System.out.println("����ʱ����");
        test.print(test.sort("Time"));
        System.out.print("\n");
        System.out.println("���շ���ʱ����");
        test.print(test.sort("Date"));
        System.out.print("\n");
        System.out.println("ͳ��ĳλ���ֹ��������ٵ���");
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
    //���ղ�ͬԪ�����趨�Ƚ���
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
    //��¼ÿ�����ֵĸ���TreeSet
    public TreeMap<Singer,ArrayList<Song>> countSong(TreeMap<Song,ArrayList<Singer>> tempSong){
        TreeMap<Singer,ArrayList<Song>> temp = new TreeMap<>();
        Set<Entry<Song,ArrayList<Singer>>> entries = tempSong.entrySet();
        Iterator itEntry = entries.iterator();
        while(itEntry.hasNext()){
            Entry<Song,ArrayList<Singer>> tmpEtr = (Entry<Song,ArrayList<Singer>>)itEntry.next();
            int index = tmpEtr.getValue().size();
            for(int count = 0 ; count < index ; count++){
                //������ظ��ĸ��֣��������滻
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

