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
public class MedicoTitular extends Medico{
    Date fecha_ingreso;

    public MedicoTitular() {
    }
    
    public MedicoTitular(Date fecha_ingreso, String licencia_medica, String nombre, String direccion, Date fecha_nac) {
        super(licencia_medica, nombre, direccion, fecha_nac);
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    
    
}
