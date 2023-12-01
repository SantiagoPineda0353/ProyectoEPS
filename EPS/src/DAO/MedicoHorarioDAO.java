/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Horario;
import Modelo.Medico;
import Modelo.MedicoHorario;
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
public class MedicoHorarioDAO {
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    public void crear(MedicoHorario medicoh) {
       
        
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into medico_horario values (?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from medico_horario where licencia_medica like '"+medicoh.getMedico().getLicencia_medica()+"' and id_horario like "+medicoh.getHorario().getId_horario());
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Medico ya registrado");
               
            }else{
            insertar.setString(1,medicoh.getMedico().getLicencia_medica());
            insertar.setInt(2,medicoh.getHorario().getId_horario());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
           
            }
            
           
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    
        
       
    }
    public void buscar(MedicoHorario medicoh) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from medico_horario where licencia_medica= ? and id_horario= ?");
            buscar.setString(1, medicoh.getMedico().getLicencia_medica());
            buscar.setInt(2, medicoh.getHorario().getId_horario());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              medicoh.getMedico().setLicencia_medica(consulta.getString("licencia_medica"));
              medicoh.getHorario().setId_horario(consulta.getInt("id_horario"));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
        
        }
    }
    public ArrayList<MedicoHorario> MostrarTodo() {
            ArrayList<MedicoHorario> lista1 = new ArrayList<>();
             String sql = "Select * from medico_horario";
           try {

               Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                ResultSet resultSet;
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     MedicoHorario medicoh1 = new MedicoHorario(
                       new Medico(rs.getString("licencia_medica"),null,null,null),
                       new Horario(rs.getInt("id_horario"),null,null,null));
                    lista1.add(medicoh1);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    public void eliminar(MedicoHorario medicoh) {
        String sql="delete from medico_horario where licencia_medica ="+medicoh.getMedico().getLicencia_medica();
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
        
        }
    }
}
