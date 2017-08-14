package ExceptionTest;


public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.connectToSever();
    }

    public void connectToSever() {
        try {
            ConnectUntil.connect("192.168.24.1",8080);
        } catch (SeverTimeOutException e) {
            e.printStackTrace();
        }
    }
}
