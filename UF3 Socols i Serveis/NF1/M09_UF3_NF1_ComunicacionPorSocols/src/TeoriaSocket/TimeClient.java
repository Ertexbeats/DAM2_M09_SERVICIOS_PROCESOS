package TeoriaSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TimeClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 7000);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        String time = din.readUTF();
        System.out.println(time);
    }
}
