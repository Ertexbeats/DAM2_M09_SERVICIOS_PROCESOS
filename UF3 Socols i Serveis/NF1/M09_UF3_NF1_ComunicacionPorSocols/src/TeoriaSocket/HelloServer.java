package TeoriaSocket;

import java.io.*;
import java.net.*;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is started");
        while (true) {
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String name = dis.readUTF();
            System.out.println("I see " + name);

            // envio info al cliente
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Hello " + name);
            socket.close();
        }
    }
}
