import java.util.ArrayList;

public class Question {
    public String questionNo;
    public String questionDescription;
    public ArrayList<String> option;
    public String trueAnswer;

    public void addOption(String opt) {
        this.option.add(opt);
    }

    public Question() {
        this("00","00","00");
    }

    public Question(String questionNo, String questionDescription, String trueAnswer) {
        this.questionNo = questionNo;
        this.questionDescription = questionDescription;
        this.trueAnswer = trueAnswer;
        option = new ArrayList<>();
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public ArrayList getOption() {
        return option;
    }

    public void setOption(ArrayList option) {
        this.option = option;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
