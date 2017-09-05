/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import org.junit.Before;
import org.junit.Test;

import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.beans.impl.CalculadorBasicoCuentas;
import edu.eci.pdsw.examples.beans.impl.CalculadorCuentaConIva;
import edu.eci.pdsw.examples.beans.impl.CalculadorCuentaConPropina;
import edu.eci.pdsw.examples.model.Bebida;
import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.model.Plato;

import static org.junit.Assert.*;

/**
 * Diseño de pruebas:
 * 
 * Clases de equivalencia:
 * 
 *  precio=suma del precio de todos los platos
 *  precio inicial=precio antes de iva/propina
 *      CE1: precio<=0
 *           Resultado esperado: error - el precio total no puede ser negativo
 *          
 *      CE2: 0<precio<=15000 y el restaurante no cobra iva
 *      	o el restaurante no cobra propina
 *           Resultado esperado: precio final=precio inical
 *           
 *      CE3: 15000<precio y el restaurante cobra propina
 *           Resultado esperado: precio final=(precio inicial)*1.1
 *          
 *      CE4: el restaurante cobra iva estandar
 *      	o el restaurante cobra iva bajo el regimen de 2016 y no hay bebidas azucaradas
 *           Resultado esperado: precio final=(precio inical)*1.19
 *           
 *      CE5: el restaurante cobra iva bajo el regimen del 2016 y hay bebidas azucaradas
 *           Resultado esperado: precio final= (precio inicial)*1.19
 *           								 + (precio bebidas azucaradas)*0.10
 *          
 * 
 *  
 * Condiciones de frontera:
 * 
 *      CF1: precio=0
 *           Clases de equivalencia relacionadas:CE1
 *           Resultado esperado: error- el precio no puede ser 0
 *           
 *      CF2: precio=1
 *      	 Clases de equivalencia relacionadas:CE1,CE2
 *      	 Resultado esperado: precio inicial
 *      
 *      CF3: precio=15000 y restaurante cobra propina
 *      	 Clases de equivalencia relacionadas:CE2,CE3
 *      	 Resultado esperado:precio inicial
 * 
 *      CF4: precio=15000 y restaurante no cobra propina
 *           Clases de equivalencia relacionadas:CE2,CE3
 *           Resultado esperado: precio inicial
 *           
 *      CF5: precio=15001 y restaurante no cobra propina
 *      	 Clases de equivalencia relacionadas:CE2,CE3
 *      	 Resultado esperado: precio inicial
 *      
 *      CF6: precio=15001 y restaurante cobra propina
 *      	 Clases de equivalencia relacionadas:CE2,CF3
 *      	 Resultado esperado:precio inicial*1.1
 *            
 *      CF7: hay bebidas azucaradas y restaurante cobra iva estandar 
 *      	 Clases de equivalencia relacionadas:CE4,CE5
 *      	 Resultado esperado:precio inicial*1.19
 * 
 *      CF8: no hay bebidas azucaradas y restaurante cobra iva estandar
 *           Clases de equivalencia relacionadas:CE4,CE5
 *           Resultado esperado: precio inicial*1.19
 *           
 *      CF9: no hay bebidas azucaradas y restaurante cobra iva 2016
 *      	 Clases de equivalencia relacionadas:CE4,CE5
 *      	 Resultado esperado: precio inicial*1.19
 *      
 *      CF10: hay bebidas azucaradas y restaurante cobra iva 2016
 *      	 Clases de equivalencia relacionadas:CE4,CF5
 *      	 Resultado esperado:(precio inicial)*1.19+(precio inicial bebidas azucaradas)*0.10
 *      
 *      
 *      CF11: solo hay 1 bebida azucarada y restaurante cobra iva 2016
 *      	 Clases de equivalencia relacionadas:CE4,CF5
 *      	 Resultado esperado:(precio inicial)*1.19+(precio inicial bebidas azucaradas)*0.10
 *      
 *      
 *      CF12: solo hay bebidas azucaradas y restaurante cobra iva 2016
 *      	 Clases de equivalencia relacionadas:CE4,CF5
 *      	 Resultado esperado:(precio inicial)*1.19+(precio inicial bebidas azucaradas)*0.10
 */
public class CalculadorCuentasTest {
    
    public CalculadorCuentasTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    /**
     * Pruebas clase de equivalencia CE1
     */
    @Test
    public void testClaseEquivalenciaCE1()
    {
    	CalculadorCuenta c= new CalculadorBasicoCuentas();
    	Orden o=new Orden();
    	
    	try
    	{
    		c.calcularCosto(o);
    	}catch(Exception e){
    		assertEquals("No esta lanzando la excepcion adecuada"
    					,e.getMessage(),"El precio total no puede ser cero");
    	}
    }
    
    /**
     * Pruebas clase de equivalencia CE2
     */
    @Test
    public void testClaseEquivalenciaCE2()
    {
    	CalculadorCuenta c1= new CalculadorBasicoCuentas();
    	CalculadorCuenta c2=new CalculadorCuentaConPropina();
    	Orden o = new Orden();
    	o.agregarItemOrden(new Plato("a",1));
    	assertEquals("No se calcula el costo adecuadamente con CF2"
    				,c1.calcularCosto(o),1);

    	o.agregarItemOrden(new Plato("b",14999));
    	assertEquals("No se calcula el costo adecuadamente con CF4",c1.calcularCosto(o),15000);
    	assertEquals("No se calcula el costo adecuadamente con CF3",c2.calcularCosto(o),15000);
    	
    	o.agregarItemOrden(new Plato("a",1));
    	assertEquals("No se calcula el costo adecuadamente con CF5",c1.calcularCosto(o),15001);
    	
    }
    
    /**
     * Pruebas clase de equivalencia CE3
     */
    @Test
    public void testClaseEquivalenciaCE3()
    {
    	CalculadorCuenta c=new CalculadorCuentaConPropina();
    	Orden o = new Orden();
    	
    	o.agregarItemOrden(new Plato("a",15001));
    	assertEquals("No se calcula el costo adecuadamente con CF6",c.calcularCosto(o),15001*1.1,0.01);
    }
    
    /**
     * Pruebas clase de equivalencia CE4
     */
    @Test
    public void testClaseEquivalenciaCE4()
    {

    	CalculadorCuenta cEstandar= new CalculadorCuentaConIva();
    	
    	CalculadorCuenta c2016=new CalculadorCuentaConIva();
    	
    	Orden oBebidasAzucaradas=new Orden();
    	
    	oBebidasAzucaradas.agregarItemOrden(new Plato("a",50));
    	oBebidasAzucaradas.agregarItemOrden(new Bebida("b",25,1001));
    	oBebidasAzucaradas.agregarItemOrden(new Bebida("c", 25, 999));
    	
    	assertEquals("No se calcula el costo adecuadamente con CF7",cEstandar.calcularCosto(oBebidasAzucaradas),119);
    	
    	Orden oNoBebidas=new Orden();
    	
    	oNoBebidas.agregarItemOrden(new Plato("a",50));
    	oNoBebidas.agregarItemOrden(new Plato("b",50));
    	
    	assertEquals("No se calcula el costo adecuadamente con CF8",cEstandar.calcularCosto(oNoBebidas),119);
    	
    	Orden oBebidasNoAzucaradas= new Orden();
    	
    	oBebidasNoAzucaradas.agregarItemOrden(new Plato("a",50));
    	oBebidasNoAzucaradas.agregarItemOrden(new Bebida("b",15,1));
    	oBebidasNoAzucaradas.agregarItemOrden(new Bebida("c", 15, 999));
    	oBebidasNoAzucaradas.agregarItemOrden(new Bebida("d", 20, 800));
    	
    	assertEquals("No se calcula el costo adecuadamente con CF9",c2016.calcularCosto(oBebidasNoAzucaradas),119);
    }
    
    
    /**
     * Pruebas clase de equivalencia CE5
     */
    @Test
    public void testClaseEquivalenciaCE5()
    {
    	CalculadorCuenta c2016=new CalculadorCuentaConIva();
    	
    	Orden oUnaBebida=new Orden();
    	
    	oUnaBebida.agregarItemOrden(new Plato("a",50));
    	oUnaBebida.agregarItemOrden(new Bebida("b",25,1001));
    	oUnaBebida.agregarItemOrden(new Bebida("c", 25, 999));
    	
    	assertEquals("No se calcula el costo adecuadamente con CF11",c2016.calcularCosto(oUnaBebida),100*1.19+25*0.10,0.01);
    	oUnaBebida.agregarItemOrden(new Bebida("d",25,1100));
    	assertEquals("No se calcula el costo adecuadamente con CF10",c2016.calcularCosto(oUnaBebida),125*1.19+50*0.10,0.01);
    	
    	Orden oSoloBebidas=new Orden();
    	
    	oSoloBebidas.agregarItemOrden(new Plato("a",50));
    	oSoloBebidas.agregarItemOrden(new Bebida("b",25,1001));
    	oSoloBebidas.agregarItemOrden(new Bebida("c", 25, 1235));
    	
    	assertEquals("No se calcula el costo adecuadamente con CF12",c2016.calcularCosto(oSoloBebidas),100*1.19+50*0.10,0.01);
    }
}
