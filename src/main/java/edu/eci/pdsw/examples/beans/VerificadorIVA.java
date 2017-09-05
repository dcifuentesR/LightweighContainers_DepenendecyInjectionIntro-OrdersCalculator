package edu.eci.pdsw.examples.beans;

import edu.eci.pdsw.examples.model.ItemOrden;

public interface VerificadorIVA {
	/**
	 * 
	 * @param p
	 * @return
	 */
	public float obtenerPorcentaje(ItemOrden p);

}
