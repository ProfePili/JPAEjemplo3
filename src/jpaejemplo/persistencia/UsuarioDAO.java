package jpaejemplo.persistencia;

import java.util.List;
import jpaejemplo.entidades.Usuario;

// encontraremos más métodos, pero misma persistencia
public class UsuarioDAO extends DAO<Usuario> {

    public void guardarUsuario(Usuario usuario) {
        super.guardar(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        super.actualizar(usuario);
    }

    public void borrarUsuario(Usuario usuario) {
        super.borrar(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email) {

        Usuario usuario = em.find(Usuario.class, email);
//        Usuario usuario = (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.email LIKE :email")
//                .setParameter("email", email).getSingleResult();    // OTRA FORMA

        return usuario;
    }

    public List<Usuario> buscarUsuarioPorRangoEdad(int edadMenor, int edadMayor) {
        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u WHERE u.edad BETWEEN :edad1 AND :edad2")
                .setParameter("edad1", edadMenor).setParameter("edad2", edadMayor).getResultList();
        return usuarios;
    }

    public List<Usuario> imprimirTodosLosUsuarios() {

        List<Usuario> usuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();

        return usuarios;
    }
    
    public List<Usuario> buscarPorPaisYProvincia(String pais, String provincia) {

        //Opcion 1 sin JOIN
        //        List<Persona> personas = em.createQuery("SELECT p FROM Persona p WHERE p.direccion.pais LIKE :pais AND p.direccion.provincia LIKE :provincia ")
        //                .setParameter("pais", pais).setParameter("provincia", provincia).getResultList();
        //Opcion 2 con JOIN
        List<Usuario> personas = em.createQuery("SELECT p FROM Persona p JOIN p.direccion d WHERE d.pais LIKE :pais AND d.provincia LIKE :provincia ")
                .setParameter("pais", pais).setParameter("provincia", provincia).getResultList();
        return personas;
    }
}
