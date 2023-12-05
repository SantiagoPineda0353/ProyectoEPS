/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Medico;
import Modelo.MedicoTitular;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57302
 */
public class MedicoTitularDAO implements DaoInterfaceMedicoTitular{
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    @Override
    public void crear(MedicoTitular medicoTitular) {
       
        
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into medico_titular values (?,?,?,?,?)");
            
            insertar.setString(1,medicoTitular.getLicencia_medica());
            insertar.setString(2,medicoTitular.getNombre());
            insertar.setString(3,medicoTitular.getDireccion());
            insertar.setDate(4,Date.valueOf(medicoTitular.getFecha_nac().toString()));
            insertar.setDate(5,Date.valueOf(medicoTitular.getFecha_ingreso().toString()));
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
           
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    
        
       
    }
    @Override
    public void buscar(MedicoTitular medicoTitular) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from medico_titular where licencia_medica= ?");
            buscar.setString(1, medicoTitular.getLicencia_medica());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              medicoTitular.setLicencia_medica(consulta.getString("licencia_medica"));
              medicoTitular.setNombre(consulta.getString("nombre"));
              medicoTitular.setDireccion(consulta.getString("direccion"));
              medicoTitular.setFecha_nac(consulta.getDate("fecha_nac"));
              medicoTitular.setFecha_ingreso(consulta.getDate("fecha_ingreso"));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    }
    @Override
    public ArrayList<MedicoTitular> MostrarTodo() {
            ArrayList<MedicoTitular> lista1 = new ArrayList<>();
             String sql = "Select * from medico_titular";
           try {

               Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                ResultSet resultSet;
                rs = insertar.executeQuery();

                while (rs.next()) {
                     MedicoTitular medicoTitular = new MedicoTitular(
                       rs.getDate("fecha_ingreso"),
                       rs.getString("licencia_medica"),
                       rs.getString("nombre"),
                       rs.getString("direccion"),
                       rs.getDate("fecha_nac"));
                    lista1.add(medicoTitular);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    @Override
    public void eliminar(MedicoTitular medicoTitular) {
        String sql="delete from medico_titular where licencia_medica ='"+medicoTitular.getLicencia_medica()+"'";
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
         System.out.println("Error" + e.getMessage());
        }
    }
}
