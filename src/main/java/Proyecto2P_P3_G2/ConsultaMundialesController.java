/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Mundial;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author CJAA
 */
public class ConsultaMundialesController implements Initializable {
    
    @FXML
    private Label lblConsulta;
    @FXML
    private Button btnConsultar;
    @FXML
    private Label lblAvisoConsulta;
    private static ArrayList<Mundial> arrMundiales;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnConsultar.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent> (){
           
            @Override
            public void handle(ActionEvent e){
//                arrMundiales=Mundial.cargarMundiales("");
                String año=lblConsulta.getText();
                for(Mundial m:arrMundiales){
                    if (Integer.valueOf(año)==m.getAño()){
                        lblAvisoConsulta.setText("");
                        VBox seccionPremios=new VBox();
                        Label lblPremios=new Label("Premios");
                        Separator sepPremios=new Separator();
                        HBox hbGanador=new HBox();
                        Label lblGanador=new Label("Ganador");
                        ImageView imgvGanador=new ImageView();
                        Label lblEquipoGanador=new Label(m.getEquipoGanador().getNombre());
                        ImageView imgvCopasGanador=new ImageView();
                        HBox hbSegundo=new HBox();
                        Label lblSegundo=new Label("Ganador");
                        ImageView imgvSegundo=new ImageView();
                        Label lblEquipoSegundo=new Label(m.getEquipoSegundo().getNombre());
                        ImageView imgvCopasSegundo=new ImageView();
                        HBox hbTercero=new HBox();
                        Label lblTercero=new Label("Ganador");
                        ImageView imgvTercero=new ImageView();
                        Label lblEquipoTercero=new Label(m.getEquipoTercero().getNombre());
                        ImageView imgvCopasTercero=new ImageView();
                        HBox hbCuarto=new HBox();
                        Label lblCuarto=new Label("Ganador");
                        ImageView imgvCuarto=new ImageView();
                        Label lblEquipoCuarto=new Label(m.getEquipoCuarto().getNombre());
                        ImageView imgvCopasCuarto=new ImageView();
                        hbGanador.getChildren().addAll(lblGanador,imgvGanador,lblEquipoGanador,imgvCopasGanador);
                        hbSegundo.getChildren().addAll(lblSegundo,imgvSegundo,lblEquipoSegundo,imgvCopasSegundo);
                        hbTercero.getChildren().addAll(lblTercero,imgvTercero,lblEquipoTercero,imgvCopasTercero);
                        hbCuarto.getChildren().addAll(lblCuarto,imgvCuarto,lblEquipoCuarto,imgvCopasCuarto);
                        seccionPremios.getChildren().addAll(lblPremios,sepPremios,hbGanador,hbSegundo,hbTercero,hbCuarto);
                    }else{
                        lblAvisoConsulta.setText("No se han encontrado registros");
                    }
                }
                
            }
        });
    }    
    
}
