module Proyecto2P_P3_G2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens Proyecto2P_P3_G2 to javafx.fxml;
    exports Proyecto2P_P3_G2;
}
