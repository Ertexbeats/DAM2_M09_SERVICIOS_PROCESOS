package TeoriaSocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class HelloClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tu nombre: ");
        String name = sc.nextLine();

        //String name = "Miguel";
        if (args.length > 0) {
            name = args[0];
        }
        dos.writeUTF(name);
        String message = din.readUTF();
        System.out.println(message);
    }
}
