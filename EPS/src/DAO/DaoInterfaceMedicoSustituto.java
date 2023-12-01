/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;
;
import Modelo.MedicoSustituto;
import java.util.ArrayList;

/**
 *
 * @author 57302
 */
public interface DaoInterfaceMedicoSustituto {
    public void crear(MedicoSustituto medicoSustituto);
    public void eliminar(MedicoSustituto medicoSustituto);
    public void buscar(MedicoSustituto medicoSustituto);
    public ArrayList<MedicoSustituto> MostrarTodo();
}
