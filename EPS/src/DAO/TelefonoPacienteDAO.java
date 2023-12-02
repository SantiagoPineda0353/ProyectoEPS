/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Paciente;
import Modelo.TelefonoPaciente;
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
public class TelefonoPacienteDAO implements DaoInterfaceTelefonoPaciente{

      ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    
    
    @Override
    public void crear(TelefonoPaciente TelPac) {
        
         try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO telefono_paciente VALUES (?,?)");
            
            
            insertar.setInt(1,TelPac.getPaciente().getId_paciente());
            insertar.setInt(2,TelPac.getTelefono());
        
        
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
        
    }

    @Override
    public void eliminar(TelefonoPaciente TelPac) {
       
        String sql="delete from telefono_paciente where id_paciente = '"+String.valueOf(TelPac.getPaciente().getId_paciente())+
                "' and telefono = "+String.valueOf(TelPac.getTelefono());
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
        System.out.println("error:"+e);
        }
    }

    @Override
    public ArrayList<TelefonoPaciente> MostrarTodo(Paciente pac) {
       
        
        ArrayList<TelefonoPaciente> lista1 = new ArrayList<>();
        String sql = "Select * from telefono_paciente where id_paciente = "+String.valueOf(pac.getId_paciente());
       try {
           
           Connection conectar = conexion.Conexion();
           PreparedStatement insertar = conectar.prepareStatement(sql);
            ResultSet resultSet;
            rs = insertar.executeQuery(sql);
        
            while (rs.next()) {
                 TelefonoPaciente TelPac = new TelefonoPaciente(                
                 rs.getInt("telefono"),
                 new Paciente (rs.getInt("id_paciente")));
                 lista1.add(TelPac);
            }
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista1;
    }
        
    }
    
