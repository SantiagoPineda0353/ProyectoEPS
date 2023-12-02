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
public class Medico {
    String licencia_medica;
    String nombre;
    String direccion;
    Date fecha_nac;

    public Medico() {
    }

    public Medico(String licencia_medica) {
        this.licencia_medica = licencia_medica;
    }

    

    public Medico(String licencia_medica, String nombre, String direccion, Date fecha_nac) {
        this.licencia_medica = licencia_medica;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
    }

   
    

    public String getLicencia_medica() {
        return licencia_medica;
    }

    public void setLicencia_medica(String licencia_medica) {
        this.licencia_medica = licencia_medica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    
    
}
