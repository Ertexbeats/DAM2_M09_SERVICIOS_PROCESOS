/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficheroDeTexto;

import java.io.*;

/**
 *
 * @author ertex
 */
public class FicheroTexto {

    public static void main(String args[]) {
        try { // escritura de datos
            PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter("fitxers/prueba.txt")));
            salida.println("Este es un ejemplo de escritura y lectura de datos");
            salida.println("en un fichero.");
            salida.close();
            // lectura de datos
            BufferedReader entrada = new BufferedReader(new FileReader("fitxers/prueba.txt"));
            String s, s2 = new String();
            while ((s = entrada.readLine()) != null) {
                s2 += s + "\n";
            }
            System.out.println("Texto leido:" + "\n" + s2);
            entrada.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
