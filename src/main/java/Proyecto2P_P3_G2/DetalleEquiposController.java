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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class DetalleEquiposController implements Initializable {

    @FXML
    Label Equipo1;
    @FXML
    Label Equipo2;
    @FXML
    ScrollPane jugadoresEquipo1;
    @FXML
    ScrollPane jugadoresEquipo2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ENTRO AL INICIAL");
        crearContenedorJugador(4,jugadoresEquipo1,"Brazil");
        
        // TODO
    }

    private void crearContenedorJugador(int numeroDeJugadores,ScrollPane Equipo,String nombreEquipo) {
            Equipo1.setText(nombreEquipo);       
            System.out.println("Si sirvo");
            VBox vbox=new VBox();
            Label nombre= new Label();
            nombre.setText("Nombre");
            Label jugador= new Label();
            jugador.setText("Jugador");
            ImageView imgv = new ImageView();
            try ( FileInputStream input = new FileInputStream(Principal.pathImg + "DEFAULT.png")) {
                Image image = new Image(input, 90, 90, true, false);
                imgv.setImage(image);
            } catch (IOException e1) {
                System.out.println("No se encuentra la imagen");
            }
            vbox.getChildren().addAll(imgv,nombre,jugador);
            Equipo.setContent(vbox);
           

        

    }

}
