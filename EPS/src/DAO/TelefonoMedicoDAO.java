/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Medico;
import Modelo.TelefonoMedico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class TelefonoMedicoDAO implements DaoInterfaceTelefonoMedico{

       
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    
    @Override
    public void crear(TelefonoMedico TelMed) {
        
         try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO telefono_medico VALUES (?,?)");
            
            
            insertar.setString(2,TelMed.getMedico().getLicencia_medica());
            insertar.setInt(1,TelMed.getTelefono());
        
        
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    }

    @Override
    public void eliminar(TelefonoMedico TelMed) {
     
        String sql="delete from telefono_medico where licencia_medica = '"+TelMed.getMedico().getLicencia_medica()+
                "' and telefono = "+String.valueOf(TelMed.getTelefono());
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
        System.out.println("error:"+e);
        }
    }

    @Override
    public ArrayList<TelefonoMedico> MostrarTodo(Medico med) {
       
         ArrayList<TelefonoMedico> lista1 = new ArrayList<>();
        String sql = "Select * from telefono_medico where licencia_medica = '"+med.getLicencia_medica()+"'";
       try {
           
           Connection conectar = conexion.Conexion();
           PreparedStatement insertar = conectar.prepareStatement(sql);
            ResultSet resultSet;
            rs = insertar.executeQuery(sql);
        
            while (rs.next()) {
                 TelefonoMedico TelMed = new TelefonoMedico(                
                 rs.getInt("telefono"),
                 new Medico (rs.getString("licencia_medica")));
                 lista1.add(TelMed);
            }
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista1;
    }
    }
    

