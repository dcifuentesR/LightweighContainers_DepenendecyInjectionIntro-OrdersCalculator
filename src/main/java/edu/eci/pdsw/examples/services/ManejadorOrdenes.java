package edu.eci.pdsw.examples.services;

import java.util.List;

import edu.eci.pdsw.examples.model.ExcepcionManejadorOrdenes;
import edu.eci.pdsw.examples.model.Orden;

public interface ManejadorOrdenes {
	
	public List<Orden> getOrdenes();
	
	public void registrarOrden(Orden o);
	
	public Orden consultarOrden(int n) throws ExcepcionManejadorOrdenes;
	
	public int calcularTotalOrden(int n) throws ExcepcionManejadorOrdenes;

}
