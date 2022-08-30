/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partido;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

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
    private Label lbgrupo;

    @FXML
    private VBox partidoescena;

    @FXML
    private ComboBox<Equipo> cbequipo2;

    @FXML
    private Button btnconsultar;

    public static ArrayList<Partido> partidos = Partido.cargarPartidos(Principal.pathFiles+"WorldCupMatchesBrasil2014.csv");
    public static ArrayList<Equipo> equiposSerializar= new ArrayList<>();
    public static String faseSerializada;

    public void consultar() {
        VBox grandote = new VBox();
        HBox resultados = new HBox();
        VBox conteSeparador = new VBox();
        VBox detallesPartido = new VBox();
        HBox detallesGeneral = new HBox();
        VBox botones = new VBox();
        HBox match = new HBox();
        VBox arreglo = new VBox();
        Label labelConsultas = new Label();
        Label lbFecha = new Label();
        Label lbFechayHora = new Label();
        Label lbFase = new Label();
        Label lbEstadio = new Label();
        Label lbciudad = new Label();
        Label lbmarcador = new Label();
        Label lbLocal = new Label();
        Label lbVisitante = new Label();
        Label finalPartido = new Label("FINAL DEL PARTIDO");
        ImageView igLocal = new ImageView();
        ImageView igVisitante = new ImageView();
        Separator sepPartidos = new Separator();
        Button btnExportarResultados = new Button("EXPORTAR RESULTADOS DE GRUPO");
        Button btnVerDetalles = new Button("VER DETALLE DE EQUIPOS");
        btnExportarResultados.setOnAction(e->{
            Principal.cargarVentana("ExportarResultados",440,200);
            String a=cbfase.getValue();
            if(a=="Grupos"){
                faseSerializada="Grupo"+cbgrupo.getValue();
            }else{
                faseSerializada=a;
            }
        });
        btnVerDetalles.setOnAction(e -> {
            String nombreEquipo1=cbequpo1.getValue().getNombre();
            int cantidadJugadoresEquipo1=cbequpo1.getValue().getJugadores().size();
            System.out.println(cantidadJugadoresEquipo1);
            String nombreEquipo2=cbequipo2.getValue().getNombre();           
            int cantidadJugadoresEquipo2=cbequipo2.getValue().getJugadores().size();
            System.out.println(cantidadJugadoresEquipo2);
            Stage stage = (Stage) btnVerDetalles.getScene().getWindow();
            stage.close();
            VBox root = new VBox();
            Scene scene = new Scene(root,640,480);                                
            Stage ventanaDetalleEquipos = new Stage();
            ventanaDetalleEquipos.setScene(scene);
            ventanaDetalleEquipos.show();
            
            Label titulo = new Label();
            titulo.setTextAlignment(TextAlignment.CENTER);
            VBox equipo1=crearContenedorJugador(cantidadJugadoresEquipo1,nombreEquipo1);
            VBox equipo2=crearContenedorJugador(cantidadJugadoresEquipo2,nombreEquipo2);
            root.getChildren().addAll(titulo,equipo1,equipo2);
            

        });
        Partido partido = null;
        for (Partido parti : partidos) {
            if (cbequpo1.getValue().getNombre().equals(parti.getEquipoLocal().getNombre()) && cbequipo2.getValue().getNombre().equals(parti.getEquipoVisitante().getNombre())) {
                partido = parti;
            }
        }
        if (partido != null) {
            labelConsultas.setText("");
            labelConsultas.setText("Resultados del partido");
            lbFecha.setText(partido.getFecha());
            lbFechayHora.setText(partido.getFecha() + "-" + partido.getHora() + " Hora Local");
            if (cbfase.getValue().equals("Grupos")) {
                lbFase.setText("Grupo " + partido.getGrupo());
            } else {
                lbFase.setText(partido.getFase());

            }
            lbciudad.setText(partido.getCiudad());
            lbmarcador.setText(partido.getMarcador());
            lbLocal.setText(cbequpo1.getValue().getNombre());
            lbVisitante.setText(cbequipo2.getValue().getNombre());
            lbEstadio.setText(partido.getEstadio());

            conteSeparador.getChildren().addAll(lbFecha, sepPartidos);
            resultados.getChildren().addAll(labelConsultas);
            resultados.setAlignment(Pos.CENTER);

            match.getChildren().addAll(igLocal, lbLocal, lbmarcador, lbVisitante, igVisitante);
            match.setAlignment(Pos.CENTER);
            match.setSpacing(30);
            detallesPartido.getChildren().addAll(lbFechayHora, lbFase, lbEstadio, lbciudad);
            arreglo.getChildren().addAll(finalPartido, match);
            arreglo.setFillWidth(true);
            detallesGeneral.getChildren().addAll(detallesPartido, arreglo);
            detallesGeneral.setSpacing(120);
            botones.getChildren().addAll(btnExportarResultados, btnVerDetalles);
            botones.setSpacing(10);
            arreglo.setAlignment(Pos.CENTER);

            grandote.getChildren().addAll(resultados, conteSeparador, detallesGeneral, botones);

            partidoescena.getChildren().addAll(grandote);

        } else {
            labelConsultas.setText("No se han encontrado partidos coincidentes con los equipos seleccionados.");
            partidoescena.getChildren().add(labelConsultas);

        }

    }

    public static ArrayList<Equipo> llenarGrupo(char a) {
        ArrayList<Equipo> equiposA = new ArrayList();
        
        for (Partido parti : partidos) {
            if (parti.getGrupo() == a && equiposA.contains(parti.getEquipoLocal()) == false) {
                equiposA.add(parti.getEquipoLocal());
            }
        }
        Collections.sort(equiposA);       
        return equiposA;
    }

    public static ArrayList<Equipo> llenarFase(String e) {
        ArrayList<Equipo> equiposA = new ArrayList();
        
        for (Partido parti : partidos) {
            if (parti.getFase().equals(e) && equiposA.contains(parti.getEquipoLocal()) == false) {
                equiposA.add(parti.getEquipoLocal());
            } else if (parti.getFase().equals(e) && equiposA.contains(parti.getEquipoVisitante()) == false) {
                equiposA.add(parti.getEquipoVisitante());
            }
        }
        Collections.sort(equiposA);     
        return equiposA;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        cbfase.getItems().addAll("Grupos", "Ronda de 16", "Cuartos de Final", "Semifinal", "Final");
        cbgrupo.setVisible(false);
        lbgrupo.setVisible(false);
        String fase = cbfase.getValue();

        ArrayList<Partido> partidos = Partido.cargarPartidos("src/main/resources/Archivos_CSV/WorldCupMatchesBrasil2014.csv");
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
                        cbgrupo.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");
                        cbgrupo.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                switch (cbgrupo.getValue()) {
                                    case "A":
                                        ArrayList<Equipo> equiposA = ConsultaPartidosController.llenarGrupo('A');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposA);
                                        cbequpo1.getItems().setAll(equiposA);
                                        cbequipo2.getItems().setAll(equiposA);
                                        break;
                                    case "B":
                                        ArrayList<Equipo> equiposB = ConsultaPartidosController.llenarGrupo('B');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposB);
                                        cbequpo1.getItems().setAll(equiposB);
                                        cbequipo2.getItems().setAll(equiposB);
                                        break;
                                    case "C":
                                        ArrayList<Equipo> equiposC = ConsultaPartidosController.llenarGrupo('C');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposC);
                                        cbequpo1.getItems().setAll(equiposC);
                                        cbequipo2.getItems().setAll(equiposC);
                                        break;
                                    case "D":
                                        ArrayList<Equipo> equiposD = ConsultaPartidosController.llenarGrupo('D');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposD);
                                        cbequpo1.getItems().setAll(equiposD);
                                        cbequipo2.getItems().setAll(equiposD);
                                        break;
                                    case "E":
                                        ArrayList<Equipo> equiposE = ConsultaPartidosController.llenarGrupo('E');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposE);
                                        cbequpo1.getItems().setAll(equiposE);
                                        cbequipo2.getItems().setAll(equiposE);
                                        break;
                                    case "F":
                                        ArrayList<Equipo> equiposF = ConsultaPartidosController.llenarGrupo('F');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposF);
                                        cbequpo1.getItems().setAll(equiposF);
                                        cbequipo2.getItems().setAll(equiposF);
                                        break;
                                    case "G":
                                        ArrayList<Equipo> equiposG = ConsultaPartidosController.llenarGrupo('G');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposG);
                                        cbequpo1.getItems().setAll(equiposG);
                                        cbequipo2.getItems().setAll(equiposG);
                                        break;
                                    case "H":
                                        ArrayList<Equipo> equiposH = ConsultaPartidosController.llenarGrupo('H');
                                        equiposSerializar.clear();
                                        equiposSerializar.addAll(equiposH);
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
                        ArrayList<Equipo> equipos16 = ConsultaPartidosController.llenarFase("Round of 16");
                        equiposSerializar.clear();
                        equiposSerializar.addAll(equipos16);
                        cbequpo1.getItems().setAll(equipos16);
                        cbequipo2.getItems().setAll(equipos16);

                        break;
                    case "Cuartos de Final":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        ArrayList<Equipo> equiposX = ConsultaPartidosController.llenarFase("Quarter-finals");
                        equiposSerializar.clear();
                        equiposSerializar.addAll(equiposX);
                        cbequpo1.getItems().setAll(equiposX);
                        cbequipo2.getItems().setAll(equiposX);

                        break;
                    case "Semifinal":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        ArrayList<Equipo> equiposZ = ConsultaPartidosController.llenarFase("Semi-finals");
                        equiposSerializar.clear();
                        equiposSerializar.addAll(equiposZ);
                        cbequpo1.getItems().setAll(equiposZ);
                        cbequipo2.getItems().setAll(equiposZ);
                        break;
                    case "Final":
                        cbgrupo.setVisible(false);
                        lbgrupo.setVisible(false);
                        ArrayList<Equipo> equiposC = ConsultaPartidosController.llenarFase("Final");
                        equiposSerializar.clear();
                        equiposSerializar.addAll(equiposC);
                        cbequpo1.getItems().setAll(equiposC);
                        cbequipo2.getItems().setAll(equiposC);
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
    private VBox crearContenedorJugador(int numeroDeJugadores, String nombreEquipo) {
        VBox contenedorEquipo = new VBox();
        Label equipo = new Label(nombreEquipo);     
        ScrollPane scrollPane = new ScrollPane();
        HBox prueba=new HBox();
        prueba.setSpacing(20);
        prueba.setPrefHeight(150);
        scrollPane.setContent(prueba);
        for (int i = 0; i < numeroDeJugadores; i++) {
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);        
            Label nombre = new Label("Nombre");          
            Label jugador = new Label("Jugador");      
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
