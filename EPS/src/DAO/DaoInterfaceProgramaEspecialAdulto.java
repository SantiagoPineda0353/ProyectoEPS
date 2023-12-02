/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import Modelo.Paciente;
import Modelo.ProgramaEspecialAdulto;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface DaoInterfaceProgramaEspecialAdulto {
     public void crear(ProgramaEspecialAdulto ProEspAdu);
    public void eliminar (ProgramaEspecialAdulto ProEspAdu);
    public ArrayList<ProgramaEspecialAdulto> MostrarTodo(Paciente pac);
}
