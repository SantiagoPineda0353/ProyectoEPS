/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Santiago Pineda
 */
public class Periodo {
    Date fecha_ingreso;
    Date fecha_salida;
    MedicoSustituto medicoSustituto;

    public Periodo() {
    }

    public Periodo(Date fecha_ingreso, Date fecha_salida, MedicoSustituto medicoSustituto) {
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.medicoSustituto = medicoSustituto;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public MedicoSustituto getMedicoSustituto() {
        return medicoSustituto;
    }

    public void setMedicoSustituto(MedicoSustituto medicoSustituto) {
        this.medicoSustituto = medicoSustituto;
    }
    
    
}
