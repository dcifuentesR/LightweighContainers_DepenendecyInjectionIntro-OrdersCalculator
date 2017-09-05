package edu.eci.pdsw.examples.services;

import static com.google.inject.Guice.createInjector;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.VerificadorIVA;
import edu.eci.pdsw.examples.beans.impl.CalculadorBasicoCuentas;
import edu.eci.pdsw.examples.beans.impl.CalculadorCuentaConIva;
import edu.eci.pdsw.examples.beans.impl.VerificadorIVARegimen2013;
import edu.eci.pdsw.examples.beans.impl.VerificadorIvaEstandar;

public class ManejadorOrdenesFactory {
	
	private static ManejadorOrdenesFactory instance=new ManejadorOrdenesFactory();
	
	private static Injector injector;
	
	public ManejadorOrdenesFactory()
	{
		injector=createInjector(new AbstractModule(){
			protected void configure()
			{
				bind(VerificadorIVA.class).to(VerificadorIvaEstandar.class);
				bind(CalculadorCuenta.class).to(CalculadorCuentaConIva.class);
				bind(ManejadorOrdenes.class).to(ManejadorOrdenesImpl.class);
			}
		}
		);
	}
	
	public ManejadorOrdenes getManejadorOrdenes()
	{
		return injector.getInstance(ManejadorOrdenes.class);
	}
	
	public static ManejadorOrdenesFactory getInstance()
	{
		return instance;
	}

}
