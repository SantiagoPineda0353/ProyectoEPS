/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.ConexionBD;
import Modelo.Examen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 57302
 */
public class ExamenDAO {
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    
        public void crear(Examen examen) {
       
        
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement insertar = conectar.prepareStatement("insert into examen values (?,?)");
            
            
            ResultSet probar = insertar.executeQuery("select * from examen where id_examen like '"+examen.getId_examen()+"'");
            
            if(probar.next()){
                JOptionPane.showMessageDialog(null, "Examen ya registrado");
               
            }else{
            insertar.setInt(1, examen.getId_examen());
            insertar.setString(2, examen.getNombre());
            insertar.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
            }
        }catch(SQLException e){
            System.out.println("error:"+e);
        }
        
       
    }
        public void buscar(Examen examen) {
        try{
            Connection conectar = conexion.Conexion();
            PreparedStatement buscar = conectar.prepareStatement("select * from examen where id_examen= ?");
            buscar.setInt(1, examen.getId_examen());
            ResultSet consulta = buscar.executeQuery();
            
            if(consulta.next()){
              examen.setId_examen(consulta.getInt("id_examen"));
              examen.setNombre(consulta.getString("nombre"));
              JOptionPane.showMessageDialog(null, "Registro encontrado");
            }else{
                
                JOptionPane.showMessageDialog(null, "No se encuentra registrado");
            }
            
            
        }catch(SQLException e){
        
        }
    }
        public ArrayList<Examen> MostrarTodo() {
            ArrayList<Examen> lista1 = new ArrayList<>();
             String sql = "Select * from examen";
           try {

               Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     Examen examen1 = new Examen(
                       rs.getInt("id_examen"),
                       rs.getString("nombre"));
                    lista1.add(examen1);
                }

                rs.close();
                conectar.close();


            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
        
            public void eliminar(Examen examen) {
        String sql="delete from examen where id_examen ="+String.valueOf(examen.getId_examen());
        try{
            Connection conectar = conexion.Conexion();
               PreparedStatement borrar = conectar.prepareStatement(sql);        
                borrar.executeUpdate();
            
        }catch(Exception e){
        
        }
    }
        
}
