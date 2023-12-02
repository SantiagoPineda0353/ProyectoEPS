/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.CorreoElectronico;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Pineda
 */
public class CorreoElectronicoDAO implements DaoInterfaceCorreoElectronico {
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    @Override
    public void crear(CorreoElectronico correoElectronico) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into correo_electronico values (?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from correo_electronico where correo_electronico like '"+correoElectronico.getCorreoElectronico()+"' and id_paciente like '"+correoElectronico.getPaciente().getId_paciente()+"'");
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Correo Electronico ya registrado");
               
            }else{
            insertar.setString(1,correoElectronico.getCorreoElectronico());
            insertar.setInt(2,correoElectronico.getPaciente().getId_paciente());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
           
            }
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
         
        }
    
   
    
    @Override
    public void eliminar(CorreoElectronico correoElectronico) {
    String sql="delete from correo_electronico where correo_electronico like '"+correoElectronico.getCorreoElectronico()+"' and id_paciente like '"+correoElectronico.getPaciente().getId_paciente()+"'";
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }     
    }

    

    @Override
    public ArrayList<CorreoElectronico> MostrarTodo(Paciente paciente) {
        ArrayList<CorreoElectronico> lista1 = new ArrayList<>();
        String sql = "Select * from correo_electronico where id_paciente="+paciente.getId_paciente();
       try {
           
           Connection conectar = conexion.Conexion();
           PreparedStatement insertar = conectar.prepareStatement(sql);
            ResultSet resultSet;
            rs = insertar.executeQuery(sql);
        
            while (rs.next()) {
                 CorreoElectronico correoElectronico = new CorreoElectronico(
                 rs.getString("correo_electronico"),new Paciente(rs.getInt("id_paciente")));
                 lista1.add(correoElectronico);
            }
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista1;
    }
    
}
