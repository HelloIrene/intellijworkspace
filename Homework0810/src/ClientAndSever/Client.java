package ClientAndSever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("load.....");
        try {
            Socket socket = new Socket("192.168.24.62",1989);
            System.out.println("Success!");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            System.out.println("�������Ϣ��"+dis.readUTF());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("���ӵĿͻ�"+ InetAddress.getLocalHost());
            dis.close();
            dos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
