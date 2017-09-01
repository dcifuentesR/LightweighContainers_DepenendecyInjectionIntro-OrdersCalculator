/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.test;

import org.junit.Before;
import org.junit.Test;
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
 *      	 Resultado esperado:(precio inicial)*1.19+(precio final)*0.10
 *      
 *      
 *      CF11: solo hay 1 bebida azucarada y restaurante cobra iva 2016
 *      	 Clases de equivalencia relacionadas:CE4,CF5
 *      	 Resultado esperado:(precio inicial)*1.19+(precio final)*0.10
 *      
 *      
 *      CF12: solo hay bebidas azucaradas y restaurante cobra iva 2016
 *      	 Clases de equivalencia relacionadas:CE4,CF5
 *      	 Resultado esperado:(precio inicial)*1.19+(precio final)*0.10
 */
public class CalculadorCuentasTest {
    
    public CalculadorCuentasTest() {
    }
    
    @Before
    public void setUp() {
    }
    
}
