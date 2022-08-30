/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Prueba {
    public static void main(String[] args) {
        ArrayList<Jugador> a=null;
        try(ObjectInputStream ob=new ObjectInputStream(new FileInputStream("jugadoresGrupoB.bin"))){
            a=(ArrayList<Jugador>) ob.readObject();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        for(Jugador jugador:a){
            System.out.println(jugador.getAbrEquipo());
        }
    }
}
