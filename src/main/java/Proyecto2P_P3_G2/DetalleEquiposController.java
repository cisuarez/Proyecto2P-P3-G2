/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class DetalleEquiposController implements Initializable {

    @FXML
    VBox root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VBox crearContenedorEquipo1 = crearContenedorJugador(12, "Brazil");
        VBox crearContenedorEquipo2 = crearContenedorJugador(14, "Alemania");
        root.getChildren().addAll(crearContenedorEquipo1,crearContenedorEquipo2);
        // TODO
    }

    private VBox crearContenedorJugador(int numeroDeJugadores, String nombreEquipo) {
        VBox contenedorEquipo = new VBox();
        Label equipo = new Label();
        equipo.setText(nombreEquipo);
        ScrollPane scrollPane = new ScrollPane();
        HBox prueba=new HBox();
        prueba.setSpacing(20);
        prueba.setPrefHeight(150);
        scrollPane.setContent(prueba);
        for (int i = 0; i < numeroDeJugadores; i++) {
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            
            Label nombre = new Label();
            nombre.setText("Nombre");
            Label jugador = new Label();
            jugador.setText("Jugador");
            ImageView imgv = new ImageView();
            try ( FileInputStream input = new FileInputStream(Principal.pathImg + "DEFAULT.png")) {
                Image image = new Image(input, 90, 90, true, false);
                imgv.setImage(image);
            } catch (IOException e1) {
                System.out.println("No se encuentra la imagen");
            }
            vbox.getChildren().addAll(imgv, nombre, jugador);
            prueba.getChildren().add(vbox);
            
        }  
       
        contenedorEquipo.getChildren().addAll(equipo, scrollPane);
        return contenedorEquipo;

    }

}
