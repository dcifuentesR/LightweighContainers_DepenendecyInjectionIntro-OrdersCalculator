package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.model.ItemOrden;
import edu.eci.pdsw.examples.model.Orden;

public class CalculadorCuentaConIva implements CalculadorCuenta {
	
	private VerificadorIVA ver;
	
	public CalculadorCuentaConIva()
	{
		ver=new VerificadorIVARegimen2013();
	}
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
