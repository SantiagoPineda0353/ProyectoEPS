/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.MedicoSustituto;
import Modelo.Periodo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Pineda
 */
public class PeriodoDAO implements DaoInterfacePeriodo{
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
 
    @Override
    public void crear(Periodo periodo) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into periodo values (?,?,?)");
            insertar.setString(1,periodo.getMedicoSustituto().getLicencia_medica());
            insertar.setDate(2, (Date) periodo.getFecha_ingreso());
            insertar.setDate(3, (Date) periodo.getFecha_salida());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    }
    
    @Override
    public void eliminar(Periodo periodo) {
    String sql="delete from periodo where fecha_de_ingreso >= '"+periodo.getFecha_ingreso()+"' and fecha_de_salida <= '"+periodo.getFecha_salida()+"' and licencia_medica = '"+periodo.getMedicoSustituto().getLicencia_medica()+"'";
       
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Periodo> MostrarTodo(MedicoSustituto medicoSustituto) {
      ArrayList<Periodo> lista1 = new ArrayList<>();
        String sql = "Select * from periodo where licencia_medica='"+medicoSustituto.getLicencia_medica()+"'";
       try {
           
           Connection conectar = conexion.Conexion();
           PreparedStatement insertar = conectar.prepareStatement(sql);
            ResultSet resultSet;
            rs = insertar.executeQuery(sql);
        
            while (rs.next()) {
                 Periodo periodo = new Periodo(
                 rs.getDate("fecha_de_ingreso"),rs.getDate("fecha_de_salida"),new MedicoSustituto(rs.getString("id_paciente"),null,null,null));
                 lista1.add(periodo);
            }
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista1; }
         
    }
    
   
    

