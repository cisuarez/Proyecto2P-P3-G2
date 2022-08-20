/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Herramientas.ManejoArchivos;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Jugador {
    private String nombre;
    private String imgPath;
    private int dorsal;
    private String directorTecnico;

    public Jugador(String nombre, String imgPath, int dorsal,String directorTecnico) {
        this.nombre = nombre;
        this.imgPath = imgPath;
        this.dorsal = dorsal;
        this.directorTecnico=directorTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }
    
    public static ArrayList<Jugador> cargarJugadores(String nombreArchivo){
        ArrayList<Jugador> arregloJugador=new ArrayList();
        ArrayList<String[]> listaArreglo=ManejoArchivos.generarArreglo(nombreArchivo, ",");
        for(String[] ele:listaArreglo){
           arregloJugador.add(new Jugador(ele[6].trim(),ele[6]+"png",Integer.parseInt(ele[5].trim()),ele[3]));
        }
        return arregloJugador;
    }
    
}
