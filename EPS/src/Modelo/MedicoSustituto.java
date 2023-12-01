/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Santiago Pineda
 * 
 */
public class MedicoSustituto extends Medico{


    public MedicoSustituto() {
    }
    
    public MedicoSustituto(String licencia_medica, String nombre, String direccion, Date fecha_nac) {
        super(licencia_medica, nombre, direccion, fecha_nac);
        
    }

}
