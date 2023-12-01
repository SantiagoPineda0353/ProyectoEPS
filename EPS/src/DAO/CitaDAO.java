/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Conexion.ConexionBD;
import Modelo.Cita;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import Modelo.Paciente;
import Modelo.Modalidad;
import Modelo.Sede;
import Modelo.Medico;
/**
 *
 * @author 57302
 * 
 */
public class CitaDAO implements DaoInterfaceCita{
    
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    
    @Override
    public void crear(Cita cita){
            try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into cita values (default,?,?,?,?,?,?)");
            
            
            insertar.setLong(1,cita.getPaciente().getId_paciente());
            insertar.setString(2,cita.getDiagnostico());
            insertar.setString(3, cita.getFecha_hora().toString());
            insertar.setInt(4,cita.getModalidad().getId_modalidad());
            insertar.setInt(5, cita.getSede().getId_sede());
            insertar.setString(6, cita.getMedico().getLicencia_medica());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    }
    @Override
    public void buscar(Cita cita) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from cita where id_cita= ?");
            buscar.setLong(1, cita.getId_cita());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              cita.setId_cita(Integer.parseInt(consulta.getString("id_cita")));
              cita.getPaciente().setId_paciente(Integer.parseInt(consulta.getString("id_paciente")));
              cita.setFecha_hora(LocalDateTime.parse(consulta.getString("fecha_hora")));
              cita.getModalidad().setId_modalidad(Integer.parseInt(consulta.getString("id_modalidad")));
              cita.getSede().setId_sede(Integer.parseInt(consulta.getString("id_sede")));
              cita.getMedico().setLicencia_medica(consulta.getString("id_medico"));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
        
        }
    }
    @Override
    public ArrayList<Cita> MostrarTodo() {
            ArrayList<Cita> lista1 = new ArrayList<>();
             String sql = "Select * from cita ";
           try {

               Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                //ResultSet resultSet;
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     Cita cita1 = new Cita(
                       rs.getInt("id_cita"),
                       rs.getString("diagnostico"),
                       LocalDateTime.parse(rs.getString("fecha_hora")),
                       new Paciente(rs.getInt("id_paciente"),null,null,null,null,null,null),
                       new Modalidad(rs.getInt("id_modalidad"),null),
                       new Sede(rs.getInt("id_sede"),null),
                       new Medico(rs.getString("id_medico"),null,null,null));
                    lista1.add(cita1);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    @Override
    public void eliminar(Cita cita) {
        String sql="delete from cita where id_cita ="+String.valueOf(cita.getId_cita());
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
        
        }
    }
}
