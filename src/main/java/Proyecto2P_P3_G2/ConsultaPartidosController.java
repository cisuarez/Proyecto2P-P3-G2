/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Herramientas.ManejoArchivos;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partido;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
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

    public static ArrayList<Partido> partidos = Partido.cargarPartidos(Principal.pathFiles + "WorldCupMatchesBrasil2014.csv");
    public static ArrayList<Equipo> equiposSerializar = new ArrayList<>();
    public static String faseSerializada;

    /**
     * El método consultar indica las acciones que sucederán una vez si haya dado click en el botón consultar.
     * Dependiendo de los valores asignados por el usuario en el comboBox de equipo1 y equipo 2 al momento de presionar el botón.
     * Se crea desde la programación el contenedor y los elementos necesarios para mostrar la información del partido, label, VBox, 
     * Hbox, ImageView, Image. Se obtiene toda la información necesaria a partir de los equipos seleccionados en el comboBox de equipo
     * Al final, se crean los botones btnVerDetalles y btnExportarResultados.
     * El botón btnVerDetalles muestra los jugadores de los equipos seleccionados en el comboBox, a su vez se hace uso de un hilo 
     * para mostrar los jugadores de progresivamente, al terminar de mostrar todos si el usuario desea ver los detalles del jugador le da click 
     * a la imagen y se invoca el método crearHiloDetallesJugador
     * En el caso del boton btnExportarResultados, se invoca a los métodos se serializa el la lista de los equipos, y se muestran ventanas que
     * van guiando el proceso.
     */
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
        labelConsultas.setStyle("-fx-font-weight:bold");
        Label lbFecha = new Label();
        lbFecha.setStyle("-fx-font-size: 15");
        Label lbFechayHora = new Label();
        Label lbFase = new Label();
        lbFase.setStyle("-fx-font-weight:bold");
        Label lbEstadio = new Label();
        Label lbciudad = new Label();
        Label lbmarcador = new Label();
        lbmarcador.setStyle("-fx-font-size: 20");
        Label lbLocal = new Label();
        lbLocal.setStyle("-fx-font-size: 20");
        Label lbVisitante = new Label();
        lbVisitante.setStyle("-fx-font-size: 20");
        Label finalPartido = new Label("FINAL DEL PARTIDO");
        ImageView igLocal = new ImageView();
        ImageView igVisitante = new ImageView();
        Separator sepPartidos = new Separator();
        Button btnExportarResultados = new Button("EXPORTAR RESULTADOS DE GRUPO");
        btnExportarResultados.setAlignment(Pos.CENTER);
        btnExportarResultados.setStyle("-fx-background-color:#1cacde;-fx-text-fill:white");
        Button btnVerDetalles = new Button("VER DETALLE DE EQUIPOS");
        btnVerDetalles.setStyle("-fx-background-color:#1cacde;-fx-text-fill:white");
        btnVerDetalles.setAlignment(Pos.CENTER);
        btnExportarResultados.setOnAction(e -> {
            Principal.cargarVentana("ExportarResultados", 440, 200);
            String a = cbfase.getValue();
            equiposSerializar.clear();
            equiposSerializar.addAll(cbequpo1.getItems());
            if (a.equals("Grupos")) {
                faseSerializada = "Grupo" + cbgrupo.getValue();
            } else {
                faseSerializada = a;
            }
        });
        btnVerDetalles.setOnAction(e -> {
            String nombreEquipo1 = cbequpo1.getValue().getNombre();
            int cantidadJugadoresEquipo1 = cbequpo1.getValue().getJugadores().size();
            String nombreEquipo2 = cbequipo2.getValue().getNombre();
            int cantidadJugadoresEquipo2 = cbequipo2.getValue().getJugadores().size();
            Stage stage = (Stage) btnVerDetalles.getScene().getWindow();
            stage.close();
            VBox root = new VBox();
            root.setStyle("-fx-background-color:white");
            root.setSpacing(10);
            Scene scene = new Scene(root, 640, 520);
            Stage ventanaDetalleEquipos = new Stage();
            ventanaDetalleEquipos.setScene(scene);
            ventanaDetalleEquipos.show();
            root.setAlignment(Pos.CENTER);
            Label titulo = new Label("Detalle de equipos");
            titulo.setStyle("-fx-font-weight: bold ;-fx-font-size:16");

            titulo.setPadding(new Insets(5));
            VBox equipo1 = crearContenedorEquipo(cantidadJugadoresEquipo1, nombreEquipo1);
            VBox equipo2 = crearContenedorEquipo(cantidadJugadoresEquipo2, nombreEquipo2);
            root.getChildren().addAll(titulo, equipo1, equipo2);

            ScrollPane scrollEquipo1 = (ScrollPane) equipo1.getChildren().get(1);
            HBox hbEquipo1 = (HBox) scrollEquipo1.getContent();
            List<Node> vBoxsEquipo1 = hbEquipo1.getChildren();
            ScrollPane scrollEquipo2 = (ScrollPane) equipo2.getChildren().get(1);
            HBox hbEquipo2 = (HBox) scrollEquipo2.getContent();
            List<Node> vBoxsEquipo2 = hbEquipo2.getChildren();
            List<Integer> numeros = IntStream.rangeClosed(0, 45).boxed().collect(Collectors.toList());
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 46; i++) {
                        try {
                            if (i == 0) {
                                Thread.sleep(5000);
                            } else {
                                Thread.sleep(200);
                            }
                        } catch (InterruptedException inter) {

                        }
                        Collections.shuffle(numeros);
                        int indiceAleatorio = numeros.get(0);
                        if (indiceAleatorio >= 23) {
                            Jugador jugadorSeleccionado = cbequipo2.getValue().getJugadores().get(indiceAleatorio - 23);
                            VBox contenedor = (VBox) vBoxsEquipo2.get(indiceAleatorio - 23);
                            crearHiloDetallesJugador(contenedor,jugadorSeleccionado);
                        } else {
                            Jugador jugadorSeleccionado = cbequpo1.getValue().getJugadores().get(indiceAleatorio);
                            VBox contenedor = (VBox) vBoxsEquipo1.get(indiceAleatorio);
                            crearHiloDetallesJugador(contenedor,jugadorSeleccionado);
                        }
                        numeros.remove(0);
                    }
                }
            });
            hilo.start();
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
            lbFecha.setText(fechaEspañol(partido.getFecha()));
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
            Image igVisi = ManejoArchivos.abrirImagen(Principal.pathImgBanderas + cbequipo2.getValue().getAbreviatura() + ".jpg");
            igVisitante.setImage(igVisi);
            igVisitante.setFitHeight(30);
            igVisitante.setPreserveRatio(true);
            Image igLoc = ManejoArchivos.abrirImagen(Principal.pathImgBanderas + cbequpo1.getValue().getAbreviatura() + ".jpg");
            igLocal.setImage(igLoc);
            igLocal.setFitHeight(30);
            igLocal.setPreserveRatio(true);

            conteSeparador.getChildren().addAll(lbFecha, sepPartidos);
            resultados.getChildren().addAll(labelConsultas);
            resultados.setAlignment(Pos.CENTER);

            match.getChildren().addAll(igLocal, lbLocal, lbmarcador, lbVisitante, igVisitante);
            match.setAlignment(Pos.CENTER);
            match.setSpacing(50);
            detallesPartido.getChildren().addAll(lbFechayHora, lbFase, lbEstadio, lbciudad);
            detallesPartido.setSpacing(5);

            arreglo.getChildren().addAll(finalPartido, match);
            arreglo.setFillWidth(true);
            detallesGeneral.getChildren().addAll(detallesPartido, arreglo);
            detallesGeneral.setSpacing(50);
            botones.getChildren().addAll(btnExportarResultados, btnVerDetalles);
            botones.setAlignment(Pos.CENTER);
            botones.setSpacing(10);
            arreglo.setAlignment(Pos.CENTER);

            grandote.getChildren().addAll(resultados, conteSeparador, detallesGeneral, botones);
            grandote.setPadding(new Insets(10));
            grandote.setStyle("-fx-background-color:white");

            partidoescena.getChildren().addAll(grandote);

        } else {
            labelConsultas.setText("No se han encontrado partidos coincidentes con los equipos seleccionados.");
            partidoescena.getChildren().add(labelConsultas);

        }

    }

    /**
     * El método recibe el caracter del grupo.
     * Recorre la lista estática de partidos, y en cada iteración se compara si el grupo de cada partido es igual 
     * al parametro ingresado y si la lista que se va a llenar no contiene al partido.
     * Se realiza este proceso para el equipo Local y para el equipo Visitante.
     * Si cumplen las condiciones son agregadas a la lista de Equipo que será retornada al final del método.
     * @param a
     * @return
     */
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

    /**
     *El método recibe una fase.
     * Recorre la lista estática de partidos, y en cada iteración se compara si la fase de cada partido es igual 
     * al parametro ingresado y si la lista que se va a llenar no contiene al partido.
     * Se realiza este proceso para el equipo Local y para el equipo Visitante.
     * Si cumplen las condiciones son agregadas a la lista de Equipo que será retornada al final del método.
     * @param e
     * @return
     */
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
        partidoescena.setAlignment(Pos.TOP_CENTER);
        cbfase.getItems().addAll("Grupos", "Ronda de 16", "Cuartos de Final", "Semifinal", "Final");
        cbgrupo.setVisible(false);
        lbgrupo.setVisible(false);
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
                                if (cbgrupo.getValue() != null) {
                                    cargarEquiposEnComboBox(cbgrupo.getValue().charAt(0));
                                }
                            }
                        });

                        break;
                    case "Ronda de 16":

                        cargarEquipoFase("Round of 16");

                        break;
                    case "Cuartos de Final":
                        cargarEquipoFase("Quarter-finals");

                        break;
                    case "Semifinal":
                        cargarEquipoFase("Semi-finals");

                        break;
                    case "Final":
                        cargarEquipoFase("Final");
//                      
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
                try {
                    consultar();
                } catch (NullPointerException n) {
                    Label lb =new Label("No se ha seleccionado equipos.");
                    partidoescena.getChildren().add(lb);
                } catch (Exception exce) {
                    System.out.println("Se ha generado una excepción");
                }
            }
        });
    }

    private VBox crearContenedorEquipo(int numeroDeJugadores, String nombreEquipo) {
        VBox contenedorEquipo = new VBox();
        contenedorEquipo.setStyle("-fx-background-color:white");
        contenedorEquipo.setPadding(new Insets(5, 15, 5, 15));
        Label equipo = new Label(nombreEquipo);
        equipo.setStyle("-fx-font-weight: bold");
        equipo.setPadding(new Insets(10, 0, 10, 0));
        ScrollPane scrollPane = new ScrollPane();       
        scrollPane.setFitToWidth(true);
        HBox prueba = new HBox();
        prueba.setStyle("-fx-background-color:white");
        prueba.setPadding(new Insets(15, 15, 10, 15));
        prueba.setSpacing(30);
        prueba.setPrefHeight(160);
        scrollPane.setContent(prueba);
        for (int i = 0; i < numeroDeJugadores; i++) {
            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            Label nombre = new Label("Nombre");
            Label jugador = new Label("Jugador");

            Image porDefecto = ManejoArchivos.abrirImagen(Principal.pathImg + "DEFAULT.png");
            ImageView imgv = new ImageView(porDefecto);
            imgv.setFitHeight(90);
            imgv.setFitWidth(90);
            vbox.getChildren().addAll(imgv, nombre, jugador);
            prueba.getChildren().add(vbox);

        }

        contenedorEquipo.getChildren().addAll(equipo, scrollPane);
        return contenedorEquipo;

    }

    /**
     * El método recibe un caracter como parametro, el parametro indica el grupo al que pertenecerán
     * los equipos que se obtendrán tras utilizar el metodo llenarGrupo. Una vez obtenidos el arrayList de equipos
     * que pertenecen al grupo indicado en el paramentro, se carga en los combobox las listas.
     * @param character
     */
    public void cargarEquiposEnComboBox(char character) {
        ArrayList<Equipo> equipos = ConsultaPartidosController.llenarGrupo(character);
        cbequpo1.getItems().setAll(equipos);
        cbequipo2.getItems().setAll(equipos);
    }

    /**
     * El método recibe la fase de la que se desea obtener los equipos.
     * A la vez oculta el comboBox de grupo y se llena un ArrayList de equipos con el método llenar fase.
     * Se cargan a los comboBox de equipos de la lista obtenida en base al parametro.
     * @param fase
     */
    public void cargarEquipoFase(String fase) {
        cbgrupo.setVisible(false);
        lbgrupo.setVisible(false);
        ArrayList<Equipo> equipos16 = ConsultaPartidosController.llenarFase(fase);
        cbequpo1.getItems().setAll(equipos16);
        cbequipo2.getItems().setAll(equipos16);
    }
    
    /**
     *Método utilizado para hacer la traducción de una fecha dada en ingles al español.
     * @param fecha
     * @return
     */
    public static String fechaEspañol(String fecha) {
        String[] arreglo = fecha.split(" ");
        int mes1;
        String fecha1 = "";
        if (arreglo[1].equals("Jun")) {
            mes1 = 06;
        } else {
            mes1 = 07;
        }
        try {
            String inputDateStr = String.format("%s/%s/%s", Integer.valueOf(arreglo[0]), mes1, Integer.valueOf(arreglo[2]));
            Date inputDate = new SimpleDateFormat("dd/MM/yyyy").parse(inputDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(inputDate);
            String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.forLanguageTag("es")).toLowerCase();
            String mes = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.forLanguageTag("es")).toLowerCase();
            fecha1 = dayOfWeek + " " + arreglo[0] + " " + mes;
            return fecha1;

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return fecha1;
    }
    
    /**
     * El método muestra los detalles del jugador
     * Se crea una escena y todos los elementos necesarios para mostar en una ventana aparte la imagen y los detalles del jugador 
     * se le asigna un setOnMouseClicked para que al dar click en la imagen se asignen la respectiva información a los controles
     * Posteriormente se crea un hilo para manejar el tiempo que se presentará la imagen.
     * Una vez el temporizador llegue a 0, se cierra la ventana.
     * @param contenedor
     * @param jugadorSeleccionado
     */
    public void crearHiloDetallesJugador(VBox contenedor,Jugador jugadorSeleccionado) {
        ImageView imgvASetear = (ImageView) contenedor.getChildren().get(0);
        imgvASetear.setOnMouseClicked(e -> {
            VBox detalleJugador = new VBox();
            detalleJugador.setAlignment(Pos.CENTER);
            detalleJugador.setSpacing(15);
            detalleJugador.setStyle("-fx-background-color:white");
            Label nombreJug = new Label(jugadorSeleccionado.getNombre());
            nombreJug.setStyle("-fx-font-size: 20");
            ImageView imagenJug = new ImageView();
            imagenJug.setImage(imgvASetear.getImage());
            imagenJug.setFitHeight(150);
            imagenJug.setPreserveRatio(true);
            VBox detallePlayer = new VBox();
            detallePlayer.setStyle("-fx-background-color:#20def7");
            detallePlayer.setAlignment(Pos.CENTER);
            Label abreviatura = new Label(jugadorSeleccionado.getAbrEquipo());
            Label dorsal = new Label("CAMISETA NRO " + jugadorSeleccionado.getDorsal());
            Label dt = new Label("DIR. TEC." + jugadorSeleccionado.getDirectorTecnico());
            detallePlayer.getChildren().addAll(abreviatura, dorsal, dt);
            Label tiempoMostrado = new Label();
            detallePlayer.setMaxWidth(190);

            detalleJugador.getChildren().addAll(nombreJug, imagenJug, detallePlayer, tiempoMostrado);
            detalleJugador.setPadding(new Insets(10));

            Scene scene = new Scene(detalleJugador, 250, 340);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Thread hiloDetallesJugadores = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 10; 0 <= i; i--) {
                        int contador = i;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (contador == 0) {
                                    stage.close();
                                }
                                tiempoMostrado.setText("Mostrando por " + contador + " segundos");

                            }

                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
            });
            hiloDetallesJugadores.start();
        });
        Label lblNombre = (Label) contenedor.getChildren().get(1);
        Label lblJugador = (Label) contenedor.getChildren().get(2);
        Image imgJugador = ManejoArchivos.abrirImagen(Principal.pathImg + jugadorSeleccionado.getImgPath());
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                imgvASetear.setImage(imgJugador);
                lblNombre.setText(jugadorSeleccionado.getNombre());
                lblJugador.setVisible(false);
            }
        });
    }
}
