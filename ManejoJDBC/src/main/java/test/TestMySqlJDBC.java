package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root","admin");
            Statement instruccion = conexion.createStatement();
            var sql = "select id_persona, nombre, apellido, email, telefono from persona";
            instruccion.execute(sql);
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next())
            {
                System.out.print("Id Persona: " + resultado.getInt("id_persona"));
                System.out.print(" Nombre: " + resultado.getString("nombre"));
                System.out.print(" Apellido: " + resultado.getString("apellido"));
                System.out.print(" email: " +  resultado.getString("email"));
                System.out.print(" telefono = " + resultado.getString("telefono"));
                System.out.println("");
                
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
