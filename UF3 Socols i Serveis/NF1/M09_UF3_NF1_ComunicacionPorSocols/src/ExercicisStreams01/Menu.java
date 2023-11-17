/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisStreams01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ertex
 */
public class Menu {

    private final String[] mainMenuOptions = {
        "Exit", "Exercici1", "Exercici2", "Exercici3", "Exercici4", "Exercici5", "Exercici6"
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
                    ejercicio4();
                    break;
                case 5:
                    ejercicio5();
                    break;
                case 6:
                    ejercicio6();
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

    protected void ejercicio1() throws IOException {
        int c;
        int contador = 0;
        System.out.println("Introduce una frase: ");
        while ((c = System.in.read()) != '\n') {
            contador++;
            System.out.print((char) c);
        }
    }

    protected void ejercicio2() throws IOException {
        int c;
        int contador = 0;
        // se lee hasta encontrar el fin de linea
        while ((c = System.in.read()) != '\n') {
            contador++;
            //System.out.print((char) c);
            System.out.println((char) c + " = " + c);
        }
    }

    protected void ejercicio3() {
        try {
            FileReader r = new FileReader("fitxers/prueba.txt");
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
            r.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void ejercicio4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Write: ");
        String frase = sc.next();
        try {
            FileWriter r = new FileWriter("fitxers/prueba.txt", true);
            r.write(frase);
            r.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    protected void ejercicio5() {
        try (FileReader f = new FileReader("fitxers/prueba.txt")) {
            int c;
            while ((c = f.read()) != -1) {
                FileWriter r = new FileWriter("fitxers/destino.txt", true);
                r.write(c);
                r.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("Error reading");
        }
    }

    protected void ejercicio6() throws FileNotFoundException, IOException {
        List<Byte> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("fitxers/ex6Origen.txt")) {
            int x;  //variable to store each byte read
            while ((x = fis.read()) != -1) { //while not end of file,  keep reading
                data.add((byte) x);
                try (FileOutputStream fos = new FileOutputStream("fitxers/ex6Destino.txt")) {
                    for (Byte b : data) {
                        fos.write(b);
                    }
                }
            }
        }
    }
}
