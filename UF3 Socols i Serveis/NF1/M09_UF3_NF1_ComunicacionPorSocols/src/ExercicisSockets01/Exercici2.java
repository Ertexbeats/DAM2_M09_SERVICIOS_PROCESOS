package ExercicisSockets01;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ertex
 */

/**
 * 2. El següent codi d'un servidor no compila. Fes les modificacions
 * necessàries per tal que compili i explica quins errors hi havia. La
 * explicació posa-la com a comentaris dins del codi
 *
 * import java.io.IOException; import java.net.*;
 *
 * public class main { public static void main(String[] args) throws IOException
 * { ServerSocket server = new Socket(90); while(true){ server.accept();
 * System.out.println("Client connectat"); server.close(); } } }
 */
public class Exercici2 {

    public static void main( String[] args ) {
        try {
            ServerSocket server = new ServerSocket( 90 );
            while ( true ) {
                server.accept();
                System.out.println( "Client connectat" );

                //server.close();
            }
        } catch ( IOException ex ) {
            Logger.getLogger( Exercici2.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }
}

/**
 * El error que tenia es que declaraba el objeto SeverSocket, y acontinuacion al
 * inicializarlo lo hacia como Socket asecas
 */
