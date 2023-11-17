/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicisSockets01;

/**
 * @author alumne
 */
public class Exercici7_ClientApp {
    static public void main( String[] args ) {
        Exercici7_Client client = new Exercici7_Client( "localhost", 7000 );
        client.connect();
    }
}
