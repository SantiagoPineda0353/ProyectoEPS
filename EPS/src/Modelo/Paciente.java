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
public class Paciente {
    int id_paciente;
    String nombre;
    String direccion;
    Date fecha_nac;
    String lugar_nac;
    Estrato estrato;
    Sede sede;

    public Paciente() {
    }

    public Paciente(int id_paciente, String nombre, String direccion, Date fecha_nac, String lugar_nac, Estrato estrato, Sede sede) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
        this.lugar_nac = lugar_nac;
        this.estrato = estrato;
        this.sede = sede;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
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

    public String getLugar_nac() {
        return lugar_nac;
    }

    public void setLugar_nac(String lugar_nac) {
        this.lugar_nac = lugar_nac;
    }

    public Estrato getEstrato() {
        return estrato;
    }

    public void setEstrato(Estrato estrato) {
        this.estrato = estrato;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }
    
    
}
