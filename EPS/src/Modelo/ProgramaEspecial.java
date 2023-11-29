/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Pineda
 */
public class ProgramaEspecial {
    int id_programa;
    String nombre;

    public ProgramaEspecial() {
    }

    public ProgramaEspecial(String nombre) {
        this.nombre = nombre;
    }

    public ProgramaEspecial(int id_programa, String nombre) {
        this.id_programa = id_programa;
        this.nombre = nombre;
    }

    public int getId_programa() {
        return id_programa;
    }

    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
