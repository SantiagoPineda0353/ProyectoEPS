/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.MedicoTitularDAO;
import DAO.PacienteDAO;
import DAO.TelefonoMedicoDAO;
import Modelo.Estrato;
import Modelo.Medico;
import Modelo.MedicoTitular;
import Modelo.Paciente;
import Modelo.Sede;
import Modelo.TelefonoMedico;
import Vista.AdministradorActualizarPaciente;
import Vista.AdministradorRegistroMedico;
import Vista.AdministradorRegistropaciente;
import Vista.AdministradorVerMedicoTitular;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago Pineda
 */
public class ControladorMedicoAdmin implements ActionListener{
//botonGuardarpaciente
    AdministradorVerMedicoTitular medicoTitularVista=new AdministradorVerMedicoTitular();
    AdministradorRegistroMedico crearMedicoTitularVista=new AdministradorRegistroMedico();
    //AdministradorActualizarPaciente verActualizarPacienteVista=new AdministradorActualizarPaciente();
    TelefonoMedicoDAO telmedicoTDAO= new  TelefonoMedicoDAO();
    TelefonoMedico telmedicoT=new TelefonoMedico();
    Medico m=new Medico();
    MedicoTitularDAO medicoTDAO= new MedicoTitularDAO();
    MedicoTitular mt= new MedicoTitular();
    DefaultTableModel modelo=new DefaultTableModel();
 
    public ControladorMedicoAdmin(AdministradorVerMedicoTitular m) {
        this.medicoTitularVista=m;
        mostrarTabla( medicoTitularVista.jTable_paciente);
        this.medicoTitularVista.jButton_eliminar.addActionListener(this);
    }

    public ControladorMedicoAdmin(AdministradorRegistroMedico cmt) {
        this.crearMedicoTitularVista=cmt;
        this.crearMedicoTitularVista.botonGuardarmedico.addActionListener(this);
    }
    
    public void crearMedicoTitular(){
        if(crearMedicoTitularVista.txt_Nombremedico.getText().equals("") || crearMedicoTitularVista.txt_direccionmedico.getText().equals("")
           || crearMedicoTitularVista.txt_fechadeingreso.getText().equals("") || crearMedicoTitularVista.txt_licenciamedica.getText().equals("")
           || crearMedicoTitularVista.txt_medicofechadenacimiento.getText().equals("") || crearMedicoTitularVista.txt_telefonomedico1.getText().equals("") ){
            
             JOptionPane.showMessageDialog(null, "Campos sin completar");
                   
         }else{
            m.setLicencia_medica(crearMedicoTitularVista.txt_licenciamedica.getText());
            telmedicoT.setMedico(m);
            telmedicoT.setTelefono(Integer.valueOf(crearMedicoTitularVista.txt_telefonomedico1.getText()));
            mt.setNombre(crearMedicoTitularVista.txt_Nombremedico.getText());
            mt.setDireccion(crearMedicoTitularVista.txt_direccionmedico.getText());
            mt.setLicencia_medica(crearMedicoTitularVista.txt_licenciamedica.getText());
            mt.setFecha_nac(Date.valueOf(crearMedicoTitularVista.txt_medicofechadenacimiento.getText()));
            mt.setFecha_ingreso(Date.valueOf(crearMedicoTitularVista.txt_fechadeingreso.getText()));
            medicoTDAO.crear(mt);
            telmedicoTDAO.crear(telmedicoT);
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        }
    }
    
    
    public void mostrarTabla(JTable tabla) {
        modelo=(DefaultTableModel)tabla.getModel();
        ArrayList<MedicoTitular>lista=medicoTDAO.MostrarTodo();
        Object[]object= new Object[5];
        for(int i=0;i<lista.size();i++){
            object[0]=lista.get(i).getLicencia_medica();
            object[1]=lista.get(i).getNombre();
            object[2]=lista.get(i).getDireccion();
            object[3]=lista.get(i).getFecha_nac();
            object[4]=lista.get(i).getFecha_ingreso();
            modelo.addRow(object);
        }
        medicoTitularVista.jTable_paciente.setModel(modelo);
    }
    
    public void eliminar(){
        int fila=medicoTitularVista.jTable_paciente.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Primero debe seleccionar el medico que quiere eliminar");
        }else{
          String id=medicoTitularVista.jTable_paciente.getValueAt(fila, 0).toString();
            System.out.println("Licencia= "+ id);
          mt.setLicencia_medica(id);
          int respuesta= JOptionPane.showConfirmDialog(null, "¿Esta seguro de elimiar el medico?", "Eliminar", JOptionPane.YES_NO_OPTION);
              if(respuesta==JOptionPane.YES_OPTION){
                  medicoTDAO.eliminar(mt);
                  JOptionPane.showMessageDialog(null, "Se elimino el medico seleccionado");
                }  
        }
        limpiarTabla();
        mostrarTabla(medicoTitularVista.jTable_paciente);
    }
    
    public void limpiarTabla(){
        for(int i=0;i<medicoTitularVista.jTable_paciente.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==medicoTitularVista.jButton_eliminar){
           eliminar();
        }
        if(e.getSource()==crearMedicoTitularVista.botonGuardarmedico){
           crearMedicoTitular();
        }
        
    }
    
}
