package ExercicisSockets01;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ertex
 */

/**
 * 1. El següent codi no compila. Fes les modificacions necessàries per tal que
 * compili i explica quins errors hi havia. La explicació posa-la com a
 * comentaris dins del codi (//error 1: ....)
 *
 * public class main { public static void main(String[] args) { Socket s = new
 * Socket("127.0.0.1", 90); s.close(); } }
 */
public class Exercici1 {

    public static void main( String[] args ) {
        try {
            Socket s = new Socket( "127.0.0.1", 90 );

            s.close();
        } catch ( IOException ex ) {
            Logger.getLogger( Menu.class.getName() ).log( Level.SEVERE, null, ex );
        }
        // faltaban los imports y tratar exepciones
    }

}
