/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Equipo;
import Modelo.Partido;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    private ComboBox<Equipo> cbequpo1;
    
    @FXML 
    private Label lbgrupo ;
    
    @FXML 
    private VBox partidoescena;
    
    @FXML 
    private ComboBox<Equipo> cbequipo2;
    
    @FXML 
    private Button btnconsultar;
    
    public static ArrayList<Partido> partidos=Partido.cargarPartidos("src/main/resources/Archivos_CSV/WorldCupMatchesBrasil2014.csv");
    

     public void consultar(){
         VBox grandote=new VBox();
         HBox resultados = new HBox();
         VBox conteSeparador= new VBox();
         VBox detallesPartido=new VBox();
         HBox detallesGeneral=new HBox();
         VBox botones=new VBox();
         HBox match=new HBox();
         VBox arreglo=new VBox();
         Label labelConsultas=new Label();
         Label lbFecha=new Label();
         Label lbFechayHora=new Label();
         Label lbFase=new Label();
         Label lbEstadio=new Label();
         Label lbciudad=new Label();
         Label lbmarcador=new Label();
         Label lbLocal=new Label();
         Label lbVisitante=new Label();
         Label finalPartido=new Label("FINAL DEL PARTIDO");
         ImageView igLocal= new ImageView();
         ImageView igVisitante= new ImageView();
         Separator sepPartidos=new Separator();
         Button btnExportarResultados= new Button("EXPORTAR RESULTADOS DE GRUPO");
         Button btnVerDetalles= new Button("VER DETALLE DE EQUIPOS");
         Partido partido=null;
         for(Partido parti:partidos){
             if(cbequpo1.getValue().getNombre().equals(parti.getEquipoLocal().getNombre())&&cbequipo2.getValue().getNombre().equals(parti.getEquipoVisitante().getNombre())){
               partido=parti;               
             }
         }
         if(partido!=null){
             labelConsultas.setText("");
               labelConsultas.setText("Resultados del partido");
               lbFecha.setText(partido.getFecha());
               lbFechayHora.setText(partido.getFecha()+"-"+partido.getHora()+" Hora Local");
               if(cbfase.getValue().equals("Grupos")){
                   lbFase.setText("Grupo "+partido.getGrupo());
               }else{
                  lbFase.setText(partido.getFase());
                  
               }
               lbciudad.setText(partido.getCiudad());
               lbmarcador.setText(partido.getMarcador());
               lbLocal.setText(cbequpo1.getValue().getNombre());
               lbVisitante.setText(cbequipo2.getValue().getNombre());
               lbEstadio.setText(partido.getEstadio());
               
               conteSeparador.getChildren().addAll(lbFecha,sepPartidos);
               resultados.getChildren().addAll(labelConsultas);
               resultados.setAlignment(Pos.CENTER);

               match.getChildren().addAll(igLocal, lbLocal, lbmarcador, lbVisitante,igVisitante);
               match.setAlignment(Pos.CENTER);
               match.setSpacing(30);
               detallesPartido.getChildren().addAll(lbFechayHora,lbFase,lbEstadio,lbciudad);
               arreglo.getChildren().addAll(finalPartido,match);
               arreglo.setFillWidth(true);
               detallesGeneral.getChildren().addAll(detallesPartido,arreglo);
               detallesGeneral.setSpacing(120);
               botones.getChildren().addAll(btnExportarResultados,btnVerDetalles);
               botones.setSpacing(10);
               arreglo.setAlignment(Pos.CENTER);
    
               grandote.getChildren().addAll(resultados,conteSeparador,detallesGeneral,botones);
               
               partidoescena.getChildren().addAll(grandote);

         } else{
                 labelConsultas.setText("No se han encontrado partidos coincidentes con los equipos seleccionados.");
                 partidoescena.getChildren().add(labelConsultas);
                 
             }
         
    

     }
     public static ArrayList<Equipo> llenarGrupo(char a){
         ArrayList<Equipo> equiposA=new ArrayList();
           for(Partido parti: partidos){
                if(parti.getGrupo()==a&&equiposA.contains(parti.getEquipoLocal())==false){
                 equiposA.add(parti.getEquipoLocal());
                  }                      
                  }
           Collections.sort(equiposA);
           return equiposA;
     }
     
     public static ArrayList<Equipo> llenarFase(String e){
         ArrayList<Equipo> equiposA=new ArrayList();
           for(Partido parti: partidos){
                if(parti.getFase().equals(e)&&equiposA.contains(parti.getEquipoLocal())==false){
                 equiposA.add(parti.getEquipoLocal());
                  }else if(parti.getFase().equals(e)&&equiposA.contains(parti.getEquipoVisitante())==false){
                 equiposA.add(parti.getEquipoVisitante());
                  }                       
                  }
           Collections.sort(equiposA);
           return equiposA;
     }
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbfase.getItems().addAll("Grupos","Ronda de 16","Cuartos de Final","Semifinal","Final");
        cbgrupo.setVisible(false);
        lbgrupo.setVisible(false);
         String fase=cbfase.getValue();
 
         ArrayList<Partido> partidos=Partido.cargarPartidos("src/main/resources/Archivos_CSV/WorldCupMatchesBrasil2014.csv");
        cbfase.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                switch (cbfase.getValue()) {
                    case "Grupos":
                        cbequpo1.getItems().clear();
                        cbequipo2.getItems().clear();
                        cbgrupo.setVisible(true);
                        lbgrupo.setVisible(true);
                        cbgrupo.getItems().clear();
                        cbgrupo.getItems().addAll("A","B","C","D","E","F","G","H");
                        cbgrupo.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                              @Override
                              public void handle(ActionEvent e) {
                              switch (cbgrupo.getValue()) {
                                  case "A":
                                      ArrayList<Equipo> equiposA=ConsultaPartidosController.llenarGrupo('A');
                                        cbequpo1.getItems().setAll(equiposA);
                                        cbequipo2.getItems().setAll(equiposA);
                                  break;
                                  case "B":
                                     ArrayList<Equipo> equiposB= ConsultaPartidosController.llenarGrupo('B');
                                        cbequpo1.getItems().setAll(equiposB);
                                        cbequipo2.getItems().setAll(equiposB);
                                  break;
                                  case "C":
                                    ArrayList<Equipo> equiposC= ConsultaPartidosController.llenarGrupo('C');
                                        cbequpo1.getItems().setAll(equiposC);
                                        cbequipo2.getItems().setAll(equiposC);
                                  break;
                                  case "D":
                                    ArrayList<Equipo> equiposD= ConsultaPartidosController.llenarGrupo('D');
                                        cbequpo1.getItems().setAll(equiposD);
                                        cbequipo2.getItems().setAll(equiposD);
                                  break;
                                  case "E":
                                     ArrayList<Equipo> equiposE= ConsultaPartidosController.llenarGrupo('E');
                                        cbequpo1.getItems().setAll(equiposE);
                                        cbequipo2.getItems().setAll(equiposE);
                                  break;
                                  case "F":
                                     ArrayList<Equipo> equiposF= ConsultaPartidosController.llenarGrupo('F');
                                        cbequpo1.getItems().setAll(equiposF);
                                        cbequipo2.getItems().setAll(equiposF);
                                  break;
                                  case "G":
                                     ArrayList<Equipo> equiposG= ConsultaPartidosController.llenarGrupo('G');
                                        cbequpo1.getItems().setAll(equiposG);
                                        cbequipo2.getItems().setAll(equiposG);
                                  break;
                                  case "H":
                                     ArrayList<Equipo> equiposH= ConsultaPartidosController.llenarGrupo('H');
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
                        ArrayList<Equipo> equiposH= ConsultaPartidosController.llenarFase("Round of 16");
                        cbequpo1.getItems().setAll(equiposH);
                        cbequipo2.getItems().setAll(equiposH);
                        
                        break;
                    case "Cuartos de Final":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        ArrayList<Equipo> equiposx= ConsultaPartidosController.llenarFase("Quarter-finals");
                        cbequpo1.getItems().setAll(equiposx);
                        cbequipo2.getItems().setAll(equiposx);
                        
                        break;
                    case "Semifinal":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        ArrayList<Equipo> equiposz= ConsultaPartidosController.llenarFase("Semi-finals");
                        cbequpo1.getItems().setAll(equiposz);
                        cbequipo2.getItems().setAll(equiposz);
                        break;
                    case "Final":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        ArrayList<Equipo> equiposc= ConsultaPartidosController.llenarFase("Final");
                        cbequpo1.getItems().setAll(equiposc);
                        cbequipo2.getItems().setAll(equiposc);
                        break;
                    default:
                        break;
                }
                
            }
        });
        
        btnconsultar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                partidoescena.getChildren().clear();
                consultar();
            }
        });
    }    
    
}
        