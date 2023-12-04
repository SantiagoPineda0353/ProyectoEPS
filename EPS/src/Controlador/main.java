/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Conexion.ConexionBD;
import Vista.LoginEPS;
/**
 *
 * @author Santiago Pineda
 */
public class main {
    public static void main(String[] args) {
        ConexionBD con= new ConexionBD();
        con.Conexion();
        
         LoginEPS login=new LoginEPS();
         login.setVisible(true);
    }
}
