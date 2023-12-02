/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Medico;
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
public class MedicoDAO implements DaoInterfaceMedico{
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    @Override
    public void crear(Medico medico) {
       
        
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into medico values (?,?,?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from medico where licencia_medica like '"+medico.getLicencia_medica()+"'");
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Medico ya registrado");
               
            }else{
            insertar.setString(1,medico.getLicencia_medica());
            insertar.setString(2,medico.getNombre());
            insertar.setString(3,medico.getDireccion());
            insertar.setDate(4,Date.valueOf(medico.getFecha_nac().toString()));
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
            }
            
           
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    
        
       
    }
    @Override
    public void buscar(Medico medico) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from medico where licencia_medica= ?");
            buscar.setString(1, medico.getLicencia_medica());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              medico.setLicencia_medica(consulta.getString("licencia_medica"));
              medico.setNombre(consulta.getString("nombre"));
              medico.setDireccion(consulta.getString("direccion"));
              medico.setFecha_nac(consulta.getDate("fecha_nac"));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
         System.out.println("Error" + e.getMessage());
        }
    }
    @Override
    public ArrayList<Medico> MostrarTodo() {
            ArrayList<Medico> lista1 = new ArrayList<>();
             String sql = "Select * from medico";
           try {

               Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                ResultSet resultSet;
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     Medico medico1 = new Medico(
                       rs.getString("licencia_medica"),
                       rs.getString("nombre"),
                       rs.getString("direccion"),
                       rs.getDate("fecha_nac"));
                    lista1.add(medico1);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    @Override
    public void eliminar(Medico medico) {
        String sql="delete from medico where licencia_medica ="+medico.getLicencia_medica();
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
         System.out.println("Error" + e.getMessage());
        }
    }
}
