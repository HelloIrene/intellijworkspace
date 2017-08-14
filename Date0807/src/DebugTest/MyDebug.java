package DebugTest;

public class MyDebug {

    public static void main(String[] args) {
        String value = getScoreFromOtherPlace();
        System.out.println("value 变量的值：" + value);
        int x = Integer.parseInt(value);
        if (x >= 60) {
            System.out.println("合格");
        } else {
            System.out.println("不合格");
        }
    }

    private static String getScoreFromOtherPlace() {
        String val = "abc";
        return val;
    }
}
