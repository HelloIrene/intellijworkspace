package saveInf2;

import java.io.*;
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
            //����ԭ����Ϣ
            String temp="";
            this.createFile();
            FileReader fileReader = new FileReader("src/test.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String read = bufferedReader.readLine();
            while(read!=null){
                temp+=read;
                temp+=System.getProperty("line.separator");
                read=bufferedReader.readLine();
            }
            bufferedReader.close();
            //д��ȫ����Ϣ
            FileWriter fileWriter = new FileWriter("src/test.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            temp+=writer;
            bufferedWriter.write(temp);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "д��ʧ��";
        }
        return "д��ɹ�";
    }

    public void createFile(){
        File file = new File("src/test.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
