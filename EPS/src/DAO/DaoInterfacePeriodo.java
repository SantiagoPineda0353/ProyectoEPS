/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.MedicoSustituto;
import Modelo.Periodo;
import java.util.ArrayList;

/**
 *
 * @author Santiago Pineda
 */
public interface DaoInterfacePeriodo {
    public void crear(Periodo periodo);
    public void eliminar (Periodo periodo);
    public ArrayList<Periodo> MostrarTodo(MedicoSustituto medicoSustituto);
}
