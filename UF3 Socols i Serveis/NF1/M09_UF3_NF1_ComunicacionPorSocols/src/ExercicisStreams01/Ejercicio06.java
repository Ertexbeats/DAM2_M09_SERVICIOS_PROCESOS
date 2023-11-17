/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExercicisStreams01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 6. Sabent que FileOutputStream i FileInputStream són streams orientats a
 * bytes, realitza un programa que permeti realitzar la copia d'un fitxer binari
 * d'origen a un fitxer binari de destí.
 */
public class Ejercicio06 {

    public static void main(String[] args) throws IOException {
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
