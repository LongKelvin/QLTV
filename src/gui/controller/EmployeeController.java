package gui.controller;

import com.jfoenix.transitions.JFXFillTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class EmployeeController {
    private JFXFillTransition ft;
    private StackPane stackPane;
    private AnchorPane rootPane;

    public void setPane(StackPane stackPane, AnchorPane rootPane) {
        this.stackPane = stackPane;
        this.rootPane = rootPane;
    }

    public void anchorMouseClick(MouseEvent mouseEvent) {
    }

    public void anchorMouseEntered(MouseEvent mouseEvent) {
    }

    public void anchorMouseExited(MouseEvent mouseEvent) {
    }
}
