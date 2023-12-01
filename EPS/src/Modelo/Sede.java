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
public class Sede {
    int id_sede;
    String nombre;

    public Sede() {
    }

    public Sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public Sede(String nombre) {
        this.nombre = nombre;
    }
    
    public Sede(int id_sede, String nombre) {
        this.id_sede = id_sede;
        this.nombre = nombre;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
