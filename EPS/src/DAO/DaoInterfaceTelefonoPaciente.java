/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Paciente;
import Modelo.TelefonoPaciente;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface DaoInterfaceTelefonoPaciente {
    
     public void crear(TelefonoPaciente TelPac);
    public void eliminar (TelefonoPaciente TelPac);
    public ArrayList<TelefonoPaciente> MostrarTodo(Paciente pac);
}
