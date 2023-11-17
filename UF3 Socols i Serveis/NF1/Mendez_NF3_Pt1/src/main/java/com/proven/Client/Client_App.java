package com.proven.Client;

public class Client_App {
    public static void main( String[] args ) {
        Client app = new Client( "127.0.0.1", 8080 );
        app.connect();
    }
}
