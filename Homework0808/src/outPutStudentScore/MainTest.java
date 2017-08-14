package outPutStudentScore;

import java.util.TreeSet;

public class MainTest {
    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        System.out.printf("学号\t姓名\t性别\t分数%n");
        mainTest.addStudent().forEach(p -> {
            System.out.printf("%s\t%s\t%s\t%.1f%n", p.getId(), p.getName(), p.getGender(), p.getScore());
        });
    }

    public TreeSet<Student> addStudent() {
        TreeSet<Student> students = new TreeSet<>();
        Student studentOne = new Student("No.1", "张三", "男");
        Student studentTwo = new Student("No.2", "张四", "女");
        Student studentThree = new Student("No.3", "小李", "娚");
        Student studentFour = new Student("No.4", "中李", "男");
        Student studentFive = new Student("No.5", "大李", "女");

        students.add(studentOne);
        students.add(studentTwo);
        students.add(studentThree);
        students.add(studentFour);
        students.add(studentFive);

        return students;
    }


}
