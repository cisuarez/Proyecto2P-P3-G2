/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Herramientas.CreacionData;
import Herramientas.ILlenarArrays;
import Herramientas.ManejoArchivos;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class Partido implements ILlenarArrays{

    private String fecha;
    private String hora;
    private String estadio;
    private String ciudad;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String marcador;
    private String fase;
    private char grupo;

    /**
     *
     * @param fecha
     * @param hora
     * @param estadio
     * @param ciudad
     * @param equipoLocal
     * @param equipoVisitante
     * @param marcador
     * @param fase
     */
    public Partido(String fecha, String hora, String estadio, String ciudad, Equipo equipoLocal, Equipo equipoVisitante, String marcador, String fase) {
        this.fecha = fecha;
        this.hora = hora;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.marcador = marcador;
        this.fase = fase;
    }

    /**
     *
     * @return
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public String getHora() {
        return hora;
    }

    /**
     *
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     *
     * @return
     */
    public String getEstadio() {
        return estadio;
    }

    /**
     *
     * @param estadio
     */
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    /**
     *
     * @return
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     *
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     *
     * @return
     */
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    /**
     *
     * @param equipoLocal
     */
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     *
     * @return
     */
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    /**
     *
     * @param equipoVisitante
     */
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    /**
     *
     * @return
     */
    public String getMarcador() {
        return marcador;
    }

    /**
     *
     * @param marcador
     */
    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    /**
     *
     * @return
     */
    public String getFase() {
        return fase;
    }

    /**
     *
     * @param fase
     */
    public void setFase(String fase) {
        this.fase = fase;
    }

    /**
     *
     * @return
     */
    public char getGrupo() {
        return grupo;
    }

    /**
     *
     * @param grupo
     */
    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }
    
    /**
     * El mètodo recibe el nombre del archivo del cual sacará la información de los partidos 
     * Con la información llena un arrayList de Partidos, separando las lineas del archivo separadas por comas
     * retorna el arrayList de partidos
     * @param nombreArchivo
     * @return 
     */
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Partido{" + "fecha=" + fecha + ", hora=" + hora + ", estadio=" + estadio + ", ciudad=" + ciudad + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", marcador=" + marcador + ", fase=" + fase + ", grupo=" + grupo + '}';
    }

   
}
