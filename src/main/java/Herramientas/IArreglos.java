/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Herramientas;


import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Mundial;
import Modelo.Partido;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public interface IArreglos {
    ArrayList<String[]> generarArreglo(String nombreArchivo,String separador);
    String[] buscarEnArreglo(ArrayList<String[]> array);
    
}
