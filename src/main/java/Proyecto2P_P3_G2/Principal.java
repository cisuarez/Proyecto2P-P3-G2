/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto2P_P3_G2;

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
    
    @Override
    public void start(Stage s) throws IOException{
        FXMLLoader fx=new FXMLLoader();
        Parent root=fx.load();
        Scene scene=new Scene(root);
        s.setScene(scene);
        s.show();
    }
}
