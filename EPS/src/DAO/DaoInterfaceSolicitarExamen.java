/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Cita;
import Modelo.SolicitarExamen;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface DaoInterfaceSolicitarExamen {
     public void crear(SolicitarExamen SoliExam);
    public void eliminar (SolicitarExamen SoliExam);
   
    public ArrayList<SolicitarExamen> MostrarTodo(Cita cita);
}
