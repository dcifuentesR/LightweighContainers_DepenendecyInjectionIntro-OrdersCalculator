package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.Orden;

public class CalculadorCuentaConPropina implements CalculadorCuenta {

	/**
	 * Calcula el costo total de la orden como la suma del costo de todos los platos(se asume que el iva esta incluida ahi).
	 * Se cobra el 10% sobre el total de la factura si el valor total de esta supera los $15.000 pesos
	 * @param o la orden
	 * @return el costo total de la orden
	 */
	@Override
	public int calcularCosto(Orden o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
