/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package flujosEstandar;

import java.io.IOException;

/**
 *
 * @author ertex
 */
public class LecturaDeLinea {

    public static void main(String[] args) throws IOException {
        int c;
        int contador = 0;
        // se lee hasta encontrar el fin de linea
        while ((c = System.in.read()) != '\n') {
            contador++;
            System.out.println((char) c);
        }
        System.out.println();  // Se escribe el fin de línea
        System.err.println("Contados " + contador + " bytes en total.");

    }

}
