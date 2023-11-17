/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisSockets01;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Miguel Mendez
 */

/**
 * 4. Implementa les aplicacions següents: Servidor: Quan es connecti un usuari
 * mostrar el missatge “Usuari connectat des de la IP: xxx.yyyy.zzz.www port
 * xx”. Mostrar per pantalla tots els missatges de text que arriben de l’usuari
 * FQuan es desconnecti l’usuari mostrar el missatge “Usuari desconnectat”
 *
 */
public class Exercici4_Server {

    public static void main( String[] args ) throws IOException {
        ServerSocket server = new ServerSocket( 12345 );
        System.out.println( "Server is started" );
        while ( true ) {
            Socket socket = server.accept();

            //System.out.println("Usuari conectat des de la IP: " + socket.getInetAddress() + " port " + socket.getPort());
            System.out.printf( "Usuari conectat des de la IP: %s\n", socket.getRemoteSocketAddress() );
            DataInputStream dis = new DataInputStream( socket.getInputStream() );
            String mensaje = dis.readUTF();

            if ( mensaje.equals( "QUIT" ) ) {
                System.out.println( "User Disconected" );
            } else {
                System.out.printf( "User Message: %s", mensaje );
            }

            socket.close();
        }
    }

}
