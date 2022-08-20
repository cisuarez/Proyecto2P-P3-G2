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
    
    public static ArrayList<Partido> partidos=Partido.cargarPartidos("src/main/resources/Archivos_CSV/WorldCupMatchesBrasil2014.csv");
    

    @FXML 
     void consultar(){
         
         
    

     }
     public static ArrayList<String> llenarGrupo(char a){
         ArrayList<String> equiposA=new ArrayList();
           for(Partido parti: partidos){
                if(parti.getGrupo()==a&&equiposA.contains(parti.getEquipoLocal())==false){
                 equiposA.add(parti.getEquipoLocal());
                  }                      
                  }
           return equiposA;
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
                                      ArrayList<String> equiposA=ConsultaPartidosController.llenarGrupo('A');
                                        cbequpo1.getItems().setAll(equiposA);
                                        cbequipo2.getItems().setAll(equiposA);
                                  break;
                                  case "B":
                                     ArrayList<String> equiposB= ConsultaPartidosController.llenarGrupo('B');
                                        cbequpo1.getItems().setAll(equiposB);
                                        cbequipo2.getItems().setAll(equiposB);
                                  break;
                                  case "C":
                                    ArrayList<String> equiposC= ConsultaPartidosController.llenarGrupo('C');
                                        cbequpo1.getItems().setAll(equiposC);
                                        cbequipo2.getItems().setAll(equiposC);
                                  break;
                                  case "D":
                                    ArrayList<String> equiposD= ConsultaPartidosController.llenarGrupo('D');
                                        cbequpo1.getItems().setAll(equiposD);
                                        cbequipo2.getItems().setAll(equiposD);
                                  break;
                                  case "E":
                                     ArrayList<String> equiposE= ConsultaPartidosController.llenarGrupo('E');
                                        cbequpo1.getItems().setAll(equiposE);
                                        cbequipo2.getItems().setAll(equiposE);
                                  break;
                                  case "F":
                                     ArrayList<String> equiposF= ConsultaPartidosController.llenarGrupo('F');
                                        cbequpo1.getItems().setAll(equiposF);
                                        cbequipo2.getItems().setAll(equiposF);
                                  break;
                                  case "G":
                                     ArrayList<String> equiposG= ConsultaPartidosController.llenarGrupo('G');
                                        cbequpo1.getItems().setAll(equiposG);
                                        cbequipo2.getItems().setAll(equiposG);
                                  break;
                                  case "H":
                                     ArrayList<String> equiposH= ConsultaPartidosController.llenarGrupo('H');
                                        cbequpo1.getItems().setAll(equiposH);
                                        cbequipo2.getItems().setAll(equiposH);
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
        