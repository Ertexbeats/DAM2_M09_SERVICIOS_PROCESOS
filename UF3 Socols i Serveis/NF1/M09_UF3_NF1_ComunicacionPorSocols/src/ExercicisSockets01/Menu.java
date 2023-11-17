package ExercicisSockets01;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ertex
 */
public class Menu {

    private final String[] mainMenuOptions = {
        "Exit", "Exercici1", "Exercici2", "Exercici3", "Exercici4", "Exercici5", "Exercici6", "Exercici7"
    };

    public static void main(String[] args) throws IOException {
        Menu myApp = new Menu();
        myApp.run();
    }

    /**
     * Ejecuta la aplicacion y muestra el menu
     */
    void run() throws IOException {
        int opcion;
        boolean seguir = true;
        do {
            opcion = showMenu();
            switch (opcion) {
                case 0:
                    seguir = false;
                    break;
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    //ejercicio4();
                    break;
                case 5:
                    //ejercicio5();
                    break;
                case 6:
                    //ejercicio6();
                    break;
                case 7:
                    //ejercicio6();
                    break;
                default:
                    System.err.println("Opcion no implementada");
            }
        } while (seguir);
    }

    private int showMenu() {
        int opcion = -1;
        try {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < mainMenuOptions.length; i++) {
                System.out.println("[" + i + "] " + mainMenuOptions[i]);
            }
            System.out.print("Opcion: ");
            opcion = sc.nextByte();
        } catch (InputMismatchException ex) {
            System.err.println("Error");
        }
        return opcion;
    }

    private void ejercicio1() {
        try {
            Socket s = new Socket("127.0.0.1", 90);
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        // faltaban los imports y tratar exepciones
    }

    private void ejercicio2() {
        try {
            ServerSocket server = new ServerSocket(90);
            while (true) {
                server.accept();
                System.out.println("Client connectat");
               // server.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        /**
         * Se inicializo mal el server era ServerSocket server = new Socket(90);
         * y es ServerSocket server = new Socket(90);
         */
    }

    private void ejercicio3() {
        
    }

}
