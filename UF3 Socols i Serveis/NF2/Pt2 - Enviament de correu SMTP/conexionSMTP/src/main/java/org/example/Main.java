package org.example;


import java.io.*;
import java.net.Socket;

public class Main {
    static String servidor = "localhost";
    static int port = 25;

    public static void main( String[] args ) throws IOException {
        String resposta = "";

        Socket socket = new Socket( servidor, port );
        socket.setSoTimeout( 3000 );


        BufferedReader bin = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
        OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream() );
        PrintWriter bOut = new PrintWriter( osw, true );

        resposta = bin.readLine();
        System.out.printf( "server: %s\n", resposta );

        System.out.println( "Sending order HELO..." );
        bOut.printf( "HELO %s \n", servidor );

        System.out.println( "Waiting for response..." );
        resposta = bin.readLine();
        System.out.printf( "server: %s\n", resposta );
    }
}