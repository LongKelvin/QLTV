package gui.controller;

import com.jfoenix.transitions.JFXFillTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class DashboardController {


    private JFXFillTransition ft;
    private StackPane stackPane;
    private AnchorPane rootPane;

    public void setPane(StackPane stackPane, AnchorPane rootPane) {
        this.stackPane = stackPane;
        this.rootPane = rootPane;
    }

    //Functions
    public void anchorMouseClick(MouseEvent mouseEvent) {
    }

    public void anchorMouseEntered(MouseEvent mouseEvent) {
    }

    public void anchorMouseExited(MouseEvent mouseEvent) {
    }
}
