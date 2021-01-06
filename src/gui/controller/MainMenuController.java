package gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.transitions.JFXFillTransition;
import gui.Main;
import gui.dialog.MaterialDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private StackPane stackRootPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXButton btnDashboard;

    @FXML
    private ImageView imgDashboard;


    @FXML
    private AnchorPane centerPane;

    private JFXButton activeMenuButton;
    private JFXFillTransition ft;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ft = new JFXFillTransition();
        activeMenuButton = btnDashboard;
        btnDashboard.fire();
    }

    //Functions
    public void btnDashboardClick(ActionEvent actionEvent) {
        System.out.println("Dashboard Button has click");
        openDashboard();

    }


    public void btnIssueReturnBookClick(ActionEvent actionEvent) {
    }

    public void btnReaderInfoClick(ActionEvent actionEvent) {
    }

    public void btnBookInfoClick(ActionEvent actionEvent) {
    }

    public void btnEmployeeClick(ActionEvent actionEvent) {
        System.out.println("Dashboard Button has click");
        openEmployeeInfo();
    }

    public void btnSettingClick(ActionEvent actionEvent) {
    }

    public void btnAboutClick(ActionEvent actionEvent) {
    }

    private void openDashboard() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            //fxmlLoader.load(Main.class.getResource(fxmlName).openStream());

            fxmlLoader.setLocation(Main.class.getResource("/gui/fxml/dashboardView.fxml"));
            fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

         ((DashboardController) fxmlLoader.getController()).setPane(stackRootPane, anchorPane);

        AnchorPane root = fxmlLoader.getRoot();
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        // this method is used to auto adjust height and weight
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
    }

    private void openEmployeeInfo() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            //fxmlLoader.load(Main.class.getResource(fxmlName).openStream());

            fxmlLoader.setLocation(Main.class.getResource("/gui/fxml/employeeView.fxml"));
            fxmlLoader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ((EmployeeController) fxmlLoader.getController()).setPane(stackRootPane, anchorPane);

        AnchorPane root = fxmlLoader.getRoot();
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        // this method is used to auto adjust height and weight
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
    }

    @FXML
    void menuButtonMouseEntered(MouseEvent event) {
        if (event.getSource() != activeMenuButton) {
            ft = new JFXFillTransition();
            ft.setRegion((JFXButton) event.getSource());
            ft.setDuration(new Duration(500));
            ft.setFromValue(Color.WHITE);
            ft.setToValue(Color.rgb(214, 214, 214));
            ft.play();
        }
    }

    @FXML
    void menuButtonMouseExited(MouseEvent event) {
        if (event.getSource() != activeMenuButton) {
            ft = new JFXFillTransition();
            ft.setRegion((JFXButton) event.getSource());
            ft.setDuration(new Duration(500));
            ft.setFromValue(Color.rgb(214, 214, 214));
            ft.setToValue(Color.WHITE);
            ft.play();
        }
    }
}
