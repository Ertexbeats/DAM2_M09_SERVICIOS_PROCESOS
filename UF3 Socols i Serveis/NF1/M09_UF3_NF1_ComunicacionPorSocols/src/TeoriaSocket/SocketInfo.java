package TeoriaSocket;

import java.io.IOException;
import java.net.Socket;

public class SocketInfo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.google.com", 80);
        System.out.println("Connected to "
                + socket.getInetAddress()
                + " on port " + socket.getPort()
                + " from port " + socket.getLocalPort()
                + " of " + socket.getLocalAddress());
    }
}
