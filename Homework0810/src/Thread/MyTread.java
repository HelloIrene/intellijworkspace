package Thread;

import java.io.*;

/**
 * @author student Ross
 */

public class MyTread implements Runnable{
    @Override
    public void run() {
        try {
            File file =new File("D:\\test.jpg");
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\test.jpg");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] b = new byte[1024];
            int read = bufferedInputStream.read(b);
            while (read != -1) {
                bufferedOutputStream.write(b, 0, read);
                read = bufferedInputStream.read(b);
            }
            bufferedOutputStream.flush();
            bufferedInputStream.close();
            bufferedOutputStream.close();
            file.delete();
            System.out.println("³É¹¦!");
        } catch (FileNotFoundException e) {
            System.out.println();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
