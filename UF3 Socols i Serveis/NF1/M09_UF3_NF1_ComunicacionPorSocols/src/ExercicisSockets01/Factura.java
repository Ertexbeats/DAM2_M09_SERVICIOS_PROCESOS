/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExercicisSockets01;

import java.io.Serializable;

/**
 * @author alumne
 */
public class Factura implements Serializable {
    private String nomClient;
    private String idFactura;
    private double total;

    public Factura( String nomClient, String idFactura, double total ) {
        this.nomClient = nomClient;
        this.idFactura = idFactura;
        this.total = total;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient( String nomClient ) {
        this.nomClient = nomClient;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura( String idFactura ) {
        this.idFactura = idFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal( double total ) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" + "nomClient=" + nomClient + ", idFactura=" + idFactura + ", total=" + total + '}';
    }


}
