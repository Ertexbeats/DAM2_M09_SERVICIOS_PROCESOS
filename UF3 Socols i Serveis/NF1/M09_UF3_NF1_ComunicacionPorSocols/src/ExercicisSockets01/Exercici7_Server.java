/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicisSockets01;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author alumne
 */
public class Exercici7_Server {

    final String END_COMUNICATION = "0";
    final String INPUT_ENTER = "1";
    final String INPUT_DOUBLE = "2";
    final String INPUT_CHAR = "3";
    final String INPUT_FACTURA = "4";
    private int portNumber;

    public Exercici7_Server( int portNumber ) {
        this.portNumber = portNumber;
    }

    /**
     * Inicia el server por el portNumber
     */
    public void init() {
        try {
            ServerSocket server = new ServerSocket( this.portNumber );
            System.out.println( "Server iniciado..." );

            while ( true ) {
                System.out.println( "Esperando cliente..." );
                Socket socket = server.accept();

                System.out.println( "Client connectado: " + socket.getRemoteSocketAddress() );

                conversacion( socket ); //mostrar menu, enviar y esperar respuesta cliente

                if ( !socket.isClosed() ) {
                    socket.close();
                }
            }

        } catch ( BindException ex ) {
            System.out.println( "El port " + portNumber + " ya esta cogido" );
        } catch ( IOException ex ) {
            System.out.println( "Error E/S" + ex.getMessage() );
        }
    }

    /**
     * mostra menu, demana opcio menu envia info a client y espera resposta del
     * client y la mostra
     *
     * @param socket
     */
    private void conversacion( Socket socket ) {
        String opcion = "";

        try {
            DataInputStream dis = new DataInputStream( socket.getInputStream() );
            DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
            ObjectInputStream ois = new ObjectInputStream( socket.getInputStream() );

            while ( !opcion.equals( END_COMUNICATION ) ) {
                //pedimos opcion menu
                opcion = pideOpcionMenu();

                //envio opcion al cliente
                dos.writeUTF( opcion );

                //Si no ha elegido salir, esperamos respuesta del cliente 
                if ( !opcion.equals( END_COMUNICATION ) ) {
                    //respuesta cliente, esperamos el valor de tipo pedido
                    //Depende del tipo de dato lo recogemos de una forma u otra
                    switch ( opcion ) {
                        case INPUT_ENTER:
                            int i = dis.readInt();
                            System.out.println( "Entero: " + i );
                            break;
                        case INPUT_DOUBLE:
                            double d = dis.readDouble();
                            System.out.println( "Double: " + d );
                            break;
                        case INPUT_CHAR:
                            char c = dis.readChar();
                            System.out.println( "Char: " + c );
                            break;
                        case INPUT_FACTURA:
                            Factura f = ( Factura ) ois.readObject();
                            System.out.println( f.toString() );

                    }
                } else {
                    System.out.println( "Fin de la conexión" );
                }
            }

        } catch ( SocketException | EOFException ex ) {
            System.out.println( "Cliente desconectado" );

        } catch ( IOException ex ) {
            System.out.println( "Exceptio I/O" );
        } catch ( ClassNotFoundException ex ) {
            Logger.getLogger( Exercici7_Server.class.getName() ).log( Level.SEVERE, null, ex );
        }

    }

    private String pideOpcionMenu() {
        String opcion = "";
        Scanner scan = new Scanner( System.in );

        do {
            System.out.println( END_COMUNICATION + "- SALIR" );
            System.out.println( INPUT_ENTER + " - Escribe un entero" );
            System.out.println( INPUT_DOUBLE + " - Escribe un double" );
            System.out.println( INPUT_CHAR + " - Escribe un char" );
            System.out.println( INPUT_FACTURA + " - Escribe una factura" );

            opcion = scan.nextLine();
        } while ( !opcion.equals( END_COMUNICATION ) && !opcion.equals( INPUT_ENTER )
                && !opcion.equals( INPUT_DOUBLE ) && !opcion.equals( INPUT_CHAR )
                && !opcion.equals( INPUT_FACTURA ) );

        return opcion;
    }

    //SETTERS & GETTERS
    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber( int portNumber ) {
        this.portNumber = portNumber;
    }
}
