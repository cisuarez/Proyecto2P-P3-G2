/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Equipo implements Comparable{
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private int mundialesGanados;
    private String directorTecnico;

    public Equipo(String nombre, ArrayList<Jugador> jugadores, int mundialesGanados, String directorTecnico) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.mundialesGanados = mundialesGanados;
        this.directorTecnico = directorTecnico;
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

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    @Override
    public int compareTo(Object o) {
        
        return 0;
    }
    public ArrayList<Equipo> cargarEquipo(){
        
        return null;
        
    }
    
    
    
    
}
