/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisSockets01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Miguel Mendez
 */

/**
 * 4. Implementa les aplicacions següents: Client: Aplicació que captura els
 * missatges de teclat de l’usuari i els envia al servidor. Per finalitzar
 * l’usuari ha d’escriure: QUIT
 *
 */
public class Exercici4_Client {

    public static void main( String[] args ) throws IOException {
        Scanner sc = new Scanner( System.in );
        String mensaje;

        Socket socket = new Socket( "localhost", 12345 );

        DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
        boolean contador = true;

        do {
            System.out.println( "Escribe el mensaje: " );
            mensaje = sc.nextLine().toUpperCase();
            dos.writeUTF( mensaje );

            if ( mensaje.equals( "QUIT" ) ) {
                contador = false;
            }

        } while ( contador );

    }

}
