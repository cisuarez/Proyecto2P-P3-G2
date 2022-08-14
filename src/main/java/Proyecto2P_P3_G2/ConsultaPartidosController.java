/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsultaPartidosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private ComboBox<String> cbfase;
    
    @FXML 
    private ComboBox<String> cbgrupo;
    
    @FXML 
    private ComboBox<String> cbequipo1;
    
    @FXML 
    private ComboBox<String> cbequipo2;
    
    
    
    @FXML 
     void consultar(){

     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbfase.getItems().addAll("Grupos","Ronda de 16","Cuartos de Final","Semifinal","Final");
    }    
    
}
        