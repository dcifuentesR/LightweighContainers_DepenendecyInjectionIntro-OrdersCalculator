package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.model.ItemOrden;

public class VerificadorIvaEstandar implements VerificadorIVA {

	@Override
	public float obtenerPorcentaje(ItemOrden p) {
		return (float) 1.19;
	}

}
