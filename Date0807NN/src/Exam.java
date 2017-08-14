import java.util.HashSet;

public class Exam {
    public HashSet<Student> students;
    public Paper paper;

    public Exam() {
        students = new HashSet<>();
        paper = new Paper();
    }

    public void addStudents(Student students) {
        this.students.add(students);
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
