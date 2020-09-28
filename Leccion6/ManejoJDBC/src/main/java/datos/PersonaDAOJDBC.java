package datos;

// Data Acces Object: patron de disenio
import datos.Conexion;
import static datos.Conexion.*;
import domain.PersonaDTO;
import domain.PersonaDTO;
import java.sql.*;
import java.util.*;
// Se debe tener una clase de acceso a datos por cada clase de entidad que realiza el crud de una clase
public class PersonaDAOJDBC implements IPersonaDAO{

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM Persona";
    private static final String SQL_INSERT = "INSERT INTO Persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public List<PersonaDTO> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {

                close(rs);
                close(stmt);
                close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return personas;
    }

    public int insert(PersonaDTO persona) {
        Connection conn = null;
        PreparedStatement stm = null;
        int registros = 0;

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setString(1, persona.getNombre());
            stm.setString(2, persona.getApellido());
            stm.setString(3, persona.getEmail());
            stm.setString(4, persona.getTelefono());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

    public int update(PersonaDTO persona) {
        Connection conn = null;
        PreparedStatement stm = null;
        int registros = 0;

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, persona.getNombre());
            stm.setString(2, persona.getApellido());
            stm.setString(3, persona.getEmail());
            stm.setString(4, persona.getTelefono());
            stm.setInt(5, persona.getIdPersona());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(PersonaDTO persona) {
               Connection conn = null;
        PreparedStatement stm = null;
        int registros = 0;

        try {
            conn = getConnection();
            stm = conn.prepareStatement(SQL_DELETE);
            stm.setInt(1, persona.getIdPersona());
            registros = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
