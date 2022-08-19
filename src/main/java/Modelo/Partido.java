/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Herramientas.ManejoArchivos;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Partido {

    private String fecha;
    private String hora;
    private String estadio;
    private String ciudad;
    private String equipoLocal;
    private String equipoVisitante;
    private String marcador;
    private String fase;
    private char grupo;

    public Partido(String fecha, String hora, String estadio, String ciudad, String equipoLocal, String equipoVisitante, String marcador, String fase) {
        this.fecha = fecha;
        this.hora = hora;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.marcador = marcador;
        this.fase = fase;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }
    
    public static ArrayList<Partido> cargarPartidos(String nombreArchivo){
        ArrayList<Partido> arregloPartido=new ArrayList();
        ArrayList<String[]> listaArreglo=ManejoArchivos.generarArreglo(nombreArchivo, "\\|");
        for(String[] ele:listaArreglo){
            //(String fecha, String hora, String estadio, String ciudad, String equipoLocal, String equipoVisitante, String marcador, String fase)
            Partido partidito= new Partido(ele[1].split("-")[0].trim(),ele[1].split("-")[1].trim(),ele[3].trim(),ele[4].trim(), ele[5].trim(),ele[8].trim(),ele[6].trim()+"-"+ele[7].trim(),ele[2].trim());
            if(ele[2].split(" ")[0].equals("Group")){
               partidito.setGrupo(ele[2].split(" ")[1].charAt(0));
               
            }
//            System.out.println(partidito.getEquipoLocal());
//            System.out.println(partidito.getEquipoVisitante());
//            System.out.println(partidito.getGrupo());
            arregloPartido.add(partidito);
        }
        return arregloPartido;
    }
    
 
    
    
    @Override
    public String toString() {
        return "Partido{" + "fecha=" + fecha + ", hora=" + hora + ", estadio=" + estadio + ", ciudad=" + ciudad + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", marcador=" + marcador + ", fase=" + fase + ", grupo=" + grupo + '}';
    }
}
