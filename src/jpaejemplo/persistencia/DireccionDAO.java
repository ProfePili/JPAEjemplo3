

package jpaejemplo.persistencia;

import jpaejemplo.entidades.Direccion;


public class DireccionDAO extends DAO<Direccion>{
    public void guardarDireccion(Direccion direccion) {
        super.guardar(direccion);
    }

}
