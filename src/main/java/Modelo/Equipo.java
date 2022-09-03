/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Herramientas.ManejoArchivos;
import Proyecto2P_P3_G2.Principal;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Michael
 */
public class Equipo implements Comparable<Equipo> {

    private String nombre;
    private ArrayList<Jugador> jugadores;
    private int mundialesGanados;
    private String abreviatura;
    public static ArrayList<Jugador> jugadoresCargados=Jugador.cargarJugadores();
    
    public Equipo(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        cargarJugadores(abreviatura);
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getMundialesGanados() {
        return mundialesGanados;
    }

    public void setMundialesGanados(int mundialesGanados) {
        this.mundialesGanados = mundialesGanados;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o.getClass() == Equipo.class) {
            Equipo e = (Equipo) o;
            return this.getNombre().equals(e.getNombre());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public int compareTo(Equipo e) {
        return this.nombre.compareTo(e.nombre);
    }

    private void cargarJugadores(String teamIniciales) {
        ArrayList<Jugador> jugadoresE=new ArrayList<>();
        for(Jugador j:jugadoresCargados){
            if(teamIniciales.equals(j.getAbrEquipo())==true){
                jugadoresE.add(j);
            }
        }
        this.jugadores=jugadoresE;
    }
    public static ArrayList<Equipo> cargarEquipos(String nombreArchivo){
        ArrayList<Equipo> arregloEquipo=new ArrayList();
        ArrayList<String[]> listaArreglo=ManejoArchivos.generarArreglo(nombreArchivo, "\\|");
        for(String[] ele:listaArreglo){
            Equipo equipo=new Equipo(ele[5].trim(),ele[19].trim());         
            arregloEquipo.add(equipo);
        }
        return arregloEquipo;
    }

}
