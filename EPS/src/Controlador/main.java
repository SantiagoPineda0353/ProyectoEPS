/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Conexion.ConexionBD;
import Vista.LoginEPS;
import java.sql.Timestamp;
/**
 *
 * @author Santiago Pineda
 */
public class main {
    public static void main(String[] args) {
        Timestamp timestampActual = new Timestamp(System.currentTimeMillis());
        System.out.println("Timestamp actual: " + timestampActual);

        
         LoginEPS login=new LoginEPS();
         login.setVisible(true);
    }
}
