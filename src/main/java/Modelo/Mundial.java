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

    /**
     *
     * @param año
     * @param golesAnotados
     * @param cantidadEquipos
     * @param cantidadAsistencia
     * @param partidosJugados
     * @param finalistas
     */
    public Mundial(int año, int golesAnotados, int cantidadEquipos, String cantidadAsistencia, int partidosJugados, ArrayList<Equipo> finalistas) {
        this.año = año;
        this.golesAnotados = golesAnotados;
        this.cantidadEquipos = cantidadEquipos;
        this.cantidadAsistencia = cantidadAsistencia;
        this.partidosJugados = partidosJugados;
        this.finalistas = finalistas;
    }

    /**
     * Este método recibe carga toma datos de los mundiales del archivo correspondiente y de los equipos y 
     * sus abreviaturas, con esos datos creas los equipos que quedaron en las primeras posiciones de cada mundial 
     * y los instancia junto con el resto de atributos que posee el objeto de tipo Mundial. Finalmente retorna una lista
     * de mundiales.
     * @return
     */
    public static ArrayList<Mundial> cargarMundiales() {
        ArrayList<String[]> abreviaturasEquipos=ManejoArchivos.generarArreglo(Principal.pathFiles+"Abreviaturas.csv",",");
        ArrayList<Mundial> arregloMundial = new ArrayList();
        ArrayList<String[]> listaArreglo = ManejoArchivos.generarArreglo(Principal.pathFiles+"WorldCups.csv", ",");
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

    /**
     *
     * @return
     */
    public int getAño() {
        return año;
    }

    /**
     *
     * @param año
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     *
     * @return
     */
    public int getGolesAnotados() {
        return golesAnotados;
    }

    /**
     *
     * @param golesAnotados
     */
    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    /**
     *
     * @return
     */
    public int getCantidadEquipos() {
        return cantidadEquipos;
    }

    /**
     *
     * @param cantidadEquipos
     */
    public void setCantidadEquipos(int cantidadEquipos) {
        this.cantidadEquipos = cantidadEquipos;
    }

    /**
     *
     * @return
     */
    public String getCantidadAsistencia() {
        return cantidadAsistencia;
    }

    /**
     *
     * @param cantidadAsistencia
     */
    public void setCantidadAsistencia(String cantidadAsistencia) {
        this.cantidadAsistencia = cantidadAsistencia;
    }

    /**
     *
     * @return
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     *
     * @param partidosJugados
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     *
     * @return
     */
    public ArrayList<Equipo> getFinalistas() {
        return finalistas;
    }

    /**
     *
     * @param finalistas
     */
    public void setFinalistas(ArrayList<Equipo> finalistas) {
        this.finalistas = finalistas;
    }

}
