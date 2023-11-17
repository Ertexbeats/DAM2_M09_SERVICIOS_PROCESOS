package com.proven.Server;

public class Server_App {
    public static void main( String[] args ) {
        Server app = new Server( "127.0.0.1", 8080 );
        app.init();
    }
}
