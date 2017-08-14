import java.util.HashMap;

public class AnswerSheet {
    public HashMap<String,String> stuAnwer;

    public AnswerSheet() {
        stuAnwer =  new HashMap<>();
    }

    public void setStuAnwer(String no, String anwer){
        this.stuAnwer.put(no,anwer);
    }
}
