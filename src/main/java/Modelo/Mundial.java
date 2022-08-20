/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import Herramientas.ManejoArchivos;
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

   
    
    public static ArrayList<Mundial> cargarMundiales(String nombreArchivo){
        ArrayList<Mundial> arregloMundial=new ArrayList();
        ArrayList<String[]> listaArreglo=ManejoArchivos.generarArreglo(nombreArchivo, ",");
        for(String[] ele:listaArreglo){
            //Year,Country,Winner,Runners-Up,Third,Fourth,GoalsScored,QualifiedTeams,MatchesPlayed,Attendance
            ArrayList<Equipo> finalistas=new ArrayList<>();
            Equipo ganador=new Equipo(ele[2].trim());
            for(String[]dato:listaArreglo){
                if(dato[2].trim().equals(ganador.getNombre())){
                    ganador.setMundialesGanados(ganador.getMundialesGanados()+1);
                }
            }
            finalistas.add(ganador);
            finalistas.add(new Equipo(ele[3].trim()));
            finalistas.add(new Equipo(ele[4].trim()));
            finalistas.add(new Equipo(ele[5].trim()));
            arregloMundial.add(new Mundial(Integer.valueOf(ele[0].trim()),Integer.valueOf(ele[6].trim()),Integer.valueOf(ele[7].trim()),ele[9].trim(),Integer.valueOf(ele[8].trim()),finalistas));
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
