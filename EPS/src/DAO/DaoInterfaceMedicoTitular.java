/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Medico;
import Modelo.MedicoTitular;
import java.util.ArrayList;

/**
 *
 * @author 57302
 */
public interface DaoInterfaceMedicoTitular {
    public void crear(MedicoTitular medicoTitular);
    public void eliminar(MedicoTitular medicoTitular);
    public void buscar(MedicoTitular medicoTitular);
    public ArrayList<MedicoTitular> MostrarTodo();
}
