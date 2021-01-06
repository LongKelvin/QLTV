package gui.controller;

import bus.LoginBus;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gui.Main;
import gui.dialog.MaterialDialog;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class userLoginController implements Initializable {

    String ERROR_TAG = "Something Went Wrong!!!";
    LoginBus loginBus = new LoginBus();

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void btnCancelClick() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnLoginClick() {
//        if (!isInValidInput()) {
//            if (loginBus.IsValid(txtUsername.getText(), txtPassword.getText())) {
//
//                String[] accountType = loginBus.GetAccountType(txtUsername.getText());
//                if (accountType != null) {
//                    String employeePos = accountType[0];
//                    String employeeCode = accountType[1];
//                    System.out.println("Employee_Pos: " + employeePos);
//                    System.out.println("Employee_Code: " + employeeCode);
//                    openMainMenu();
//                }
//                System.out.println("LOGIN:: OK");
//            } else {
//                MaterialDialog.DialogOK(stackPane, "Notifications", " Incorrect username or password.", rootPane);
//            }
//        } else {
//            MaterialDialog.DialogOK(stackPane, "Notifications", " Username or Password can not be empty.", rootPane);
//        }
        openMainMenu();
    }


    private boolean isInValidInput() {
        return txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void openMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/gui/fxml/MainMenu.fxml"));
            loader.load();
            Parent parent = loader.getRoot();
            Scene scene = new Scene(parent);
            Stage dashboardStage = new Stage();
            dashboardStage.setMinHeight(626.0);
            dashboardStage.setMinWidth(926.0);
            dashboardStage.setScene(scene);
            dashboardStage.setMaximized(true);
            dashboardStage.show();
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            MaterialDialog.DialogOK(stackPane,ERROR_TAG ,e.toString(), rootPane);
        }
    }
}
