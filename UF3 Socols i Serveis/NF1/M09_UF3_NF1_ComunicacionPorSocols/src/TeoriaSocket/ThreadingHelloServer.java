package TeoriaSocket;

import java.io.*;
import java.net.*;

public class ThreadingHelloServer extends Thread {

    Socket soc;

    public ThreadingHelloServer(Socket soc) {
        this.soc = soc;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            String name = dis.readUTF();
            System.out.println("I see " + name);
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("Delay for " + name + " #" + i);
            }
            dos.writeUTF("Hello " + name);
            soc.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        while (true) {
            Socket socket = server.accept();
            new ThreadingHelloServer(socket).start();
        }
    }
}
