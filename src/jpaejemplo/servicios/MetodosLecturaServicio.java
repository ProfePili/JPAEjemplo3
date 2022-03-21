package jpaejemplo.servicios;

import java.util.List;
import java.util.Scanner;
import jpaejemplo.entidades.Direccion;
import jpaejemplo.entidades.Usuario;
import jpaejemplo.enumeraciones.Provincia;
import jpaejemplo.excepcion.ExcepcionPropia;

// En esta clase encontraremos todos loss métodos que hacen uso
// del Scanner: métodos que leen datos ingresados x teclado
public class MetodosLecturaServicio {

    private UsuarioServicio usuarioServicio;
    private DireccionServicio direccionServicio;
    private Scanner scanner;

    public MetodosLecturaServicio() {
        // ISO-8859-1 PERMITE USAR CARACTERES ESPECIALES
        scanner = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        usuarioServicio = new UsuarioServicio();
        direccionServicio = new DireccionServicio();

    }

    public void crearUsuario() throws Exception {
        try {
            System.out.println("INGRESE CORREO: ");
            String email = scanner.next();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = scanner.next();

            System.out.println("INGRESE APELLIDO: ");
            String apellido = scanner.next();

            System.out.println("INGRESE SU EDAD: ");
            int edad = scanner.nextInt();

            Direccion direccion = crearDireccion();
            usuarioServicio.crearUsuario(email, nombre, apellido, edad, direccion);
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
        }
    }

    public Direccion crearDireccion() throws Exception {
        try {
            System.out.println("********* SUS DATOS DE VIVIENDA Y DOMICILIO *********");
            System.out.println("INGRESE EL NOMBRE DE LA PROVINCIA EN LA QUE VIVE SEGUN LAS SIGUIENTES OPCIONES: ");
            DireccionServicio.mostrarProvincias(); // utilizando el método values de los Enum
            Provincia prov = Provincia.valueOf(scanner.next());

            System.out.println("INGRESE CALLE:: ");
            String calle = scanner.next();

            System.out.println("INGRESE NUMERACIÓN: ");
            int numeracion = scanner.nextInt();

            System.out.println("¿ES UN DEPARTAMENTO?  TRUE = SI / FALSE = NO ");
            boolean esDepartamento = scanner.nextBoolean();

            return direccionServicio.crearDireccion(prov, calle, numeracion, esDepartamento);
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void modificarUsuario() throws Exception {
        try {
            System.out.println("INGRESE CORREO: ");
            String correo = scanner.next();

            System.out.println("INGRESE EL NUEVO NOMBRE: ");
            String nombre = scanner.next();

            System.out.println("INGRESE EL NUEVO APELLIDO: ");
            String apellido = scanner.next();

            System.out.println("INGRESE LA NUEVA EDAD: ");
            int edad = scanner.nextInt();

            usuarioServicio.actualizarUsuario(correo, nombre, apellido, edad);
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarUsuario() throws Exception {
        try {
            System.out.println("INGRESE EL CORREO DEL USUARIO QUE DESEA ELIMINAR: ");
            String email = scanner.next();

            usuarioServicio.borrarUsuario(email);
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuario buscarUsuarioPorEmail() throws Exception {
        try {
            System.out.println("INGRESE EL CORREO DEL USUARIO QUE DESEA BUSCAR: ");
            String email = scanner.next();

            return usuarioServicio.buscarUsuarioPorEmail(email);
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Usuario> buscarUsuarioPorRangoEdad() throws Exception {
        try {
            System.out.println("INGRESE LA EDAD MENOR QUE PUEDE TENER EL USUARIO: ");
            int edadMenor = scanner.nextInt();

            System.out.println("INGRESE LA EDAD MAYOR QUE PUEDE TENER EL USUARIO: ");
            int edadMayor = scanner.nextInt();

            return usuarioServicio.buscarUsuarioPorRangoDeEdad(edadMenor, edadMayor);
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
