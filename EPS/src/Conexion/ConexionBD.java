/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD{

    Connection con;

    String URL = "jdbc:postgresql://localhost:5432/eps"; //Averiguar host, puede ser en el psql shell
    String USERNAME = "postgres";
    String PASSWORD = "123456"; //Contraseña asignada en la instalacion

    public Connection Conexion() {
      
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion con la Base de datos exitosa");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }


}
