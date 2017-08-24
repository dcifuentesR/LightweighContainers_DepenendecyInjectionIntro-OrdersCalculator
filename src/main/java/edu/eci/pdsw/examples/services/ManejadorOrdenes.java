package edu.eci.pdsw.examples.services;

import java.util.LinkedList;
import java.util.List;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.impl.CalculadorBasicoCuentas;
import edu.eci.pdsw.examples.model.ExcepcionManejadorOrdenes;
import edu.eci.pdsw.examples.model.Orden;


public class ManejadorOrdenes {


	CalculadorBasicoCuentas calc=new CalculadorBasicoCuentas();
	
	List<Orden> ordenes;

                
	public ManejadorOrdenes(){
		ordenes=new LinkedList<>();
	}

        
                      
        public List<Orden> getOrdenes() {
            return ordenes;
        }
	
	public void registrarOrden(Orden o){
		ordenes.add(o);
	}
        
	public Orden consultarOrden(int n) throws ExcepcionManejadorOrdenes{
		if (n>=ordenes.size()) throw new ExcepcionManejadorOrdenes("Orden inexistente:");
		return ordenes.get(n);
	}
	
	public int calcularTotalOrden(int n) throws ExcepcionManejadorOrdenes{
		if (n>=ordenes.size()) throw new ExcepcionManejadorOrdenes("Orden inexistente:");
		return calc.calcularCosto(ordenes.get(n));		
	}
	
        
}
