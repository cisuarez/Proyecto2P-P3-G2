/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Prueba {
    public static void main(String[] args) {
        ArrayList<Partido> xd=Partido.cargarPartidos("src/main/resources/Archivos_CSV/WorldCupMatchesBrasil2014.csv");
        for(Partido p: xd){
            System.out.println(p);
        }
    }
}
