package jpaejemplo.servicios;

import jpaejemplo.entidades.Direccion;
import jpaejemplo.enumeraciones.Provincia;
import jpaejemplo.excepcion.ExcepcionPropia;
import jpaejemplo.persistencia.DireccionDAO;

public class DireccionServicio {

    private DireccionDAO direccionDAO;

    public DireccionServicio() {
        this.direccionDAO = new DireccionDAO();
    }

    public Direccion crearDireccion(Provincia provincia, String calle, int numeracion, boolean esDepartamento) throws Exception {
        try {
            // VALIDACIONES
            if (provincia == null | provincia.toString().trim().isEmpty()) {
                throw new ExcepcionPropia("CORREO NO VÁLIDO");
            }

            if (calle == null | calle.trim().isEmpty()) {
                throw new ExcepcionPropia("NOMBRE NO VÁLIDO");
            }

            if (Integer.toString(numeracion) == null | Integer.toString(numeracion).trim().isEmpty()) {
                throw new ExcepcionPropia("DEBE SER MAYOR DE EDAD");
            }

            // CREO UNA INSTANCIA DE USUARIO
            Direccion direccion = new Direccion();

            // SETEO LOS VALORES
            direccion.setProvincia(provincia);
            direccion.setCalle(calle);
            direccion.setNumeracion(numeracion);
            direccion.setEsDepartamento(esDepartamento);
            
            direccionDAO.guardarDireccion(direccion);
            return direccion;
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void mostrarProvincias() {
        for (Provincia prov : Provincia.values()) {
            System.out.println(prov);
        }
    }
}
