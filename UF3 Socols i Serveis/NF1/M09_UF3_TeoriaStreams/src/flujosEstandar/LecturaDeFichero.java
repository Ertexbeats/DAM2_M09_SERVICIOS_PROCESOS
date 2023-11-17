/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flujosEstandar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author ertex
 */
public class LecturaDeFichero {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("fitxers/prueba.txt"));
            String linea = reader.readLine();
            while (linea != null) {
                // procesar el textode la línea 
                System.out.println(linea);
                linea = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
            // no se encontró el fichero 
        } catch (IOException e) {
            // algo fuemal al leer o cerrar el fichero
            System.out.println(e.getLocalizedMessage());
        }

    }

}
