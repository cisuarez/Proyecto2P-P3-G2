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
    public static String pathFiles="src/main/resources/Archivos_CSV/";
    public static String pathImg="src/main/resources/Jugadores/";
    public static String pathImgBanderas="src/main/resources/Images/Banderas/";
    public static String pathImgGeneral="src/main/resources/Images/";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VentanaMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml)  {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
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
    public static void main(String[] args) {
        launch();
        
    }
    
}
