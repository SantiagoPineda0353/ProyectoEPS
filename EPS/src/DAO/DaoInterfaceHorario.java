/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Horario;
import java.util.ArrayList;

/**
 *
 * @author 57302
 */
public interface DaoInterfaceHorario {
    public void crear(Horario horario);
    public void eliminar (Horario horario);
    public void buscar (Horario horario);
    public ArrayList<Horario> MostrarTodo();
}
