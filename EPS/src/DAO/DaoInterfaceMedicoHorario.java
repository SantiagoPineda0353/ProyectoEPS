/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.MedicoHorario;
import java.util.ArrayList;

/**
 *
 * @author 57302
 */
public interface DaoInterfaceMedicoHorario {
    public void crear(MedicoHorario medicoh);
    public void eliminar(MedicoHorario medicoh);
    public void buscar(MedicoHorario medicoh);
    public ArrayList<MedicoHorario> MostrarTodo();
}
