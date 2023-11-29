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
    boolean asistencia;

    public ProgramaEspecialAdulto() {
    }

    public ProgramaEspecialAdulto(Paciente paciente, ProgramaEspecial programa, boolean asistencia) {
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

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
    
    
}
