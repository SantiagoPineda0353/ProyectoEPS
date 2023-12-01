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
public class Dia {
    int id_dias;
    String nombre;

    public Dia() {
    }

    public Dia(int id_dias, String nombre) {
        this.id_dias = id_dias;
        this.nombre = nombre;
    }

    public int getId_dias() {
        return id_dias;
    }

    public void setId_dias(int id_dias) {
        this.id_dias = id_dias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
