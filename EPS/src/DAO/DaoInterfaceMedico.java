/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Medico;
import java.util.ArrayList;

/**
 *
 * @author 57302
 */
public interface DaoInterfaceMedico {
    public void crear(Medico medico);
    public void eliminar(Medico medico);
    public void buscar(Medico medico);
    public ArrayList<Medico> MostrarTodo();
}
