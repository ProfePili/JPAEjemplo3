/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaejemplo;

import jpaejemplo.excepcion.ExcepcionPropia;
import jpaejemplo.menu.Menu;
import jpaejemplo.servicios.DireccionServicio;

/**
 *
 * @author Pili
 */
public class JPAEjemplo_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        try {
            Menu menu = new Menu();
            menu.menuPrincipal();
            

        } catch (ExcepcionPropia e) {
            throw new ExcepcionPropia("qqueso");
        }
    }
}
