package ExercicisSockets01;

public class Exercici6_ClientApp {
    public static void main( String[] args ) {
        // Inicializamos el ClientChat
        Exercici6_ClientChat app = new Exercici6_ClientChat( "127.0.0.1", 7000 );
        app.connect();
    }
}
