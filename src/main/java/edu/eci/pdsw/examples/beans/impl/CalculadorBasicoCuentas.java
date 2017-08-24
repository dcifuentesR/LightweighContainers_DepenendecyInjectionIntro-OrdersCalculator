package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.ItemOrden;



public class CalculadorBasicoCuentas implements CalculadorCuenta {


	public int calcularCosto(Orden o) {
		int total=0;
		for (ItemOrden p:o.getItemsOrden()){
			total+=p.getPrecio();
		}
		return total;
	}

}
