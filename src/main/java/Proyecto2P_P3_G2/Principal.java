/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Equipo;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author CJAA
 */
public class Principal extends Application{
    
    private static Scene scene;
    public static String pathFiles="Archivos_CSV/";
    public static String pathImg="Jugadores/";
    public static String pathImgBanderas="Images/Banderas/";
    public static String pathImgGeneral="Images/";
    /**
     * Método que carga la escena y la muestra
     * @param stage
     * @throws IOException 
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VentanaMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

  
    /**
     * Método que carga el fxml y tira una excepción de tipo IOException
     * @param fxml
     * @return
     * @throws IOException 
     */
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * Método estático que carga la ventana que recibe como parámetro
     * @param ventana
     * @param height
     * @param width 
     */
    public static void cargarVentana(String ventana,int height,int width){
        Scene scene=null;
        try {
            scene = new Scene(Principal.loadFXML(ventana), height, width);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        
    }
    /**
     * Método main que inicia el programa
     * @param args 
     */
    public static void main(String[] args) {
        launch();
        
    }
    
}
