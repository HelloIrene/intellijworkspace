package saveInf;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @autor student Ross
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("��˵���������");
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        sc.close();
        System.out.println(test.writer(temp));

    }

    public String writer(String writer) {
        try {
            FileWriter fileWriter = new FileWriter("src/test.txt");
            fileWriter.write(writer);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "д��ʧ��";
        }
        return "д��ɹ�";
    }
}
