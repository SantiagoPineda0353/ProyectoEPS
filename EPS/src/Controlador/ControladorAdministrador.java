/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.AdministradorFormularioMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Santiago Pineda
 */
public class ControladorAdministrador implements ActionListener {
    AdministradorFormularioMenu vistaAdmin = new AdministradorFormularioMenu();
    public ControladorAdministrador(AdministradorFormularioMenu a) {
        this.vistaAdmin=a;
        this.vistaAdmin.menu_Administrador_paciente.addActionListener(this);//
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==vistaAdmin.getMenu_Administrador_paciente()){
           
       }
    }
    
}
