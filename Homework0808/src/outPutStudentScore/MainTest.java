package outPutStudentScore;

import java.util.TreeSet;

public class MainTest {
    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        System.out.printf("ѧ��\t����\t�Ա�\t����%n");
        mainTest.addStudent().forEach(p -> {
            System.out.printf("%s\t%s\t%s\t%.1f%n", p.getId(), p.getName(), p.getGender(), p.getScore());
        });
    }

    public TreeSet<Student> addStudent() {
        TreeSet<Student> students = new TreeSet<>();
        Student studentOne = new Student("No.1", "����", "��");
        Student studentTwo = new Student("No.2", "����", "Ů");
        Student studentThree = new Student("No.3", "С��", "��");
        Student studentFour = new Student("No.4", "����", "��");
        Student studentFive = new Student("No.5", "����", "Ů");

        students.add(studentOne);
        students.add(studentTwo);
        students.add(studentThree);
        students.add(studentFour);
        students.add(studentFive);

        return students;
    }


}
