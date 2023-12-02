/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Pineda
 */
public class ProgramaEspecialAdulto {
    Paciente paciente;
    ProgramaEspecial programa;
    String asistencia;

    public ProgramaEspecialAdulto() {
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

 

    public ProgramaEspecialAdulto(Paciente paciente, ProgramaEspecial programa, String asistencia) {
        this.paciente = paciente;
        this.programa = programa;
        this.asistencia = asistencia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProgramaEspecial getPrograma() {
        return programa;
    }

    public void setPrograma(ProgramaEspecial programa) {
        this.programa = programa;
    }

    
    
    
}
