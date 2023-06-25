/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CreacionData implements IArreglos{
    public ArrayList<String[]> generarArreglo(String nombreArchivo,String separador){
            //Se cree una lista de arreglos de Strings
            //Se crea una lista de Strings que guardará las líneas que devuelve el método LeeFichero
            //Luego se hace split a cada línea y cada arreglo de Strings se agrega a la lista de arreglos de 
            //String y se la retorna
            ArrayList<String> variableGenerado;
            ManejoArchivos manejo= new ManejoArchivos();
            variableGenerado=manejo.LeeFichero(nombreArchivo);
            ArrayList<String[] > arregloFinal= new ArrayList();
            for(int a=1;a<variableGenerado.size();a++){
                String[] linea=variableGenerado.get(a).split(separador); 
                arregloFinal.add(linea);
                
        }
        return arregloFinal;
    }

    @Override
    public String[] buscarEnArreglo(ArrayList<String[]> array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
