/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combinacionFlujos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ertex
 */
public class Eco {

    public static void main(String[] args) throws IOException {
        BufferedReader erentradaEstandar = new BufferedReader(new InputStreamReader(System.in));
        String mensaje;

        System.out.println("Introducirunalíneade texto:");
        mensaje = erentradaEstandar.readLine();
        System.out.println("Introducido: \"" + mensaje + "\"");
    }

}
