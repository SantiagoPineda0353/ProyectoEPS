/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.MedicoSustituto;

/**
 *
 * @author 57302
 */
public class MedicoSustitutoDAO implements DaoInterfaceMedicoSustituto{
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    @Override
    public void crear(MedicoSustituto medicoSustituto) {
       
        
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into medico_sustituto values (?,?,?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from medico_sustituto where licencia_medica like '"+medicoSustituto.getLicencia_medica()+"'");
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Medico ya registrado");
            }else{
            insertar.setString(1,medicoSustituto.getLicencia_medica());
            insertar.setString(2,medicoSustituto.getNombre());
            insertar.setString(3,medicoSustituto.getDireccion());
            insertar.setDate(4,Date.valueOf(medicoSustituto.getFecha_nac().toString()));
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            }
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    
        
       
    }
    @Override
    public void buscar(MedicoSustituto medicoSustituto) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from medico_sustituto where licencia_medica= ?");
            buscar.setString(1, medicoSustituto.getLicencia_medica());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              medicoSustituto.setLicencia_medica(consulta.getString("licencia_medica"));
              medicoSustituto.setNombre(consulta.getString("nombre"));
              medicoSustituto.setDireccion(consulta.getString("direccion"));
              medicoSustituto.setFecha_nac(consulta.getDate("fecha_nac"));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    }
    @Override
    public ArrayList<MedicoSustituto> MostrarTodo() {
            ArrayList<MedicoSustituto> lista1 = new ArrayList<>();
             String sql = "Select * from medico_sustituto";
           try {

               Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                ResultSet resultSet;
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     MedicoSustituto medicoSustituto = new MedicoSustituto(
                       rs.getString("licencia_medica"),
                       rs.getString("nombre"),
                       rs.getString("direccion"),
                       rs.getDate("fecha_nac"));
                    lista1.add(medicoSustituto);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    @Override
    public void eliminar(MedicoSustituto medicoSustituto) {
        String sql="delete from medico_sustituto where licencia_medica ="+medicoSustituto.getLicencia_medica();
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
}
