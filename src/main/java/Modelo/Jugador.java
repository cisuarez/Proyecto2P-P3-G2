/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Proyecto2P_P3_G2.Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import Herramientas.ILlenarArrays;
import Herramienta.JugadorInterface

/**
 *
 * @author Michael
 */
public class Jugador implements Serializable, ILlenarArrays, JugadorInterface {
    private String nombre;
    private String imgPath;
    private int dorsal;
    private String directorTecnico;
    private String abrEquipo;
    
    /**
     *
     * @param nombre
     * @param imgPath
     * @param dorsal
     * @param directorTecnico
     * @param abrEquipo
     */
    public Jugador(String nombre, String imgPath, int dorsal,String directorTecnico, String abrEquipo) {
        this.nombre = nombre;
        this.imgPath = imgPath;
        this.dorsal = dorsal;
        this.directorTecnico=directorTecnico;
        this.abrEquipo=abrEquipo;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     *
     * @param imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     *
     * @return
     */
    public int getDorsal() {
        return dorsal;
    }

    /**
     *
     * @param dorsal
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     *
     * @return
     */
    public String getDirectorTecnico() {
        return directorTecnico;
    }

    /**
     *
     * @param directorTecnico
     */
    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    /**
     *
     * @return
     */
    public String getAbrEquipo() {
        return abrEquipo;
    }

    /**
     *
     * @param abrEquipo
     */
    public void setAbrEquipo(String abrEquipo) {
        this.abrEquipo = abrEquipo;
    }
    
    /**
     * Este método lee el archivo que contiene la información de los jugadores
     * y con dicha información crea los objetos de tipo Jugador que son añadidos
     * a una lista que finalmente es retornada.
     * @return
     */
    
    

    /**
     * Se sobreescribe el método toString para que este retorne el nombre del 
     * jugador
     * @return
     */
    @Override
    public String toString() {
        return nombre;
    }

    
    
    
    
}
