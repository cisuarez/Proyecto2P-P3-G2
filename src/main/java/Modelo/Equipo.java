/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Herramientas.CreacionData;
import Herramientas.ManejoArchivos;
import Proyecto2P_P3_G2.Principal;
import java.util.ArrayList;
import java.util.Objects;
import Herramientas.ILlenarArrays;

/**
 *
 * @author Michael
 */
public class Equipo implements Comparable<Equipo>, ILlenarArrays {

    private String nombre;
    private ArrayList<Jugador> jugadores;
    private int mundialesGanados;
    private String abreviatura;

    
    private static ArrayList<Jugador> jugadoresCargados=ILlenarArrays.cargarJugadores();
    
    /**
     *
     * @param nombre
     * @param abreviatura
     */
    public Equipo(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        llenarJugadores(abreviatura);
    }

    /**
     *
     * @param nombre
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
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
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     *
     * @param jugadores
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     *
     * @return
     */
    public int getMundialesGanados() {
        return mundialesGanados;
    }

    /**
     *
     * @param mundialesGanados
     */
    public void setMundialesGanados(int mundialesGanados) {
        this.mundialesGanados = mundialesGanados;
    }

    /**
     *
     * @return
     */
    public String getAbreviatura() {
        return abreviatura;
    }

    /**
     *
     * @param abreviatura
     */
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == Equipo.class) {
            Equipo e = (Equipo) o;
            return this.getNombre().equals(e.getNombre());
        } else {
            return false;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public int compareTo(Equipo e) {
        return this.nombre.compareTo(e.nombre);
    }

    private void llenarJugadores(String teamIniciales) {
        ArrayList<Jugador> jugadoresE=new ArrayList<>();
        for(Jugador j:jugadoresCargados){
            if(teamIniciales.equals(j.getAbrEquipo())==true){
                jugadoresE.add(j);
            }
        }
        this.jugadores=jugadoresE;
    }

    @Override
    public void buscarELemento(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    


}
