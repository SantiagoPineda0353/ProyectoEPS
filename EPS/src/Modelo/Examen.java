/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Pineda
 * 
 */
public class Examen {
    int id_examen;
    String nombre;

    public Examen() {
    }

    public Examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public Examen(String nombre) {
        this.nombre = nombre;
    }

    public Examen(int id_examen, String nombre) {
        this.id_examen = id_examen;
        this.nombre = nombre;
    }

    public int getId_examen() {
        return id_examen;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
