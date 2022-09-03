/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import static Proyecto2P_P3_G2.Principal.loadFXML;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
    /**
     * metodo que abre la ventana de consultar partidos
     * @param event
     * @throws IOException 
     */
    @FXML
    private void cambiarConsultaPartidos(ActionEvent event) throws IOException {
        Principal.cargarVentana("ConsultaPartidos",810,494);
        
        
    }
    /**
     * metodo que abre la ventana de consultar copas mundiales
     * @param event
     * @throws IOException 
     */
    @FXML
    private void cambiarConsultaCopasMundiales(ActionEvent event) throws IOException {

        Principal.cargarVentana("ConsultaMundiales",640,480);
        
        
    }
    
    
    
}
