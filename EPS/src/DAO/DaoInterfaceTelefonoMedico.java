/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Medico;
import Modelo.TelefonoMedico;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface DaoInterfaceTelefonoMedico {
     public void crear(TelefonoMedico TelMed);
    public void eliminar (TelefonoMedico TelMed);
    public ArrayList<TelefonoMedico> MostrarTodo(Medico med);
}
