package jpaejemplo.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import jpaejemplo.excepcion.ExcepcionPropia;
import jpaejemplo.servicios.MetodosLecturaServicio;
import jpaejemplo.servicios.UsuarioServicio;

// El menú que tenemos acá es igual al del ejemplo2 porque Usuario y Direccion tienen una relacion de dependencia, donde no puede exstir un objeto direccion
// si no existe un objeto Uusario al cual estará asociado.
public class Menu {

    private MetodosLecturaServicio metodosLecturaServicio;
    private UsuarioServicio usuarioServicio;
    private Scanner scanner;
    private int opcion;

    // constructor vacío
    // INICIALIZAMOS NUESTROS ATRIBUTOS
    public Menu() {
        scanner = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        opcion = 0;
        metodosLecturaServicio = new MetodosLecturaServicio();
        usuarioServicio = new UsuarioServicio();
    }

    public void menuPrincipal() throws Exception {
        do {
            try {
                System.out.println("ELIJA UNA OPCIÓN");
                System.out.println("1. CREAR USUARIO");
                System.out.println("2. MODIFICAR USUARIO");
                System.out.println("3. ELIMINAR USUARIO");
                System.out.println("4. MOSTRAR USUARIOS");
                System.out.println("5. BUSCAR USUARIO POR MAIL");
                System.out.println("6. BUSCAR USUARIOS POR RANGO DE EDAD");
                System.out.println("7. SALIR");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        metodosLecturaServicio.crearUsuario();
                        break;
                    case 2:
                        metodosLecturaServicio.modificarUsuario();
                        break;
                    case 3:
                        metodosLecturaServicio.eliminarUsuario();
                        break;
                    case 4:
                        usuarioServicio.imprimirTodosLosUsuarios();
                        break;
                    case 5:
                        System.out.println(metodosLecturaServicio.buscarUsuarioPorEmail());
                        break;
                    case 6:
                        System.out.println(metodosLecturaServicio.buscarUsuarioPorRangoEdad());
                        break;
                    case 7:
                        System.out.println("*** SESION FINZALIZADA ***");
                        break;
                    default:
                        System.out.println("LA OPCIÓN INGRESADA NO ES VÁLIDA");
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                scanner.next();
            } catch (ExcepcionPropia e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (opcion != 7);

    }

}
