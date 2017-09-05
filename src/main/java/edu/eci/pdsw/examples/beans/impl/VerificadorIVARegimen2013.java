package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.model.Bebida;
import edu.eci.pdsw.examples.model.ItemOrden;
import edu.eci.pdsw.examples.model.Plato;

public class VerificadorIVARegimen2013 implements VerificadorIVA {

	@Override
	public float obtenerPorcentaje(ItemOrden p) {
		
		return (float) ((p instanceof Plato || 
						(p instanceof Bebida && ((Bebida) p).getCalorias()<=1000))?
								1.19:1.29);
	}

}
