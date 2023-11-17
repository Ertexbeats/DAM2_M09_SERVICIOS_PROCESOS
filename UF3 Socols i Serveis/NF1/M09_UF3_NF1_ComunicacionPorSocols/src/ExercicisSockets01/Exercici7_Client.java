/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicisSockets01;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 * @author alumne
 */
public class Exercici7_Client {

    final String END_COMUNICATION = "0";
    final String INPUT_ENTER = "1";
    final String INPUT_DOUBLE = "2";
    final String INPUT_CHAR = "3";
    final String INPUT_FACTURA = "4";
    private String hostIP;
    private int portNumber;

    public Exercici7_Client( String hostIP, int portNumber ) {
        this.hostIP = hostIP;
        this.portNumber = portNumber;
    }

    public void connect() {
        String opcionRecibida;
        String entradaTeclado;
        try {
            Socket socket = new Socket( hostIP, portNumber );
            System.out.println( "Conectado, esperando instrucciones..." );

            DataInputStream dis = new DataInputStream( socket.getInputStream() );
            DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
            ObjectOutputStream oos = new ObjectOutputStream( socket.getOutputStream() );
            opcionRecibida = dis.readUTF();

            //si no es final de comunicacion hago operaciones
            while ( !opcionRecibida.equals( END_COMUNICATION ) ) {
                try {
                    switch ( opcionRecibida ) {
                        case INPUT_ENTER:
                            entradaTeclado = pedirdato( "entero" );
                            dos.writeInt( Integer.parseInt( entradaTeclado ) );
                            break;
                        case INPUT_DOUBLE:
                            entradaTeclado = pedirdato( "double" );
                            dos.writeDouble( Double.parseDouble( entradaTeclado ) );
                            break;
                        case INPUT_CHAR:
                            entradaTeclado = pedirdato( "char" );
                            dos.writeChar( entradaTeclado.charAt( 0 ) );
                            break;
                        case INPUT_FACTURA:
                            //entradaTeclado = pedirdato("factura");
                            System.out.println( "Enviar Factura..." );
                            Factura f = new Factura( "Ramon", "01A", 122 );
                            oos.writeObject( f );
                            break;
                    }

                    System.out.println( "Enviado al servidor. Esperando nueva orden.." );
                    opcionRecibida = dis.readUTF();
                    System.out.println( "Recibido siguiente" );

                } catch ( NumberFormatException ex ) {
                    System.out.println( "Entrada no valida, prueba otra vez..." );
                }
            }
            socket.close();
        } catch ( SocketException | EOFException ex ) {
            System.out.println( "Servidor desconectado" );

        } catch ( IOException ex ) {
            System.out.println( "Error E/S" );
        }
    }

    private String pedirdato( String tipoDato ) {
        Scanner scan = new Scanner( System.in );
        System.out.print( "Dame un " + tipoDato + ": " );
        return scan.nextLine();

    }

    //SETTERS & GETTERS
    public String getHostIP() {
        return hostIP;
    }

    public void setHostIP( String hostIP ) {
        this.hostIP = hostIP;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber( int portNumber ) {
        this.portNumber = portNumber;
    }

}
