package TalkingRoom;

import Custom.Product;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    String temp;

    public static void main(String[] args) {
        String inf;
        try {

            ServerSocket serverSocket = new ServerSocket(1989);
            System.out.println("Link Start!");
            while (true) {
                Socket socket = serverSocket.accept();

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("welcome to 1989");
                dataOutputStream.close();


                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                inf = dataInputStream.readUTF();

                DataOutputStream dataOutputStream1 = new DataOutputStream(socket.getOutputStream());
                dataOutputStream1.writeUTF(inf);

                dataInputStream.close();
                dataOutputStream1.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //              public synchronized void in(Product product) {
//                    while (products.size() >= max) {
//                        try {
//                            wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    products.add(product);
//                    System.out.println(Thread.currentThread().getName() + "将一个产品放在了货架，当前产品数目为" + products.size());
//                    notifyAll();
//                }

    public synchronized void server(){
        while (temp==null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
