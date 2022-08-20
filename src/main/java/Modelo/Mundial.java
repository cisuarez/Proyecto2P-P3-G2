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
    Equipo equipoGanador;
    Equipo equipoSegundo;
    Equipo equipoTercero;
    Equipo equipoCuarto;

    public Mundial(int año, int golesAnotados, int cantidadEquipos, String cantidadAsistencia, int partidosJugados, Equipo equipoGanador, Equipo equipoSegundo, Equipo equipoTercero, Equipo equipoCuarto) {
        this.año = año;
        this.golesAnotados = golesAnotados;
        this.cantidadEquipos = cantidadEquipos;
        this.cantidadAsistencia = cantidadAsistencia;
        this.partidosJugados = partidosJugados;
        this.equipoGanador = equipoGanador;
        this.equipoSegundo = equipoSegundo;
        this.equipoTercero = equipoTercero;
        this.equipoCuarto = equipoCuarto;
    }
    
    public static ArrayList<Mundial> cargarMundiales(String nombreArchivo){
        ArrayList<Mundial> arregloMundial=new ArrayList();
        ArrayList<String[]> listaArreglo=ManejoArchivos.generarArreglo(nombreArchivo, ",");
        for(String[] ele:listaArreglo){
            //Year,Country,Winner,Runners-Up,Third,Fourth,GoalsScored,QualifiedTeams,MatchesPlayed,Attendance
            Equipo ganador=new Equipo(ele[2].trim());
            for(String[]dato:listaArreglo){
                if(dato[2].trim().equals(ganador.getNombre())){
                    ganador.setMundialesGanados(ganador.getMundialesGanados()+1);
                }
            }
            Equipo segundo=new Equipo(ele[3].trim());
            Equipo tercero=new Equipo(ele[4].trim());
            Equipo cuarto=new Equipo(ele[5].trim());
            arregloMundial.add(new Mundial(Integer.valueOf(ele[0].trim()),Integer.valueOf(ele[6].trim()),Integer.valueOf(ele[7].trim()),ele[9].trim(),Integer.valueOf(ele[8].trim()),ganador,segundo,tercero,cuarto));
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

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public Equipo getEquipoSegundo() {
        return equipoSegundo;
    }

    public void setEquipoSegundo(Equipo equipoSegundo) {
        this.equipoSegundo = equipoSegundo;
    }

    public Equipo getEquipoTercero() {
        return equipoTercero;
    }

    public void setEquipoTercero(Equipo equipoTercero) {
        this.equipoTercero = equipoTercero;
    }

    public Equipo getEquipoCuarto() {
        return equipoCuarto;
    }

    public void setEquipoCuarto(Equipo equipoCuarto) {
        this.equipoCuarto = equipoCuarto;
    }
    
}
