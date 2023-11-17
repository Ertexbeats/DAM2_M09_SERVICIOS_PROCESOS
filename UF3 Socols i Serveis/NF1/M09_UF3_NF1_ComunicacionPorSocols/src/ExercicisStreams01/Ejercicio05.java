/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisStreams01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 5. Implementa un programa que realitzi la copia, caràcter a caràcter, d'un
 * fitxer de text d'origen a un fitxer de destí.
 */
public class Ejercicio05 {

    public static void main(String[] args) {
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
}
