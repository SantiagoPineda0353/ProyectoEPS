/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Cita;
import Modelo.Examen;
import Modelo.Paciente;
import Modelo.SolicitarExamen;
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
public class SolicitarExamenDAO implements DaoInterfaceSolicitarExamen{

     
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    
    
    @Override
    public void crear(SolicitarExamen SoliExam) {
       
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO solicitar_examen VALUES (?,?,?)");
            
            
            insertar.setInt(1,SoliExam.getCita().getId_cita());
            insertar.setInt(2,SoliExam.getPaciente().getId_paciente());
            insertar.setInt(3,SoliExam.getExamen().getId_examen());
        
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
        
    }

    @Override
    public void eliminar(SolicitarExamen SoliExam) {
       
        String sql="delete from solicitar_examen where id_cita ="+String.valueOf(SoliExam.getCita().getId_cita())+
                "and id_paciente ="+String.valueOf(SoliExam.getPaciente().getId_paciente())+" and id_examen = "+String.valueOf(SoliExam.getExamen().getId_examen());
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
         System.out.println("error:"+e);
        }
        
    }

  

    @Override
    public ArrayList<SolicitarExamen> MostrarTodo(Cita cita) {
        
         ArrayList<SolicitarExamen> lista1 = new ArrayList<>();
        String sql = "Select * from solicitar_examen where id_cita="+String.valueOf(cita.getId_cita());
       try {
           
           Connection conectar = conexion.Conexion();
           PreparedStatement insertar = conectar.prepareStatement(sql);
            ResultSet resultSet;
            rs = insertar.executeQuery(sql);
        
            while (rs.next()) {
                 SolicitarExamen SoliExam = new SolicitarExamen(
                 new Cita (rs.getInt("id_cita")),
                 new Paciente (rs.getInt("id_paciente")),
                 new Examen (rs.getInt("id_examen")));
                 lista1.add(SoliExam);
            }
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista1;
    }
        
    }
    
    
    
