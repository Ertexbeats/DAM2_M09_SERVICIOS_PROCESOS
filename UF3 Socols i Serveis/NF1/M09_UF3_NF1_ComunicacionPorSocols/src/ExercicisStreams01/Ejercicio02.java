package ExercicisStreams01;

import java.io.IOException;

/**
 * 2. Implementa un programa que llegeixi per teclat una frase i mostri, per a
 * cada caràcter, la seva codificació entera. Només podeu fer servir System.in
 * com a flux d'entrada i System.out com a flux de sortida.
 */
public class Ejercicio02 {

    public static void main(String[] args) throws IOException {
        int c;
        int contador = 0;
        // se lee hasta encontrar el fin de linea
        while ((c = System.in.read()) != '\n') {
            contador++;
            //System.out.print((char) c);
            System.out.println((char) c + " = " + c);
        }
    }
}
