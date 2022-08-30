/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Herramientas.ManejoArchivos;
import Proyecto2P_P3_G2.Principal;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Michael
 */
public class Jugador implements Serializable {
    private String nombre;
    private String imgPath;
    private int dorsal;
    private String directorTecnico;
    
    private String abrEquipo;
    

    public Jugador(String nombre, String imgPath, int dorsal,String directorTecnico, String abrEquipo) {
        this.nombre = nombre;
        this.imgPath = imgPath;
        this.dorsal = dorsal;
        this.directorTecnico=directorTecnico;
        this.abrEquipo=abrEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public String getAbrEquipo() {
        return abrEquipo;
    }

    public void setAbrEquipo(String abrEquipo) {
        this.abrEquipo = abrEquipo;
    }
    
    public static ArrayList<Jugador> cargarJugadores(){
        ArrayList<Jugador> jugadores=new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(Principal.pathFiles+"WorldCupPlayersBrasil2014.csv"))){
            bf.readLine();
            for(int i=0;i<2009;i++){
                String[] datos=bf.readLine().split(",");
                System.out.println(Arrays.toString(datos));
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

    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
