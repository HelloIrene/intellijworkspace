package cutFile;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        try {
            File file =new File("D:\\test.jpg");
            String path;
            if(!file.exists()){
                path="//192.168.24.62/share/test.jpg";
            }else{
                path="D:\\test.jpg";
            }
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\test.jpg");
            byte[] b = new byte[1024];
            int read = fileInputStream.read(b);
            while (read != -1) {
                fileOutputStream.write(b, 0, read);
                read = fileInputStream.read(b);
            }
            fileInputStream.close();
            fileOutputStream.close();
            if(path=="D:\\test.jpg"){
                File fileTwo = new File(path);
                fileTwo.delete();
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
