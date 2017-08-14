package outPutStudentScore;

import java.text.DecimalFormat;

/**
 * 学生对象
 *
 * @autor Student Ross
 */
/*
1、学生对象有如下属性：
学号id
姓名name
性别gender
评分score
2、随机生成5个学生的分数，并按分数从小到大排序，如果分数一样按学号排
3、按如下格式输出学生的信息
学号	姓名	性别	分数
No.1	张三	男	66.6
No.2	张四	女	88.0
No.3	小李	娚	99.5
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
