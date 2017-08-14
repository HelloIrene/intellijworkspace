package outPutStudentScore;

import java.text.DecimalFormat;

/**
 * ѧ������
 *
 * @autor Student Ross
 */
/*
1��ѧ���������������ԣ�
ѧ��id
����name
�Ա�gender
����score
2���������5��ѧ���ķ���������������С���������������һ����ѧ����
3�������¸�ʽ���ѧ������Ϣ
ѧ��	����	�Ա�	����
No.1	����	��	66.6
No.2	����	Ů	88.0
No.3	С��	��	99.5
...
 */
public class Student implements Comparable {
    public String id;
    public String name;
    public String gender;
    public double score;

//    public void randScore() {
//        Double temp = Math.random() * 1000;
//        DecimalFormat df = new DecimalFormat("#.0");
//        String tempScore = df.format(temp);
//        this.score=tempScore;
//    }

    public void randScore() {
        this.score = Math.random() * 100;
    }

    public Student() {
        this("No.0", "aa", "male");
    }

    public Student(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.randScore();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        if (((Student) o).getScore() == this.getScore()) {
            return ((Student) o).getId().compareTo(this.getId());
        }
        return (int) (this.getScore() - ((Student) o).getScore());
    }


//    @Override
//    public int compareTo(Object o) {
//        if(((Student)o).getScore().compareTo(this.getScore())==0){
//            return ((Student)o).getId().compareTo(this.getId());
//        }
//        return this.getScore().compareTo(((Student)o).getScore());
//    }

}
