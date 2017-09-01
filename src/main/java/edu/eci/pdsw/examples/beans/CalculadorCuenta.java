package edu.eci.pdsw.examples.beans;

import edu.eci.pdsw.examples.model.Orden;

public interface CalculadorCuenta {
	/**
	 * Calcula el costo total de la orden
	 * @param o la orden.
	 * @return el costo total de la orden
	 */
	public int calcularCosto(Orden o);
	
}
