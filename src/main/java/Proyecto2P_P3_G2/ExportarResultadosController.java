/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Equipo;
import Modelo.Jugador;
import static Proyecto2P_P3_G2.ConsultaPartidosController.faseSerializada;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Michael
 */
public class ExportarResultadosController implements Initializable {

    @FXML
    Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void crearSerializado(ActionEvent event) {
        Stage s=(Stage)btnCancelar.getScene().getWindow();
        s.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("Se ha generado el archivo correctamente");
        alert.showAndWait();
        
        
        ArrayList<Jugador> jugadores=new ArrayList<>();
        for(Equipo equipo:ConsultaPartidosController.equiposSerializar){
            jugadores.addAll(equipo.getJugadores());
        }
        try ( ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("jugadores" + ConsultaPartidosController.faseSerializada + ".bin"))) {
            ob.writeObject(jugadores);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void salir(ActionEvent e) {
        Stage s = (Stage) btnCancelar.getScene().getWindow();
        s.close();
    }

}
