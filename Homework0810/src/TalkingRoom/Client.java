package TalkingRoom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {
    String date;

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    @Override
    public void run() {
        System.out.println("load.....");
        try {
            while (true) {
                Socket socket = new Socket("192.168.24.62", 1989);
                System.out.println("Success!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                System.out.println("服务端信息：" + dis.readUTF());
                dis.close();
                Thread.sleep(50);
                while (date == null) {
                    wait();
                }
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("连接的客户" + InetAddress.getLocalHost());

                dos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
