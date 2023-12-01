/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Paciente;
import java.util.ArrayList;

/**
 *
 * @author 57302
 */
public interface DaoInterfacePaciente {
    public void crear(Paciente paciente);
    public void eliminar(Paciente paciente);
    public void buscar(Paciente paciente);
    public ArrayList<Paciente> MostrarTodo();
}
