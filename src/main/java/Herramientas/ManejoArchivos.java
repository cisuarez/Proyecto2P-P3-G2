package Herramientas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.image.Image;

/**
 *
 * @author Verónica
 */
/**
 * Esta clase contiene funciones que se utilizan para obtener recursos del archivo
 * @author CJAA
 */
public class ManejoArchivos {
    
    /**
     * Este método lee los elementos que pertenecen a un archivo
     * @param nombrearchivo del cual se extraen los datos para devolver el Arraylist de Strings
     * @return ArrayList que contiene los lineas del archivo
     */

    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null/**
     * Este método lee los elementos que pertenecen a un archivo
     * @param nombrearchivo del cual se extraen los datos para devolver el Arraylist de Strings
     * @return ArrayList que contiene los lineas del archivo
     */;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
//                System.out.println(linea);
                lineas.add(linea);
                //System.out.println(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }
/**
     * Este método EscribirArchivo escribe dentro de un archivo la linea de String ingresada en los parametros
     * @param nombreArchivo
     * @param linea es un String el cual será agregaddo al archivo
     * Al finalizar el método se habrá escrito el String ingresado en los parametros en el archivo ingresado en los parametros
     */
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write("\r\n");
            bw.write(linea);
            //System.out.println("ksdsdlsd");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
    }

   public static ArrayList<String[]> generarArreglo(String nombreArchivo,String separador){
            //Se cree una lista de arreglos de Strings
            //Se crea una lista de Strings que guardará las líneas que devuelve el método LeeFichero
            //Luego se hace split a cada línea y cada arreglo de Strings se agrega a la lista de arreglos de 
            //String y se la retorna
            ArrayList<String> variableGenerado;
            variableGenerado=LeeFichero(nombreArchivo);
            ArrayList<String[] > arregloFinal= new ArrayList();
            for(int a=1;a<variableGenerado.size();a++){
                String[] linea=variableGenerado.get(a).split(separador); 
                System.out.println(Arrays.toString(linea));
                arregloFinal.add(linea);
                
        }
        return arregloFinal;
    }
   public static Image abrirImagen(String nombreImagen){
       Image img=null;
       try(FileInputStream f=new FileInputStream(nombreImagen)){
           img=new Image(f);
       }catch(FileNotFoundException f){
           System.out.println("No se encontró el archivo solicitado");
       }catch(IOException i){
           System.out.println("Hubo un error, inténtalo más tarde");
       }
       return img;
   }
}
