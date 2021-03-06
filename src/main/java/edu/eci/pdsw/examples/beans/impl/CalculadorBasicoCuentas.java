package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.ItemOrden;



public class CalculadorBasicoCuentas implements CalculadorCuenta {

	/**
	 * Calcula el costo total de la orden como la suma del costo de todos los platos(se asume que el iva esta incluida ahi).
	 * Se calcula sin propina.
	 * @param o la orden
	 * @return el costo total de la orden
	 */
	public int calcularCosto(Orden o) {
		int total=0;
		for (ItemOrden p:o.getItemsOrden()){
			total+=p.getPrecio();
		}
		return total;
	}

}
