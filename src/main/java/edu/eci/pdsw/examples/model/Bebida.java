/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.model;

/**
 *
 * @author hcadavid
 */
public class Bebida extends ItemOrden{
    
    private int calorias;

    public Bebida(String nombre, int precio, int calorias) {
        super(nombre, precio);
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }
    
    
    
}
