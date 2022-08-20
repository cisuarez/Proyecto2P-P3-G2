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
import javafx.scene.control.TextField;
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
    private TextField txtConsulta;
    @FXML
    private Button btnConsultar;
    @FXML
    private Label lblAvisoConsulta;
    @FXML
    private HBox seccionDinamica;
    private static ArrayList<Mundial> arrMundiales=Mundial.cargarMundiales(Principal.pathFiles+"WorldCups.csv");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnConsultar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                seccionDinamica.getChildren().clear();
                mostrarConsulta();
            }
        });
    }

    public void mostrarConsulta() {
        String año = txtConsulta.getText();
        Mundial m=null;
        for (Mundial m2 : arrMundiales) {
            if (Integer.valueOf(año) == m2.getAño()) {
                m=m2;
            }
        }
        if(m!=null){
            mostrarSeccionPremios(m);
                mostrarSeccionDatosGenerales(m);
        }else{
            lblAvisoConsulta.setText("No se han encontrado registros");
        }
        
    }

    public void mostrarSeccionPremios(Mundial m) {
        lblAvisoConsulta.setText("");
        VBox seccionPremios = new VBox();
        Label lblPremios = new Label("Premios");
        Separator sepPremios = new Separator();
        HBox hbGanador = new HBox();
        Label lblGanador = new Label("Ganador");
        ImageView imgvGanador = new ImageView();
        Label lblEquipoGanador = new Label(m.getEquipoGanador().getNombre());
        ImageView imgvCopasGanador = new ImageView();
        HBox hbSegundo = new HBox();
        Label lblSegundo = new Label("Ganador");
        ImageView imgvSegundo = new ImageView();
        Label lblEquipoSegundo = new Label(m.getEquipoSegundo().getNombre());
        ImageView imgvCopasSegundo = new ImageView();
        HBox hbTercero = new HBox();
        Label lblTercero = new Label("Ganador");
        ImageView imgvTercero = new ImageView();
        Label lblEquipoTercero = new Label(m.getEquipoTercero().getNombre());
        ImageView imgvCopasTercero = new ImageView();
        HBox hbCuarto = new HBox();
        Label lblCuarto = new Label("Ganador");
        ImageView imgvCuarto = new ImageView();
        Label lblEquipoCuarto = new Label(m.getEquipoCuarto().getNombre());
        ImageView imgvCopasCuarto = new ImageView();
        hbGanador.getChildren().addAll(lblGanador, imgvGanador, lblEquipoGanador, imgvCopasGanador);
        hbGanador.setSpacing(10);
        hbSegundo.getChildren().addAll(lblSegundo, imgvSegundo, lblEquipoSegundo, imgvCopasSegundo);
        hbSegundo.setSpacing(10);
        hbTercero.getChildren().addAll(lblTercero, imgvTercero, lblEquipoTercero, imgvCopasTercero);
        hbTercero.setSpacing(10);
        hbCuarto.getChildren().addAll(lblCuarto, imgvCuarto, lblEquipoCuarto, imgvCopasCuarto);
        hbCuarto.setSpacing(10);
        seccionPremios.getChildren().addAll(lblPremios, sepPremios, hbGanador, hbSegundo, hbTercero, hbCuarto);
        seccionPremios.setSpacing(20);
        seccionDinamica.getChildren().add(seccionPremios);
    }
    public void mostrarSeccionDatosGenerales(Mundial m){
        VBox seccionDatosGenerales=new VBox();
        Label lblDatosGenerales=new Label("Datos Generales");
        Separator sepDatos=new Separator();
        Label lblGoles=new Label("Goles anotados: "+m.getGolesAnotados());
        Label lblEquipos=new Label("Equipos: "+m.getCantidadEquipos());
        Label lblPartidosJugados=new Label("Partidos jugados: "+m.getPartidosJugados());
        Label lblAsistencia=new Label("Asistencia: "+m.getCantidadAsistencia());
        seccionDatosGenerales.getChildren().addAll(lblDatosGenerales,sepDatos,lblGoles,lblEquipos,lblPartidosJugados,lblAsistencia);
        seccionDatosGenerales.setSpacing(20);
        seccionDinamica.getChildren().add(seccionDatosGenerales);
    }
}
