/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Cita;

import java.util.ArrayList;
/**
 *
 * @author 57302
 */
public interface DaoInterfaceCita {
    public void crear(Cita cita);
    public void eliminar (Cita cita);
    public void buscar (Cita cita);
    public ArrayList<Cita> MostrarTodo();
}
