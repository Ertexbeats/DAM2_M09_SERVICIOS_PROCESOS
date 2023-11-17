/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisSockets01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Miguel Mendez
 */
public class Exercici5_Server {

    public static void main( String[] args ) {
        try {
            ServerSocket server = new ServerSocket( 12345 );
            System.out.println( "Server Started" );
            String mensaje = null;
            while ( true ) {
                System.out.println( "Server is waiting for clients..." );
                Socket socket = server.accept();
                System.out.printf( "Usuari conectat des de la IP: %s\n", socket.getRemoteSocketAddress() );

                while ( !"QUIT".equalsIgnoreCase( mensaje ) ) {
                    // Recibir datos (Obtenemos el InputStream)
                    DataInputStream dis = new DataInputStream( socket.getInputStream() );
                    mensaje = dis.readUTF();
                    System.out.printf( "User Message: %s\n", mensaje );
                }
                System.err.print( "User Disconected, exit message recived" );
            }
        } catch ( IOException ex ) {
            System.err.printf( "I/O Error: %s\n", ex.getStackTrace() );
        }
    }
}
