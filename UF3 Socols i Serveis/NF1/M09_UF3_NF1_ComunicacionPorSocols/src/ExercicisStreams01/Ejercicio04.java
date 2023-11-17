/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisStreams01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 4. Sabent que la classe FileWriter implementa un stream de sortida que permet
 * escriure en un fitxer, implementa un programa que li demani a l'usuari una
 * frase i la guardi en un fitxer. Podeu crear un objecte FileWriter de la
 * següent manera. Recordeu tancar els streams abans de finalitzar el programa.
 * FileWriter f = new FileWriter("C:\\fitxer.txt");
 *
 */
public class Ejercicio04 {

    public static void main(String[] args) {
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

}
