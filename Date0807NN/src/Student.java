public class Student {
    public String stuName;
    public AnswerSheet stuAnswer;
    public Paper stuPaper;
    public Double scores;

    public Student() {
        this("aa",0.0);
    }

    public Student(String stuName, Double scores) {
        this.scores = scores;
        this.stuName = stuName;
        stuPaper =  new Paper();
        stuAnswer = new AnswerSheet();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public AnswerSheet getStuAnswer() {
        return stuAnswer;
    }

    public void setStuAnswer(AnswerSheet stuAnswer) {
        this.stuAnswer = stuAnswer;
    }

    public Paper getStuPaper() {
        return stuPaper;
    }

    public void setStuPaper(Paper stuPaper) {
        this.stuPaper = stuPaper;
    }

    public Double getScores() {
        return scores;
    }

    public void setScores(Double scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


