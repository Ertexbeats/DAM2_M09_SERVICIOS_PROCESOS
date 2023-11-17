package TeoriaSocket;

import java.io.*;
import java.net.*;

public class BusyHelloServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String name = dis.readUTF();
            System.out.println("I see " + name);
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("Delay for " + name + " #" + i);
            }
            dos.writeUTF("Hello " + name);
            socket.close();
        }
    }
}
