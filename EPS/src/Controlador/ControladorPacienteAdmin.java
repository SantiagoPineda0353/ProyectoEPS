/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.PacienteDAO;
import Modelo.Estrato;
import Modelo.Paciente;
import Modelo.Sede;
import Vista.AdministradorActualizarPaciente;
import Vista.AdministradorRegistropaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago Pineda
 */
public class ControladorPacienteAdmin implements ActionListener{
//botonGuardarpaciente
    AdministradorRegistropaciente registroPacienteVista=new AdministradorRegistropaciente();
    AdministradorActualizarPaciente verActualizarPacienteVista=new AdministradorActualizarPaciente();
    PacienteDAO pacienteDAO= new PacienteDAO();
    Paciente pa= new Paciente();
    Estrato e= new Estrato();
    Sede s= new Sede();
    
    
    public ControladorPacienteAdmin(AdministradorRegistropaciente p) {
        this.registroPacienteVista=p;
        this.registroPacienteVista.botonGuardarpaciente.addActionListener(this);
    }
    public ControladorPacienteAdmin(AdministradorActualizarPaciente p) {
        this.verActualizarPacienteVista=p;
        this.verActualizarPacienteVista.jButton_actualizar.addActionListener(this);
        this.verActualizarPacienteVista.jButton_eliminar.addActionListener(this);
    }
    
    
    public void crearPaciente(){
        if(registroPacienteVista.txt_Nombrepaciente.getText().equals("") || registroPacienteVista.txt_correoelectronico.getText().equals("") ||
                registroPacienteVista.txt_direccionpaciente.getText().equals("") || registroPacienteVista.txt_fechanacimientopaciente.getText().equals("") ||
                registroPacienteVista.txt_identficacionpaciente.getText().equals("") || registroPacienteVista.txt_lugardenacimientopaciente.getText().equals("") ||
                registroPacienteVista.txt_telefonopaciente.getText().equals("") || registroPacienteVista.txt_estratopaciente.getText().equals("") ||
                registroPacienteVista.txt_sedepaciente.getText().equals("") ){
            
             JOptionPane.showMessageDialog(null, "Campos sin completar");
                   
         }else{
            e.setId_estrato(Integer.valueOf(registroPacienteVista.txt_estratopaciente.getText()));
            s.setId_sede(Integer.valueOf(registroPacienteVista.txt_sedepaciente.getText()));
            pa.setNombre(registroPacienteVista.txt_Nombrepaciente.getText());
            pa.setId_paciente(Integer.valueOf(registroPacienteVista.txt_identficacionpaciente.getText()));
            pa.setDireccion(registroPacienteVista.txt_direccionpaciente.getText());
            pa.setLugar_nac(registroPacienteVista.txt_lugardenacimientopaciente.getText());
            pa.setEstrato(e);
            pa.setSede(s);
            pa.setFecha_nac(Date.valueOf(registroPacienteVista.txt_fechanacimientopaciente.getText()));
            
            pacienteDAO.crear(pa);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registroPacienteVista.botonGuardarpaciente){
           crearPaciente();
        }
        if(e.getSource()==verActualizarPacienteVista.jButton_actualizar){
           crearPaciente();
        }
        
    }
    
}
