package ExercicisSockets01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Exercici6_ServerChat {
    private final String END_COMUNICATION = "QUIT";
    private int portNumber;

    public Exercici6_ServerChat( int portNumber ) {
        this.portNumber = portNumber;
    }

    // Metodo de servidor "Start"
    public void init() {
        try {
            ServerSocket socket = new ServerSocket( portNumber );
            System.out.println( "Server chat is started...\n" );
            while ( true ) {
                System.out.println( "Waiting for a new client..." );
                Socket client = socket.accept();
                System.out.printf( "New client connected: %s\n", client.getRemoteSocketAddress() );
                // Recibir datos (Obtenemos el InputStream)
                chat( client );
                if ( !socket.isClosed() ) {
                    socket.close();
                }
            }
        } catch ( IOException ex ) {
            System.out.printf( "Error %s", ex.getMessage() );
        }
    }

    /**
     * Cuando tenemos la conexion con el cliente:
     * respuesta mensaje del cliente
     * respuesta servidor (pedimos frase y la enviamos)
     * <p>
     * Acaba cuando el cliente envie "QUIT"
     *
     * @param socket
     */
    public void chat( Socket socket ) {
        Scanner sc = new Scanner( System.in );
        String msg = "", entryKeyboard = "";
        // Recibimos mensaje del cliente
        try {
            // Inicializamos canal de entrada del servidor
            DataInputStream dis = new DataInputStream( socket.getInputStream() );
            // Inicializamos canal de respuesta del sevidor
            DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
            while ( !msg.equals( END_COMUNICATION ) ) {
                // Leemos mensaje del cliente
                msg = dis.readUTF();
                // Si el mensaje no es "QUIT" Lo muestro por pantalla, si es "QUIT" finalizo transmision y informo que se ha desconectado
                if ( !msg.equals( END_COMUNICATION ) ) {
                    System.out.printf( "Client Message: %s\n", msg );
                } else {
                    System.out.println( "Client Disconnected" );
                }
                // Enviamos mensaje al cliente
                entryKeyboard = sc.nextLine();
                dos.writeUTF( entryKeyboard );
            }
            socket.close();
        } catch ( SocketException ex ) {
            System.out.printf( "Client Disconnected, Error: %s\n", ex.getMessage() );
        } catch ( IOException ex ) {
            System.out.printf( "Connection Error, Error: %s\n", ex.getMessage() );
        }
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber( int portNumber ) {
        this.portNumber = portNumber;
    }

    public String getEND_COMUNICATION() {
        return END_COMUNICATION;
    }
}
