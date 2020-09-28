package test;

import datos.UsuarioDAO;
import domain.Usuario;

public class TestUsuario {

    public static void main(String[] args) {
        Usuario user = new Usuario("javier85", "uhu9sah45");
        UsuarioDAO usuarioNuevo = new UsuarioDAO();
        //usuarioNuevo.insert(user);
        
        Usuario userUpd = new Usuario(1, "iDaniel", "5gf4h24hgx");
        usuarioNuevo.update(userUpd);
        
        //Usuario userDelete = new Usuario(5, "javier85", "uhu9sah45");
        //usuarioNuevo.delete(userDelete);
        
        UsuarioDAO listaUsuarios = new UsuarioDAO();
        listaUsuarios.usuarios().forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });

    }
}
