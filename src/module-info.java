module QLTV {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.datatransfer;
    requires java.sql;
    opens gui;
    opens gui.controller to javafx.fxml;
    requires com.jfoenix;
}