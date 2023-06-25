/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Herramientas;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Mundial;
import Modelo.Partido;
import Proyecto2P_P3_G2.Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public interface ILlenarArrays {
    public static ArrayList<Equipo> cargarEquipos(String nombreArchivo){
        ArrayList<Equipo> arregloEquipo=new ArrayList();
        CreacionData creacion=new CreacionData();
        ArrayList<String[]> listaArreglo=creacion.generarArreglo(nombreArchivo, "\\|");
        for(String[] ele:listaArreglo){
            Equipo equipo=new Equipo(ele[5].trim(),ele[19].trim());         
            arregloEquipo.add(equipo);
        }
        return arregloEquipo;
    }
    public static ArrayList<Jugador> cargarJugadores(){
        ArrayList<Jugador> jugadores=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(Principal.pathFiles+"WorldCupPlayersBrasil2014.csv"))){
            bf.readLine();
            for(int i=0;i<2009;i++){
                String[] datos=bf.readLine().split(",");
                if(!jugadores.isEmpty()){
                    Jugador j2=null;
                    for(Jugador j:jugadores){
                        if(datos[6].trim().equals(j.getNombre())==true&&datos[2].trim().equals(j.getAbrEquipo())){
                            j2=j;
                        }
                    }
                    if(j2==null){
                        jugadores.add(new Jugador(datos[6].trim(),datos[6].trim()+".png",Integer.valueOf(datos[5].trim()),datos[3].split("\\(")[0].trim(),datos[2].trim()));
                    }
                }else{
                    jugadores.add(new Jugador(datos[6].trim(),datos[6].trim()+".jpg",Integer.valueOf(datos[5].trim()),datos[3].split("\\(")[0].trim(),datos[2].trim()));
                }
            }
        }catch(FileNotFoundException f){
            
        }catch(IOException io){
            
        }
        return jugadores;
    }
    public static ArrayList<Mundial> cargarMundiales() {
        CreacionData creacion=new CreacionData();
        ArrayList<String[]> abreviaturasEquipos=creacion.generarArreglo(Principal.pathFiles+"Abreviaturas.csv",",");
        ArrayList<Mundial> arregloMundial = new ArrayList();
        ArrayList<String[]> listaArreglo = creacion.generarArreglo(Principal.pathFiles+"WorldCups.csv", ",");
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
    public static ArrayList<Partido> cargarPartidos(String nombreArchivo){
        CreacionData creacion=new CreacionData();
        ArrayList<Partido> arregloPartido=new ArrayList();
        ArrayList<String[]> listaArreglo=creacion.generarArreglo(nombreArchivo, "\\|");
        for(String[] ele:listaArreglo){
            //(String fecha, String hora, String estadio, String ciudad, String equipoLocal, String equipoVisitante, String marcador, String fase)
            Partido partidito= new Partido(ele[1].split("-")[0].trim(),ele[1].split("-")[1].trim(),ele[3].trim(),ele[4].trim(), new Equipo(ele[5].trim(),ele[18].trim()),new Equipo(ele[8].trim(),ele[19].trim()),ele[6].trim()+"-"+ele[7].trim(),ele[2].trim());
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
    void buscarELemento(Object objeto);
}
