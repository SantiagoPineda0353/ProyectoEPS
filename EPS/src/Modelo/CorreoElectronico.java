/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Pineda
 */
public class CorreoElectronico {
    String correo_electronico;
    Paciente paciente;

    public CorreoElectronico() {
    }

    public CorreoElectronico(String correo_electronico, Paciente paciente) {
        this.correo_electronico = correo_electronico;
        this.paciente = paciente;
    }

    public Paciente getMedico() {
        return paciente;
    }

    public void setMedico(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTelefono() {
        return correo_electronico;
    }

    public void setTelefono(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
}
