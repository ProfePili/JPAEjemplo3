package jpaejemplo.excepcion;

//Creamos una nueva clase Exception nuestra
public class ExcepcionPropia extends Exception{

    // contructor vacío
    public ExcepcionPropia() {
    }
    
    // constructor parametrizado, puede recibir un mensaje
    public ExcepcionPropia(String msg) {
        super(msg);
    }
}
