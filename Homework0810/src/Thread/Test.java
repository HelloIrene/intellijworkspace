package Thread;

public class Test {
    public static void main(String[] args) {
        MyTread tread = new MyTread();
        Thread thread = new Thread(tread);
        thread.start();
    }
}
