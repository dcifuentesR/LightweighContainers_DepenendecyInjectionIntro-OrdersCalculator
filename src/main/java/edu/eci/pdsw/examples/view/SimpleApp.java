/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.view;

import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.model.Plato;
import edu.eci.pdsw.examples.services.ManejadorOrdenes;

/**
 *
 * @author hcadavid
 */
public class SimpleApp {

    public static void main(String a[]) {
        ManejadorOrdenes mo=new ManejadorOrdenes();
        cargarOrdenes(mo);
        
    }

    private static void cargarOrdenes(ManejadorOrdenes mo) {

        Orden o = new Orden();
        o.agregarPlato(new Plato("pizza", 7500));
        o.agregarPlato(new Plato("gaseosa", 3900));
        o.agregarPlato(new Plato("hamburguesa", 8000));
        o.agregarPlato(new Plato("gaseosa 350", 200));

        mo.registrarOrden(o);

        o = new Orden();

        o.agregarPlato(new Plato("pizza", 7500));
        o.agregarPlato(new Plato("pizza", 7500));
        o.agregarPlato(new Plato("pizza", 7500));
        o.agregarPlato(new Plato("gaseosa litro", 4000));

        mo.registrarOrden(o);
    }

}
