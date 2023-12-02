/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Dia;
import Modelo.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57302
 */
public class HorarioDAO implements DaoInterfaceHorario{
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    @Override
    public void crear(Horario horario) {
       
        
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into horario values (?,?,?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from horario where id_horario like '"+horario.getId_horario()+"'");
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Horario ya registrado");
               
            }else{
            insertar.setInt(1,horario.getId_horario());
            insertar.setString(2,horario.getHora_inicio().toString());
            insertar.setString(3,horario.getHora_fin().toString());
            insertar.setInt(4,horario.getDia().getId_dias());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
           
            }
            
           
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
    
        
       
    }
    
    @Override
    public void buscar(Horario horario) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from horario where id_horario= ?");
            buscar.setInt(1, horario.getId_horario());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              horario.setId_horario(consulta.getInt("id_horario"));
              horario.setHora_inicio(LocalTime.parse(consulta.getString("hora_inicio")));
              horario.setHora_fin(LocalTime.parse(consulta.getString("hora_fin")));
              horario.getDia().setId_dias(consulta.getInt("id_dia"));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
         System.out.println("Error" + e.getMessage());
        }
    }
    
    @Override
    public ArrayList<Horario> MostrarTodo() {
            ArrayList<Horario> lista1 = new ArrayList<>();
             String sql = "Select * from horario";
           try {

               Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     Horario horario1 = new Horario(
                       rs.getInt("id_horario"),
                       LocalTime.parse(rs.getString("hora_inicio")),
                       LocalTime.parse(rs.getString("hora_fin")),
                       new Dia(rs.getInt("id_dia"),null));
                    lista1.add(horario1);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    @Override
    public void eliminar(Horario horario) {
        String sql="delete from horario where id_horario ="+horario.getId_horario();
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }
}
