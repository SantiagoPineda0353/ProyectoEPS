/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Pineda
 */
public class TelefonoPaciente {
    int telefono;
    Paciente paciente;

    public TelefonoPaciente() {
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TelefonoPaciente(int telefono, Paciente paciente) {
        this.telefono = telefono;
        this.paciente = paciente;
    }

    public Paciente getMedico() {
        return paciente;
    }

    public void setMedico(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
