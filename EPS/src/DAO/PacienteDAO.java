/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Estrato;
import Modelo.Paciente;
import Modelo.Sede;
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
public class PacienteDAO implements DaoInterfacePaciente{
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    @Override
    public void crear(Paciente paciente) {
       
        
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into paciente values (?,?,?,?,?,?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from paciente where id_paciente = "+paciente.getId_paciente());
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Paciente ya registrado");
            }else{
            insertar.setInt(1,paciente.getId_paciente());
            insertar.setString(2,paciente.getNombre());
            insertar.setString(3,paciente.getDireccion());
            insertar.setDate(4,Date.valueOf(paciente.getFecha_nac().toString()));
            insertar.setString(5,paciente.getLugar_nac());
            insertar.setInt(6,paciente.getEstrato().getId_estrato());
            insertar.setInt(7,paciente.getSede().getId_sede());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            }  
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    
        
       
    }
    @Override
    public void buscar(Paciente paciente) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from paciente where id_paciente= ?");
            buscar.setInt(1, paciente.getId_paciente());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              paciente.setId_paciente(consulta.getInt("id_paciente"));
              paciente.setNombre(consulta.getString("nombre"));
              paciente.setDireccion(consulta.getString("direccion"));
              paciente.setFecha_nac(consulta.getDate("fecha_nac"));
              paciente.setLugar_nac(consulta.getString("lugar_nac"));
              paciente.setEstrato(new Estrato(consulta.getInt("id_estrato")));
              paciente.setSede(new Sede(consulta.getInt("id_sede")));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    }
    
    @Override
    public ArrayList<Paciente> MostrarTodo() {
            ArrayList<Paciente> lista1 = new ArrayList<>();
             String sql = "Select * from paciente";
            try {

                Connection conectar = conexion.Conexion();
                PreparedStatement insertar = conectar.prepareStatement(sql);
                ResultSet resultSet;
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     Paciente paciente1 = new Paciente(
                       rs.getInt("id_paciente"),
                       rs.getString("nombre"),
                       rs.getString("direccion"),
                       rs.getDate("fecha_nac"),
                       rs.getString("direccion"),new Estrato(
                       rs.getInt("id_estrato")),new Sede(
                       rs.getInt("id_sede")));
                    lista1.add(paciente1);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    @Override
    public void eliminar(Paciente paciente) {
        String sql="delete from paciente where id_paciente ="+paciente.getId_paciente();
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
        }catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
        }
    }
}
