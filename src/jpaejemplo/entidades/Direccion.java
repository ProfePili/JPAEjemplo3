package jpaejemplo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import jpaejemplo.enumeraciones.Provincia;

@Entity
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // utilizamos un Enum, ya que las provincias no pueden ser otras que las 23 que existen en argentinas.
    private Provincia provincia;
    private String calle;
    private int numeracion;
    private boolean esDepartamento;

    public Direccion() {
    }

    public Direccion(Provincia pais, String calle, int numeracion, boolean esDepartamento) {
        this.provincia = pais;
        this.calle = calle;
        this.numeracion = numeracion;
        this.esDepartamento = esDepartamento;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(int numeracion) {
        this.numeracion = numeracion;
    }

    public boolean isEsDepartamento() {
        return esDepartamento;
    }

    public void setEsDepartamento(boolean esDepartamento) {
        this.esDepartamento = esDepartamento;
    }

    @Override
    public String toString() {
        return "Direccion{" + "pais=" + provincia + ", calle=" + calle + ", numero=" + numeracion + ", esDepartamento=" + esDepartamento + '}';
    }

}
