package org.example.SMTP;

import java.io.*;
import java.net.Socket;

public class SMTPServer {
    String servidor = "localhost";
    int port = 25;
    //SMTPClient client;

    public static void main( String[] args ) throws IOException {
        SMTPServer server = new SMTPServer();
        server.run();
    }

    private void run() throws IOException {
        SMTPClient sender = new SMTPClient( servidor, port );

        sender.setSender( "user01@james.local" );
        sender.setRecipient( "user02@james.local" );
        //sender.setRecipient( "ertexms@gmail.com" );
        sender.setSubject( "Esto es una muy buena oferta" );
        sender.setBody( "Tienes una oferta decomunal como el pepe del papa" );
        sender.sendMail();
    }
}
