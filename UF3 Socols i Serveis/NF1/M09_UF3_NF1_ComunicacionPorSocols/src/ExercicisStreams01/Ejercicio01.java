package ExercicisStreams01;

import java.io.IOException;

/**
 * 1. Implementa un programa que permeti llegir de teclat una frase i la mostri
 * per pantalla quan premis l'enter. Només podeu fer servir System.in com a flux
 * d'entrada i System.out com a flux de sortida.
 */
public class Ejercicio01 {

    public static void main(String[] args) throws IOException {
        int c;
        int contador = 0;
        System.out.println("Introduce una frase: ");
        while ((c = System.in.read()) != '\n') {
            contador++;
            System.out.print((char) c);
        }
    }
}
