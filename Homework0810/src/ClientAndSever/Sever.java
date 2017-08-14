package ClientAndSever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1989);
            System.out.println("Link Start!");
            while (true) {
                Socket socket = serverSocket.accept();

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF("welcome to 1989");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println(dataInputStream.readUTF());

                dataInputStream.close();
                dataOutputStream.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
