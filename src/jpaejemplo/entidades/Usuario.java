package jpaejemplo.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//misma entidad
@Entity
public class Usuario {

    @Id
    private String email;
    private String nombre;
    private String apellido;
    private Integer edad;
    @OneToOne //esta relacion en UNIDIRECCIONAL, ya que si chequeamos en la clase Direccion no tenemos ninguna relacion descrita con Usuario. (anda a chequear)
    // Para persistir un objeto dirección SIOSI debe existir un objeto Usuario, y a ttravés del objeto usuario se realizan modificaciones a Direccion
    private Direccion direccion;

    public Usuario() {
    }

    public Usuario(String email, String nombre, String apellido, Integer edad, Direccion direccion) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", direccion=" + direccion + '}';
    }
}
