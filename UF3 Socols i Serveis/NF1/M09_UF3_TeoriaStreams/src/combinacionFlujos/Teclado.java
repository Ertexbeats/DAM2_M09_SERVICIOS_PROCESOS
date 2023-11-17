/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinacionFlujos;

import java.io.*;

/**
 *
 * @author ertex
 */
public class Teclado {

    /**
     * variable de clase asignada a la entrada estándar del sistema
     */
    public static BufferedReader entrada
            = new BufferedReader(new InputStreamReader(System.in));

    /**
     * lee una cadena desde la entrada estándar
     *
     * @returncadena de tipo String
     */
    public static String leerString() {
        String cadena = "";
        try {
            cadena = new String(entrada.readLine());
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }
        System.out.println("Mi String es el " + cadena);
        return cadena;
    }

    /**
     * lee un numero entero desde la entrada estandar
     *
     * @returnnumero entero de tipo int
     */
    public static int leerInt() {
        int entero = 0;
        boolean error = false;
        do {
            try {
                error = false;
                entero = Integer.valueOf(entrada.readLine()).intValue();
            } catch (NumberFormatException e) {
                error = true;
                System.out.println("Error en el formato del numero, intentelode nuevo.");
            } catch (IOException e) {
                System.out.println("Error de E/S");
            }
        } while (error);
        System.out.println("Mi numero es el " + entero);
        return entero;
    }
}
