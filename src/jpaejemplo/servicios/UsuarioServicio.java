package jpaejemplo.servicios;

import java.util.List;
import jpaejemplo.entidades.Direccion;
import jpaejemplo.entidades.Usuario;
import jpaejemplo.excepcion.ExcepcionPropia;
import jpaejemplo.persistencia.UsuarioDAO;

// mismo servicio
public class UsuarioServicio {

    private UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void crearUsuario(String email, String nombre, String apellido, int edad, Direccion direccion) throws Exception {

        try {
            // VALIDACIONES
            if (email == null | email.trim().isEmpty()) {
                throw new ExcepcionPropia("CORREO NO VÁLIDO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new ExcepcionPropia("NOMBRE NO VÁLIDO");
            }

            if (apellido == null | apellido.trim().isEmpty()) {
                throw new ExcepcionPropia("DEBE INGRESAR UN APELLIDO");
            }

            if (Integer.toString(edad) == null | edad < 18 | Integer.toString(edad).trim().isEmpty()) {
                throw new ExcepcionPropia("DEBE SER MAYOR DE EDAD");
            }

            if (direccion == null) {
                throw new ExcepcionPropia("DEBE INTRODUCIR LOS VALORES DE LA DIRECCION");
            }
            // CREO UNA INSTANCIA DE USUARIO
            Usuario usuario = new Usuario();

            // SETEO LOS VALORES
            usuario.setEmail(email);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEdad(edad);
            usuario.setDireccion(direccion);

            usuarioDAO.guardarUsuario(usuario);
        } catch (ExcepcionPropia e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarUsuario(String email, String nombre, String apellido, Integer edad) throws Exception {
        try {
            // VALIDACIONES
            if (email == null | email.trim().isEmpty()) {
                throw new Exception("CORREO NO VÁLIDO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("NOMBRE NO VÁLIDO");
            }

            if (apellido == null | apellido.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN APELLIDO");
            }

            if (Integer.toString(edad) == null | edad < 18 | Integer.toString(edad).trim().isEmpty()) {
                throw new Exception("DEBE SER MAYOR DE EDAD");
            }

            // CREO UNA INSTANCIA DE USUARIO
            Usuario usuario = new Usuario();

            // SETEO LOS VALORES
            usuario.setEmail(email);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEdad(edad);

            usuarioDAO.actualizarUsuario(usuario);
        } catch (ExcepcionPropia e) {
            e.printStackTrace();
            throw new ExcepcionPropia("ERROR DE SISTEMA");
        }
    }

    public void borrarUsuario(String email) throws Exception {
        try {
            // VALIDACIONES
            if (email == null | email.trim().isEmpty() | usuarioDAO.buscarUsuarioPorEmail(email) == null) {
                throw new Exception("CORREO NO VÁLIDO");
            }

            Usuario usuario = buscarUsuarioPorEmail(email);
            usuarioDAO.borrarUsuario(usuario);
        } catch (ExcepcionPropia e) {
            e.printStackTrace();
            throw new ExcepcionPropia("ERROR DE SISTEMA");
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) throws Exception {
        try {
            // VALIDACIONES
            if (email == null | email.trim().isEmpty()) {
                throw new Exception("EMAIL NO VÁLIDO");
            }

            return usuarioDAO.buscarUsuarioPorEmail(email);
        } catch (ExcepcionPropia e) {
            e.printStackTrace();
            throw new ExcepcionPropia("ERROR DE SISTEMA");
        }
    }

    public List<Usuario> buscarUsuarioPorRangoDeEdad(int edad1, int edad2) throws Exception {
        try {
            // VALIDACIONES
            if (Integer.toString(edad1) == null | Integer.toString(edad1).trim().isEmpty()) {
                throw new Exception("EDAD NO VÁLIDA");
            }

            if (Integer.toString(edad2) == null || Integer.toString(edad2).trim().isEmpty()) {
                throw new Exception("EDAD NO VÁLIDA");
            }

            return usuarioDAO.buscarUsuarioPorRangoEdad(edad1, edad2);
        } catch (ExcepcionPropia e) {
            e.printStackTrace();
            throw new ExcepcionPropia("ERROR DE SISTEMA");
        }
    }

    public void imprimirTodosLosUsuarios() throws Exception {
        try {
            List<Usuario> usuarios = usuarioDAO.imprimirTodosLosUsuarios();
            usuarios.forEach((u) -> System.out.println(u));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
    }

}
