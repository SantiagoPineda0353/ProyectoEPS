/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Paciente;
import Modelo.ProgramaEspecial;
import Modelo.ProgramaEspecialAdulto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.lang.reflect.Field; 
/**
 *
 * @author user
 */
public class ProgramaEspecialAdultoDAO implements DaoInterfaceProgramaEspecialAdulto {

    
    
      ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    @Override
    public void crear(ProgramaEspecialAdulto ProEspAdu) {

        
           try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("INSERT INTO programa_especial_adulto VALUES (?,?,?)");
            
            
            insertar.setInt(1,ProEspAdu.getPaciente().getId_paciente());
            insertar.setInt(2,ProEspAdu.getPrograma().getId_programa());
            insertar.setString(3,ProEspAdu.getAsistencia());
        
        
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
        
    }

    @Override
    public void eliminar(ProgramaEspecialAdulto ProEspAdu) {
        
         String sql="delete from programa_especial_adulto where id_paciente = "+String.valueOf(ProEspAdu.getPaciente().getId_paciente())+
                " and id_programa = "+String.valueOf(ProEspAdu.getPrograma().getId_programa());
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
        System.out.println("error:"+e);
        }
    }

    @Override
    public ArrayList<ProgramaEspecialAdulto> MostrarTodo(Paciente pac) {
      
          
        ArrayList<ProgramaEspecialAdulto> lista1 = new ArrayList<>();
        String sql = "Select * from programa_especial_adulto where id_paciente = "+String.valueOf(pac.getId_paciente());
       try {
           
           Connection conectar = conexion.Conexion();
           PreparedStatement insertar = conectar.prepareStatement(sql);
            ResultSet resultSet;
            rs = insertar.executeQuery(sql);
        
            while (rs.next()) {
                 ProgramaEspecialAdulto ProEspAdu = new ProgramaEspecialAdulto(                
                 new Paciente (rs.getInt("id_paciente")),
                 new ProgramaEspecial (rs.getInt("id_programa")),
                 rs.getString("asistencia"));
                 lista1.add(ProEspAdu);
            }
        } catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
        return lista1;
        
    }
    
}
