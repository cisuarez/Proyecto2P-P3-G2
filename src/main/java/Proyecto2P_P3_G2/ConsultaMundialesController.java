/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Mundial;
import Herramientas.ManejoArchivos;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
                try{
                    mostrarConsulta();
                }catch(NumberFormatException ne){
                    lblAvisoConsulta.setText("Ingrese un valor válido");
                }catch(NullPointerException n){
                    n.printStackTrace();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
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
            seccionDinamica.setPadding(new Insets(30));
            seccionDinamica.setSpacing(150);
            mostrarSeccionPremios(m);
            mostrarSeccionDatosGenerales(m);
        }else{
            lblAvisoConsulta.setText("No se han encontrado registros");
        }
        
    }

    public void mostrarSeccionPremios(Mundial m) {
        lblAvisoConsulta.setText("");
        VBox seccionPremios=new VBox();
        Label lblPremios=new Label("Premios");
        lblPremios.setStyle("-fx-font-size: 16");
        Separator sepPremios=new Separator();
        lblPremios.setStyle("-fx-font-size: 16");
        HBox hbPremios=new HBox();
        hbPremios.setSpacing(16);
        VBox vbPosiciones=new VBox();
        vbPosiciones.setSpacing(16);
        VBox vbPaises=new VBox();
        vbPaises.setSpacing(16);
        VBox vbCopas=new VBox();
        vbCopas.setSpacing(10);
        crearSeccion(m,vbPosiciones,vbPaises,vbCopas);
        hbPremios.getChildren().addAll(vbPosiciones,vbPaises,vbCopas);
        seccionPremios.getChildren().addAll(lblPremios,sepPremios,hbPremios);
        seccionDinamica.getChildren().add(seccionPremios);
    }
    public void mostrarSeccionDatosGenerales(Mundial m){
        VBox seccionDatosGenerales=new VBox();
        Label lblDatosGenerales=new Label("Datos Generales");
        lblDatosGenerales.setStyle("-fx-font-size: 16");
        Separator sepDatos=new Separator();
        Label lblGoles=new Label("Goles anotados: "+m.getGolesAnotados());
        Label lblEquipos=new Label("Equipos: "+m.getCantidadEquipos());
        Label lblPartidosJugados=new Label("Partidos jugados: "+m.getPartidosJugados());
        Label lblAsistencia=new Label("Asistencia: "+m.getCantidadAsistencia());
        seccionDatosGenerales.getChildren().addAll(lblDatosGenerales,sepDatos,lblGoles,lblEquipos,lblPartidosJugados,lblAsistencia);
        seccionDatosGenerales.setSpacing(14);
        seccionDinamica.getChildren().add(seccionDatosGenerales);
    }
    public void crearSeccion(Mundial m,VBox posiciones,VBox paises,VBox copas){
        for(int i=0;i<4;i++){
            String[] lugares={"Ganador","Segundo","Tercero","Cuarto"};
            Label lblPosicion=new Label(lugares[i]);
            lblPosicion.setStyle("-fx-font-size: 14");
            lblPosicion.setAlignment(Pos.BOTTOM_LEFT);
            Label lblEquipo=new Label(m.getFinalistas().get(i).getNombre());
            lblEquipo.setStyle("-fx-font-size: 14");
            lblEquipo.setAlignment(Pos.BOTTOM_LEFT);
            HBox pais=new HBox();
            pais.getChildren().add(lblEquipo);
            HBox paisCopas=new HBox();
            paisCopas.setMinHeight(25);
            paisCopas.setSpacing(5);
            Image imgCopa=ManejoArchivos.abrirImagen("src/main/resources/Images/copa.png");
            for(int a=0;a<m.getFinalistas().get(i).getMundialesGanados();a++){
                ImageView imgv=new ImageView(imgCopa);
                imgv.setFitHeight(25);
                imgv.setPreserveRatio(true);
                paisCopas.getChildren().add(imgv);
            }
            copas.getChildren().add(paisCopas);
            posiciones.getChildren().add(lblPosicion);
            paises.getChildren().add(pais);
        }
    }
}
