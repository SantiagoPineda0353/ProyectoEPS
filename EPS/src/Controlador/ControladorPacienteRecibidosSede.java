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
import Vista.AdministradorVerPacientesRecibidosSede;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Santiago Pineda
 */
public class ControladorPacienteRecibidosSede implements ActionListener{
//botonGuardarpaciente
    AdministradorVerPacientesRecibidosSede vista= new AdministradorVerPacientesRecibidosSede();
    ConexionBD conexion = new ConexionBD();
    ResultSet rs=null;
    String fechaI;
    String fechaF;
    DefaultTableModel modelo=new DefaultTableModel();
    
    public ControladorPacienteRecibidosSede(AdministradorVerPacientesRecibidosSede p) {
        this.vista=p;
        this.vista.jButton_actualizar.addActionListener(this);
    }
    
    public void mostrarTabla(JTable tabla) {
        limpiarTabla();
        modelo=(DefaultTableModel)tabla.getModel();
        ArrayList<Cita>lista=MostrarConsulta();
        Object[]object= new Object[7];
        for(int i=0;i<lista.size();i++){
            object[0]=lista.get(i).getId_cita();
            object[1]=lista.get(i).getPaciente().getId_paciente();
            object[2]=lista.get(i).getDiagnostico();
            object[3]=lista.get(i).getFecha_hora();
            object[4]=lista.get(i).getMedico().getLicencia_medica();
            object[5]=lista.get(i).getModalidad().getNombre();
            object[6]=lista.get(i).getSede().getNombre();
            modelo.addRow(object);
        }
        vista.jTable_paciente.setModel(modelo);
    }
    
    public void limpiarTabla(){
        for(int i=0;i<vista.jTable_paciente.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    public ArrayList<Cita> MostrarConsulta() {
            ArrayList<Cita> lista1 = new ArrayList<>();
            mes();
            System.out.println(fechaI);
            System.out.println(Timestamp.valueOf(fechaI));
            String sql = "Select c.id_cita,c.id_paciente, c.diagnostico, c.fecha_hora, c.id_medico, m.nombre, s.nombre from cita c,modalidad m, sede s where m.nombre='"+(String)vista.jComboBoxTipo1.getSelectedItem()+"' AND c.id_sede=s.id_sede AND s.nombre='"+(String)vista.jComboBoxSede.getSelectedItem()+"' AND c.id_modalidad=m.id_modalidad AND c.fecha_hora>='"+fechaI+"' AND c.fecha_hora<'"+fechaF+"';";
            try {

                Connection conectar = conexion.Conexion();
                PreparedStatement insertar = conectar.prepareStatement(sql);
                rs = insertar.executeQuery();

                while (rs.next()) {
                    Paciente pa= new Paciente();
                    Modalidad m= new Modalidad();
                    Sede s= new Sede();
                    Cita c=new Cita();
                    Medico me= new Medico();
                     
                      c.setId_cita(rs.getInt(1));
                      pa.setId_paciente(rs.getInt(2));
                      c.setDiagnostico(rs.getString(3));
                      c.setFecha_hora(rs.getTimestamp(4));
                      me.setLicencia_medica(rs.getString(5));
                      m.setNombre(rs.getString(6));
                      s.setNombre(rs.getString(7));
                      c.setPaciente(pa);
                      c.setMedico(me);
                      c.setModalidad(m);
                      c.setSede(s);
                    lista1.add(c);
                }
            } catch(SQLException ex){
                System.out.println("Error" + ex.getMessage());
            }
            return lista1;
        }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.jButton_actualizar){
            mostrarTabla(vista.jTable_paciente);
        }
        
    }
    
    
    public void mes(){
        String mes=(String)vista.jComboBoxMes.getSelectedItem();
        
        if(mes=="Enero"){
            fechaI="2023-01-01 00:00:00";
            fechaF="2023-02-01 00:00:00";
        }
        if(mes=="Febrero"){
            fechaI="2023-02-01 00:00:00";
            fechaF="2023-03-01 00:00:00";
        }
        if(mes=="Marzo"){
            fechaI="2023-03-01 00:00:00";
            fechaF="2023-04-01 00:00:00";
        }
        if(mes=="Abril"){
            fechaI="2023-04-01 00:00:00";
            fechaF="2023-05-01 00:00:00";
        }
        if(mes=="Mayo"){
            fechaI="2023-05-01 00:00:00";
            fechaF="2023-06-01 00:00:00";
        }
        if(mes=="Junio"){
            fechaI="2023-06-01 00:00:00";
            fechaF="2023-07-01 00:00:00";
        }
        if(mes=="Julio"){
            fechaI="2023-07-01 00:00:00";
            fechaF="2023-08-01 00:00:00";
        }
        if(mes=="Agosto"){
            fechaI="2023-08-01 00:00:00";
            fechaF="2023-09-01 00:00:00";
        }
        if(mes=="Septiembre"){
            fechaI="2023-09-01 00:00:00";
            fechaF="2023-10-01 00:00:00";
        }
        if(mes=="Octubre"){
            fechaI="2023-10-01 00:00:00";
            fechaF="2023-11-01 00:00:00";
        }
        if(mes=="Noviembre"){
            fechaI="2023-11-01 00:00:00";
            fechaF="2023-12-01 00:00:00";
        }
        if(mes=="Diciembre"){
            fechaI="2023-12-01 00:00:00";
            fechaF="2024-01-01 00:00:00";
        }
    }
}
