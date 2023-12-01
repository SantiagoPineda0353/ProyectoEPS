/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Santiago Pineda
 */
public class Modalidad {
    int id_modalidad;
    String nombre;

    public Modalidad() {
    }

    public Modalidad(String nombre) {
        this.nombre = nombre;
    }

    public Modalidad(int id_modalidad, String nombre) {
        this.id_modalidad = id_modalidad;
        this.nombre = nombre;
    }

    public int getId_modalidad() {
        return id_modalidad;
    }

    public void setId_modalidad(int id_modalidad) {
        this.id_modalidad = id_modalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
