package com.proven.Client;

import com.proven.Data.DataClient;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

@Setter
public class Client {
    String hostIp;
    int portNumber;
    Scanner sc = new Scanner( System.in );
    DataClient dataclient;

    public Client( String hostIp, int portNumber ) {
        this.hostIp = hostIp;
        this.portNumber = portNumber;
    }

    public void connect() {
        String entryStringKeyboard = "", entrySocket = "";
        int entryIntKeyboard = 0;
        try {
            do {
                Socket socket = new Socket( hostIp, portNumber );
                // Entrada de datos
                DataInputStream dis = new DataInputStream( socket.getInputStream() );
                ObjectInputStream ois = new ObjectInputStream( socket.getInputStream() );
                // Salida de datos
                DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
                System.out.println( "Connected to server" );

                // Recibo  mensaje
                entrySocket = dis.readUTF();
                System.out.printf( "Server Message: %s\n", entrySocket );
                // Envio Mensaje
                System.out.print( "Name: " );
                entryStringKeyboard = sc.nextLine();
                dos.writeUTF( entryStringKeyboard );


                // Recibo  mensaje
                entrySocket = dis.readUTF();
                System.out.printf( "Server Message: %s\n", entrySocket );
                // Envio Mensaje
                System.out.print( "Age: " );
                entryIntKeyboard = sc.nextInt();
                dos.writeInt( entryIntKeyboard );

                if ( entryIntKeyboard >= 18 ) {
                    // Recibo  mensaje
                    entrySocket = dis.readUTF();
                    System.out.printf( "Server Message: %s\n", entrySocket );
                    try {
                        // Recibo Objeto
                        dataclient = ( DataClient ) ois.readObject();
                        System.out.println( dataclient.toString() );

                        System.out.printf( "Server Message: %s\n", entrySocket );
                        entrySocket = dis.readUTF();
                        // Envio Mensaje
                        do {
                            entryStringKeyboard = sc.nextLine().toUpperCase();
                        } while ( entryStringKeyboard != "CONTINUE" && entryStringKeyboard != "STOP" );
                        dos.writeUTF( entryStringKeyboard );

                    } catch ( ClassNotFoundException e ) {
                        System.err.printf( "Error: %s", e.getMessage() );
                    }
                } else if ( entryIntKeyboard < 18 ) {
                    // Recibo  mensajes
                    // mensaje 1
                    entrySocket = dis.readUTF();
                    System.out.printf( "Server Message: %s\n", entrySocket );
                    // mensaje 2
                    entrySocket = dis.readUTF();
                    System.out.printf( "Server Message: %s\n", entrySocket );
                    // Envio Mensaje
                    do {
                        entryStringKeyboard = sc.nextLine().toUpperCase();
                    } while ( entryStringKeyboard != "CONTINUE" && entryStringKeyboard != "STOP" );
                    dos.writeUTF( entryStringKeyboard );
                }

            } while ( entryStringKeyboard == "CONTINUE" );
        } catch ( IOException e ) {
            System.err.printf( "Error %s", e.getMessage() );
        }
    }
}

