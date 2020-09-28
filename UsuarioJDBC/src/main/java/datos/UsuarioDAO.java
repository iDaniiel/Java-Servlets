package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password ) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELTE = "DELETE FROM usuario WHERE id_usuario = ?";

    public List<Usuario> usuarios() {
        Connection cnn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            cnn = getConnection();
            stm = cnn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");

                Usuario us = new Usuario(idUsuario, usuario, password);
                usuarios.add(us);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                rs.close();
                stm.close();
                cnn.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return usuarios;
    }

    public int insert(Usuario usuario) {
        Connection cnn = null;
        PreparedStatement stm = null;
        int afectados = 0;

        try {
            cnn = getConnection();
            stm = cnn.prepareStatement(SQL_INSERT);
            stm.setString(1, usuario.getUsuario());
            stm.setString(2, usuario.getPassword());

            System.out.println("ejecutando query " + SQL_INSERT);
            afectados = stm.executeUpdate();
            System.out.println("Registros afectados: " + afectados);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cnn.close();
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return afectados;
    }

    public int update(Usuario usr) {
        Connection cnn = null;
        PreparedStatement stm = null;
        int afectados = 0;

        try {
            cnn = getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stm = cnn.prepareStatement(SQL_UPDATE);
            stm.setString(1, usr.getUsuario());
            stm.setString(2, usr.getPassword());
            stm.setInt(3, usr.getIdUsuario());
            
            afectados = stm.executeUpdate();
            System.out.println("Registros afectados: " + afectados);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cnn.close();
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return afectados;
    }

    public int delete(Usuario usr) {
        Connection cnn = null;
        PreparedStatement stm = null;
        int afectados = 0;
        try {
            cnn = getConnection();
            System.out.println("ejectutando query: " + SQL_DELTE);
            stm = cnn.prepareStatement(SQL_DELTE);
            stm.setInt(1, usr.getIdUsuario());
            
            afectados = stm.executeUpdate();
            System.out.println("Registros afectados: " + afectados );

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                cnn.close();
                stm.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return afectados;
    }
}
