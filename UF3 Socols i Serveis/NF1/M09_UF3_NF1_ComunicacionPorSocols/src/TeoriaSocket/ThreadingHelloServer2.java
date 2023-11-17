package TeoriaSocket;

import java.io.*;
import java.net.*;

public class ThreadingHelloServer2 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is started");
        while (true) {
            final Socket socket = server.accept();
            Thread t = new Thread() {
                public void run() {
                    try {
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
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            t.start();
        }
    }
}
