/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CitaDAO;
import Modelo.Cita;
import Modelo.Medico;
import Modelo.Modalidad;
import Modelo.Paciente;
import Modelo.Sede;
import Vista.AdministradorRegistroCita;
import Vista.ConsultarCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControladorCitaAdmin implements ActionListener{

     AdministradorRegistroCita registrocitaVista = new AdministradorRegistroCita();
       // ConsultarCita consultarcitaVista = new ConsultarCita();
        CitaDAO citadao= new  CitaDAO(); 
        Cita c = new Cita();
        Paciente pa =new Paciente();
        Modalidad m = new Modalidad();
        Sede se =new Sede();
        Medico med = new Medico();
    
    public ControladorCitaAdmin(AdministradorRegistroCita p) {
        this.registrocitaVista = p;
        this.registrocitaVista.botonActualizarpaciente.addActionListener(this);
        this.registrocitaVista.botonGuardarpaciente1.addActionListener(this);

    }
 
    public void CrearCita() {

        if (registrocitaVista.txt_idcita.getText().equals("") || registrocitaVista.txt_diagnosticocita.getText().equals("")
                || registrocitaVista.txt_citafechayhoracita.getText().equals("") || registrocitaVista.txt_citaMedico.getText().equals("")){

            JOptionPane.showMessageDialog(null, "Campos sin completar");

        } else {
            pa.setId_paciente(Integer.valueOf(registrocitaVista.txt_idcita.getText()));
            c.setDiagnostico(registrocitaVista.txt_diagnosticocita.getText());
            c.setFecha_hora(LocalDateTime.parse(registrocitaVista.txt_citafechayhoracita.getText()));
            m.setId_modalidad(Integer.parseInt((String) registrocitaVista.ComboBoxcitaModalidad.getSelectedItem()));
            med.setLicencia_medica(registrocitaVista.txt_citaMedico.getText());
            se.setId_sede(Integer.parseInt((String) registrocitaVista.ComboBoxcitaSede.getSelectedItem()));
            c.setModalidad(m);
            c.setMedico(med);
            c.setSede(se);
            citadao.crear(c);
 
             
        }

    }
    
    public void ActualizarCita(){
    
      pa.setId_paciente(Integer.valueOf(registrocitaVista.txt_idcita.getText()));    
      med.setLicencia_medica( registrocitaVista.txt_citaMedico.getText());
      c.setPaciente(pa);
      c.setDiagnostico(registrocitaVista.txt_diagnosticocita.getText());
      c.setMedico(med);
      citadao.actualizar(c);
      
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==registrocitaVista.botonGuardarpaciente1){
           CrearCita();
        }
       
       if(e.getSource()==registrocitaVista.botonActualizarpaciente){
           ActualizarCita();
        }
       
    }
    
}
