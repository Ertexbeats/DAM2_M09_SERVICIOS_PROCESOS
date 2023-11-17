/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisSockets01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author ertex
 */
public class Exercici5_Client {

    public static void main( String[] args ) {
        try {
            Scanner sc = new Scanner( System.in );
            String mensaje = null;
            Socket socket = new Socket( "localhost", 7000 );
            DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
            while ( !"QUIT".equalsIgnoreCase( mensaje ) ) {
                try {
                    System.out.print( "Escribe el mensaje para el servidor: " );
                    // leer lineas
                    mensaje = sc.nextLine();
                    // envio al servidor
                    dos.writeUTF( mensaje );
                } catch ( SocketException ex ) {
                    System.err.printf( "Session finalizada\n" );
                }
            }
            socket.close();
        } catch ( IOException ex ) {
            System.err.printf( "No se ha podido acceder al servidor)\n" );
        }
    }
}
