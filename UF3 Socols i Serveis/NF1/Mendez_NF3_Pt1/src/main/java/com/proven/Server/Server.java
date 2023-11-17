package com.proven.Server;

import com.proven.Data.DataClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Scanner;

public class Server {

    String hostIp;
    int portNumber;
    Scanner sc = new Scanner( System.in );
    DataClient dataClient;

    public Server( String hostIp, int portNumber ) {
        this.hostIp = hostIp;
        this.portNumber = portNumber;
    }

    public void init() {
        try {
            ServerSocket socket = new ServerSocket( portNumber );
            System.out.println( "Server chat is started...\n" );

            while ( true ) {
                System.out.println( "Waiting for a new client..." );
                Socket client = socket.accept();
                System.out.printf( "New client connected: %s\n", client.getRemoteSocketAddress() );
                collection( client );
                if ( !socket.isClosed() ) {
                    socket.close();
                }
            }
        } catch ( IOException e ) {
            System.err.printf( "Error %s", e.getMessage() );
        }
    }

    public void collection( Socket socket ) {
        String entryKeyboard = "";
        String name, opcion = "CONTINUE";
        int age;
        try {
            // Inicializamos canal de entrada del servidor
            DataInputStream dis = new DataInputStream( socket.getInputStream() );
            // Inicializamos canal de respuesta del sevidor
            DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
            ObjectOutputStream oos = new ObjectOutputStream( socket.getOutputStream() );

            while ( opcion == "CONTINUE" ) {

                // Pido el nombre
                dos.writeUTF( "Input your name" );
                // Recibo nombre cliente
                name = dis.readUTF();

                // Pido la edad
                dos.writeUTF( "Input your age" );
                // Recibo edad cliente
                age = dis.readInt();

                if ( age >= 18 ) {
                    dos.writeUTF( "BENVINGUT " + name + "!" );
                    dataClient = new DataClient( name, age, hostIp, portNumber, new Date() );
                    oos.writeObject( dataClient );

                    dos.writeUTF( "Vols tornar a fer el proces, o parar? (CONTINUE / STOP)" );
                    opcion = dis.readUTF();
                } else if ( age < 18 ) {
                    dos.writeUTF( "Ho sentim, no tens l'edat suficient" );
                    // TODO

                    dos.writeUTF( "Vols tornar a fer el proces, o parar? (CONTINUE / STOP)" );
                    opcion = dis.readUTF();
                }
            }
            socket.close();
        } catch ( SocketException e ) {
            System.err.printf( "Client Disconnected, Error: %s\n", e.getMessage() );
        } catch ( IOException e ) {
            System.err.printf( "Connection Error, Error: %s\n", e.getMessage() );
        } catch ( NumberFormatException e ) {
            System.err.printf( "Error: %s\n", e.getMessage() );
        }
    }
}
