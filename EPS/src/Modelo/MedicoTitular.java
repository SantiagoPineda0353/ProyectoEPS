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

    @Override
    public String getLicencia_medica() {
        return licencia_medica;
    }

    @Override
    public void setLicencia_medica(String licencia_medica) {
        this.licencia_medica = licencia_medica;
    }

    /**
     *
     * @return
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public Date getFecha_nac() {
        return fecha_nac;
    }

    @Override
    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
    
    
    
    
}
