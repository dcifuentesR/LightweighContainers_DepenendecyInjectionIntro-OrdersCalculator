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
public class ItemOrden {

	private int precio;

	private String nombre;

        public ItemOrden(){
            
        }
        
	public ItemOrden(String nombre, int precio) {
		super();
		this.precio = precio;
		this.nombre = nombre;
	}

        public void setPrecio(int precio) {
            this.precio = precio;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precio;
	}

    
}
