package DebugTest;

public class MyDebug {

    public static void main(String[] args) {
        String value = getScoreFromOtherPlace();
        System.out.println("value ������ֵ��" + value);
        int x = Integer.parseInt(value);
        if (x >= 60) {
            System.out.println("�ϸ�");
        } else {
            System.out.println("���ϸ�");
        }
    }

    private static String getScoreFromOtherPlace() {
        String val = "abc";
        return val;
    }
}
