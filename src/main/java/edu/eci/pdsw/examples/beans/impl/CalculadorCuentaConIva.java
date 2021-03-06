package edu.eci.pdsw.examples.beans.impl;

import com.google.inject.Inject;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.model.ItemOrden;
import edu.eci.pdsw.examples.model.Orden;

public class CalculadorCuentaConIva implements CalculadorCuenta {
	
	@Inject
	private VerificadorIVA ver;
	
	/**
	 * Calcula el costo total de la orden.
	 * Se cobra el iva dependiendo de la forma que el restaurante decida
	 * @param o la orden
	 * @return el costo total de la orden
	 */
	@Override
	public int calcularCosto(Orden o) {
		float total=0;
		for (ItemOrden p:o.getItemsOrden()){
			total+=p.getPrecio()*ver.obtenerPorcentaje(p);
			
		}
		return (int)total;
		
	}

}
