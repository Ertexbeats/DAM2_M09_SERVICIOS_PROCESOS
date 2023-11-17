/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisStreams01;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 *
 * 3. Sabent que la classe FileReader implementa un stream d'entrada que permet
 * llegir un fitxer, realitza un programa que mostri per pantalla el contingut
 * d'un fitxer de text. Podeu crear un objecte FileReader de la manera següent.
 * Recordeu tancar els stream abans de finalitzar el programa. FileReader f =
 * new FileReader("C:\\fitxer.txt");
 *
 * Nota: Com que FileReader hereta d'InputStream, aquest té els mateixos mètodes
 * per llegir caràcters que heu utilitzat per a System.in.
 */
public class Ejercicio03 {

    public static void main(String[] args) throws IOException {

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
}
