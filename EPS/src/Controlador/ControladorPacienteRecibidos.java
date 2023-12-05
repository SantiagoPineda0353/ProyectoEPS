/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.ConexionBD;
import DAO.PacienteDAO;
import Modelo.Cita;
import Modelo.Estrato;
import Modelo.Medico;
import Modelo.Modalidad;
import Modelo.Paciente;
import Modelo.Sede;
import Vista.AdministradorActualizarPaciente;
import Vista.AdministradorRegistropaciente;
import Vista.AdministradorVerPacientesRecibidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ControladorPacienteRecibidos implements ActionListener{
//botonGuardarpaciente
    AdministradorVerPacientesRecibidos vista= new AdministradorVerPacientesRecibidos();
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    
    Paciente pa= new Paciente();
    Estrato e= new Estrato();
    Sede s= new Sede();
    
    
    public ControladorPacienteRecibidos(AdministradorVerPacientesRecibidos p) {
        this.vista=p;
        this.vista.jButton_actualizar.addActionListener(this);
    }
    
    
    
    
    
    public ArrayList<Cita> MostrarConsulta() {
            ArrayList<Cita> lista1 = new ArrayList<>();
            String sql = "Select * from paciente";
            try {

                Connection conectar = conexion.Conexion();
               PreparedStatement insertar = conectar.prepareStatement(sql);
                //ResultSet resultSet;
                rs = insertar.executeQuery(sql);

                while (rs.next()) {
                     Cita cita1 = new Cita(
                       rs.getInt("id_cita"),
                       rs.getString("diagnostico"),
                      rs.getTimestamp("fecha_hora"),
                       new Paciente(rs.getInt("id_paciente"),null,null,null,null,null,null),
                       new Modalidad(rs.getInt("id_modalidad"),null),
                       new Sede(rs.getInt("id_sede"),null),
                       new Medico(rs.getString("id_medico"),null,null,null));
                    lista1.add(cita1);
                }
            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jButton_actualizar){
           //crearPaciente();
        }
        
    }
    
}
