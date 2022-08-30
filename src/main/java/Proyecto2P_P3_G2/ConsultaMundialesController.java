/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Proyecto2P_P3_G2;

import Modelo.Mundial;
import Herramientas.ManejoArchivos;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
     * Inicializa la clase controladora. Se añade un controlador de eventos a btnConsultar para un ActionEvent
     * de tipo ACTION. Cuando se da este evento, se invoca al método mostrarConsulta y se manejan las excepciones
     * que este puede generar.
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
    
    /**
     * Este método recupera el año consultado por el usuario, verifica si existe un mundial relacionado, si
     * es el caso, muestra la sección dinámica con la información que se necesita mostrar, llamando a los
     * métodos que muestran las sub-secciones que tiene esta sección. Cuando no se encuentra un mundial
     * sucedido en el año ingresado, se muestra al usuario (con un label) que no se encontraron registros.
     */
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

    /**
     * Este método recibe un objeto de tipo Mundial, crea los contenedores principales de la sección premios,
     * el título de la sección, el separador y llama al método que completa la creación del resto de elementos
     * de la sección. El objeto Mundial recibido lo provee al método que completa la sección.
     * @param m
     */
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

    /**
     * Este método recibe un objetivo de tipo Mundial del cual toma las estadísticas
     * que se muestran en esta sección, se crean controles y contenedores en los que se 
     * carga la información y el contenedor general se agrega al contenedor de la sección dinámica
     * @param m
     */
    public void mostrarSeccionDatosGenerales(Mundial m){
        VBox seccionDatosGenerales=new VBox();
        Label lblDatosGenerales=new Label("Datos Generales");
        lblDatosGenerales.setStyle("-fx-font-size: 16");
        Separator sepDatos=new Separator();
        VBox cabecera=new VBox();
        cabecera.getChildren().addAll(lblDatosGenerales,sepDatos);
        cabecera.setSpacing(1);
        Label lblGoles=new Label("Goles anotados: "+m.getGolesAnotados());
        lblGoles.setStyle("-fx-font-size: 14");
        Label lblEquipos=new Label("Equipos: "+m.getCantidadEquipos());
        lblEquipos.setStyle("-fx-font-size: 14");
        Label lblPartidosJugados=new Label("Partidos jugados: "+m.getPartidosJugados());
        lblPartidosJugados.setStyle("-fx-font-size: 14");
        Label lblAsistencia=new Label("Asistencia: "+m.getCantidadAsistencia());
        lblAsistencia.setStyle("-fx-font-size: 14");
        seccionDatosGenerales.getChildren().addAll(cabecera,lblGoles,lblEquipos,lblPartidosJugados,lblAsistencia);
        seccionDatosGenerales.setSpacing(14);
        seccionDinamica.getChildren().add(seccionDatosGenerales);
    }
    
    /**
     * Este método recibe un objeto de tipo Mundial y tres contenedores para obtener los datos de los primeros 
     * lugares y acceder los atributos de dichos equipos, con ellos se crean y llenan los controladores 
     * necesarios que serán agregados en los contenedores que luego se muestran en la vista. Esto incluye la 
     * imagen de las banderas de los equipos y la cantidad de copas que tienen.
     * @param m
     * @param posiciones
     * @param paises
     * @param copas
     */
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
            Image bandera=ManejoArchivos.abrirImagen("src/main/resources/Images/Banderas/"+m.getFinalistas().get(i).getAbreviatura()+".jpg");
            ImageView imgvEquipo=new ImageView(bandera);
            imgvEquipo.setFitHeight(15);
            imgvEquipo.setPreserveRatio(true);
            pais.getChildren().addAll(imgvEquipo,lblEquipo);
            pais.setSpacing(3);
            pais.setAlignment(Pos.CENTER_LEFT);
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
