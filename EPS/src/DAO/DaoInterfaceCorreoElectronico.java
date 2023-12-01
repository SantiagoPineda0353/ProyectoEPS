/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.CorreoElectronico;
import Modelo.Paciente;
import java.util.ArrayList;

/**
 *
 * @author Santiago Pineda
 */
public interface DaoInterfaceCorreoElectronico {
    public void crear(CorreoElectronico correoElectronico);
    public void eliminar (CorreoElectronico correoElectronico);
    public ArrayList<CorreoElectronico> MostrarTodo(Paciente paciente);
}
