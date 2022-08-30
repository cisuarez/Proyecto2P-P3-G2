/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import Herramientas.ManejoArchivos;
import Proyecto2P_P3_G2.Principal;

/**
 *
 * @author CJAA
 */
public class Mundial {

    private int año;
    private int golesAnotados;
    private int cantidadEquipos;
    private String cantidadAsistencia;
    private int partidosJugados;
    private ArrayList<Equipo> finalistas;

    public Mundial(int año, int golesAnotados, int cantidadEquipos, String cantidadAsistencia, int partidosJugados, ArrayList<Equipo> finalistas) {
        this.año = año;
        this.golesAnotados = golesAnotados;
        this.cantidadEquipos = cantidadEquipos;
        this.cantidadAsistencia = cantidadAsistencia;
        this.partidosJugados = partidosJugados;
        this.finalistas = finalistas;
    }

    public static ArrayList<Mundial> cargarMundiales(String nombreArchivo) {
        ArrayList<String[]> abreviaturasEquipos=ManejoArchivos.generarArreglo(Principal.pathFiles+"Abreviaturas.csv",",");
        ArrayList<Mundial> arregloMundial = new ArrayList();
        ArrayList<String[]> listaArreglo = ManejoArchivos.generarArreglo(nombreArchivo, ",");
        for (String[] ele : listaArreglo) {
            ArrayList<Equipo> finalistas = new ArrayList<>();
            for (int i = 2; i < 6; i++) {
                Equipo equipo = new Equipo(ele[i].trim());
                for(String[] datos:abreviaturasEquipos){
                    if(equipo.getNombre().equals(datos[0])){
                        equipo.setAbreviatura(datos[1]);
                    }
                }
                for (String[] dato : listaArreglo) {
                    if (dato[2].trim().equals(equipo.getNombre())) {
                        equipo.setMundialesGanados(equipo.getMundialesGanados() + 1);
                    }
                }
                finalistas.add(equipo);
            }
            arregloMundial.add(new Mundial(Integer.valueOf(ele[0].trim()), Integer.valueOf(ele[6].trim()), Integer.valueOf(ele[7].trim()), ele[9].trim(), Integer.valueOf(ele[8].trim()), finalistas));
        }
        return arregloMundial;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    public String getCantidadAsistencia() {
        return cantidadAsistencia;
    }

    public void setCantidadAsistencia(String cantidadAsistencia) {
        this.cantidadAsistencia = cantidadAsistencia;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public ArrayList<Equipo> getFinalistas() {
        return finalistas;
    }

    public void setFinalistas(ArrayList<Equipo> finalistas) {
        this.finalistas = finalistas;
    }

}
