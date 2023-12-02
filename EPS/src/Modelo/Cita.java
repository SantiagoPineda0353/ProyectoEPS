/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Santiago Pineda
 * 
 */
public class Cita {
    int id_cita;
    String diagnostico;
    LocalDateTime fecha_hora;
    Paciente paciente;
    Modalidad modalidad;
    Sede sede;
    Medico medico;

    public Cita() {
    }

    public Cita(LocalDateTime fecha_hora, Paciente paciente, Modalidad modalidad, Sede sede, Medico medico) {
        this.fecha_hora = fecha_hora;
        this.paciente = paciente;
        this.modalidad = modalidad;
        this.sede = sede;
        this.medico = medico;
    }

    public Cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Cita(int id_cita, LocalDateTime fecha_hora, Paciente paciente, Modalidad modalidad, Sede sede, Medico medico) {
        this.id_cita = id_cita;
        this.fecha_hora = fecha_hora;
        this.paciente = paciente;
        this.modalidad = modalidad;
        this.sede = sede;
        this.medico = medico;
    }

    public Cita(int id_cita, String diagnostico, LocalDateTime fecha_hora, Paciente paciente, Modalidad modalidad, Sede sede, Medico medico) {
        this.id_cita = id_cita;
        this.diagnostico = diagnostico;
        this.fecha_hora = fecha_hora;
        this.paciente = paciente;
        this.modalidad = modalidad;
        this.sede = sede;
        this.medico = medico;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
}
