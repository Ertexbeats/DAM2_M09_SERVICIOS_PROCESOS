package org.example.SMTP;

import java.io.*;
import java.net.Socket;

public class SMTPClient {
    String SMTPServer, sender, recipient, subject, body;
    int port;

    public SMTPClient( String SMTPServer, int port ) {
        this.SMTPServer = SMTPServer;
        this.port = port;
    }

    public void setSender( String sender ) {
        this.sender = sender;
    }

    public void setRecipient( String recipient ) {
        this.recipient = recipient;
    }

    public void setSubject( String subject ) {
        this.subject = subject;
    }

    public void setBody( String body ) {
        this.body = body;
    }

    public void sendMail() throws IOException {
        boolean ok = true;
        String toSend = "", toReceive = "";
        Socket socket = new Socket( SMTPServer, port );
        socket.setSoTimeout( 10000 );

        BufferedReader bin = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
        OutputStreamWriter osw = new OutputStreamWriter( socket.getOutputStream() );
        PrintWriter bOut = new PrintWriter( osw, true );

        System.out.println( reciveAnswer( bin ) );

        System.out.println( "Sending order HELO..." );
        bOut.println( "HELO " + SMTPServer );
        System.out.println( reciveAnswer( bin ) );

        System.out.println( "Sending order MAIL FROM..." );
        bOut.printf( "MAIL FROM: <%s>\n", sender );
        System.out.println( reciveAnswer( bin ) );

        System.out.println( "Sending order RCPT TO..." );
        bOut.printf( "RCPT TO: <%s>\n", recipient );
        System.out.println( reciveAnswer( bin ) );

        System.out.println( "Sending order DATA..." );
        bOut.printf( "DATA\n" );
        System.out.println( reciveAnswer( bin ) );

        bOut.printf( "Subject: %s\n", subject );
        System.out.printf( "Subject: %s\n", subject );

        bOut.printf( "%s\n.\r\n", body );
        System.out.printf( "%s\n.\r\n", body );
        System.out.println( reciveAnswer( bin ) );

        System.out.println( "Sending order QUIT..." );
        bOut.println( "QUIT" );
        System.out.println( reciveAnswer( bin ) );

    }

    private String reciveAnswer( BufferedReader bin ) throws IOException {
        return bin.readLine();
    }

    private void printAnswer( String answer ) {
        System.out.println( answer );
    }
}
