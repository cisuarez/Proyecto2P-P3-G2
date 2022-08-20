/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import static Proyecto2P_P3_G2.Principal.loadFXML;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class VentanaMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void cambiarConsultaPartidos() throws IOException {
        Scene scene = new Scene(Principal.loadFXML("ConsultaPartidos"), 640, 480);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        
        
    }
    @FXML
    private void cambiarConsultaCopasMundiales() throws IOException {
        Scene scene = new Scene(Principal.loadFXML("ConsultaMundiales"), 640, 480);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    
    
}
