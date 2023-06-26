/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Herramientas.CreacionData;
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

    ArchivoManager archivoManager = new ManejoArchivos();
    ArrayList<Mundial> mundiales = Mundial.cargarMundiales(ArchivoManager archivoManager); // Cargar los datos de los mundiales


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
