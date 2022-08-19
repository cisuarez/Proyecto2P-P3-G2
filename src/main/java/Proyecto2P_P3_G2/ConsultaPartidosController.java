/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Partido;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
    private ComboBox<String> cbequpo1;
    
    @FXML 
    private Label lbgrupo ;
    
    @FXML 
    private ComboBox<String> cbequipo2;
    

    @FXML 
     void consultar(){
         
         
    

     }
     
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbfase.getItems().addAll("Grupos","Ronda de 16","Cuartos de Final","Semifinal","Final");
        cbgrupo.setVisible(false);
        lbgrupo.setVisible(false);
         String fase=cbfase.getValue();
         String grupo=cbgrupo.getValue();
         String equipo1=cbequpo1.getValue();
         String equipo2=cbequipo2.getValue();
         ArrayList<Partido> partidos=Partido.cargarPartidos("src/main/resources/Archivos_CSV/WorldCupMatchesBrasil2014.csv");
        cbfase.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                switch (cbfase.getValue()) {
                    case "Grupos":
                        cbgrupo.setVisible(true);
                        lbgrupo.setVisible(true);
                        cbgrupo.getItems().clear();
                        cbgrupo.getItems().addAll("A","B","C","D","E","F","G","H");
                        cbgrupo.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent e) {
                              switch (cbgrupo.getValue()) {
                                  case "A":
                                      ArrayList<String> equiposA=new ArrayList();
                                    for(Partido parti: partidos){
                                        if(parti.getGrupo()=='A'&&equiposA.contains(parti.getEquipoLocal())==false){
                                           equiposA.add(parti.getEquipoLocal());
                                        }
                                        
                                    } 
                                      System.out.println(equiposA);
                                    cbequpo1.getItems().setAll(equiposA);
                                    cbequipo2.getItems().setAll(equiposA);
                                  break;
                                  case "B":
                                     ArrayList<String> equiposB=new ArrayList();
                                    for(Partido parti: partidos){
                                        if(parti.getGrupo()=='B'&&equiposB.contains(parti.getEquipoLocal())==false){
                                           equiposB.add(parti.getEquipoLocal());
                                        }
                                    } 
                                      System.out.println(equiposB);
                                    cbequpo1.getItems().setAll(equiposB);
                                    cbequipo2.getItems().setAll(equiposB);
                                  break;
                                  case "C":
                                    for(Partido parti: partidos){
                                        
                                    } 
                                  break;
                                  case "D":
                                     for(Partido parti: partidos){
                                        
                                    }
                                  break;
                                  case "E":
                                     for(Partido parti: partidos){
                                        
                                    }
                                  break;
                                  case "F":
                                     for(Partido parti: partidos){
                                        
                                    }
                                  break;
                                  case "G":
                                     for(Partido parti: partidos){
                                        
                                    }
                                  break;
                                  case "H":
                                     for(Partido parti: partidos){
                                        
                                    }
                                  break;
                                    
                                  default:
                                  break;
                                 }
                                }
                                });
                            
                        break;
                    case "Ronda de 16":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        break;
                    case "Cuartos de Final":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        break;
                    case "Semifinal":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        break;
                    case "Final":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        break;
                    default:
                        break;
                }
                
            }
        });
    }    
    
}
        