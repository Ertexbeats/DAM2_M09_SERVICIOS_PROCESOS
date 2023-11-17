package ExercicisSockets01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Exercici6_ClientChat {
    final String END_COMUNICATION = "QUIT";
    int portNumber;
    String hostIp;

    public Exercici6_ClientChat( String hostIp, int portNumber ) {
        this.hostIp = hostIp;
        this.portNumber = portNumber;
    }

    /**
     * Conexion al servidor
     * Envia mensaje y espera respuesta del servidor
     * <p>
     * Acaba cuando escribe "QUIT"
     */
    public void connect() {
        Scanner sc = new Scanner( System.in );
        String entryKeyboard = "";
        String entrySocket = "";
        try {
            Socket socket = new Socket( hostIp, portNumber );
            // Entrada de datos
            DataInputStream dis = new DataInputStream( socket.getInputStream() );
            // Salida de datos
            DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
            System.out.println( "send a mess||age to the server and wait for a response" );
            while ( !entryKeyboard.equals( END_COMUNICATION ) ) {
                // Enviamos mensaje al servidor
                entryKeyboard = sc.nextLine();
                dos.writeUTF( entryKeyboard );
                // Leemos mensaje del servidor
                if ( !entryKeyboard.equals( END_COMUNICATION ) ) {
                    entrySocket = dis.readUTF();
                    if ( !entrySocket.equals( END_COMUNICATION ) ) {
                        System.out.printf( "Server Message: %s\n", entrySocket );
                    } else {
                        System.out.println( "Server Disconnected" );
                    }
                } else {
                    System.out.println( "Server Disconnected" );
                }
            }
            socket.close();
        } catch ( IOException ex ) {
            System.out.printf( "Error: %s", ex.getMessage() );
        }
    }
}
