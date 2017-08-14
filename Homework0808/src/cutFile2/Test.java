package cutFile2;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        try {
            File file1 =new File("D:\\test.jpg");
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\test.jpg");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            byte[] b = new byte[1024];
//            int read = fileInputStream.read(b);
//            while (read != -1) {
//                fileOutputStream.write(b, 0, read);
//                read = fileInputStream.read(b);
//            }
//            fileInputStream.close();
//            fileOutputStream.close();
            byte[] b = new byte[1024];
            int read = bufferedInputStream.read(b);
            while (read != -1) {
                bufferedOutputStream.write(b, 0, read);
                read = bufferedInputStream.read(b);
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            file1.delete();
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
