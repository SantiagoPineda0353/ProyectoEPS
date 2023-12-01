/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Examen;
import java.util.ArrayList;

/**
 *
 * @author 57302
 */
public interface DaoInterfaceExamen {
    public void crear(Examen examen);
    public void eliminar (Examen examen);
    public void buscar (Examen examen);
    public ArrayList<Examen> MostrarTodo();
}
