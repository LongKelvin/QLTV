package gui.controller;

import bus.LoginBus;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gui.dialog.MaterialDialog;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class userLoginController implements Initializable {

    LoginBus loginBus = new LoginBus();
    boolean login = false;

    @FXML
    private StackPane stackPane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private ImageView bgImage;

    @FXML
    void btnCancelClick(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnLoginClick(ActionEvent event) {
        if (!isInValidInput()) {
            if (isAuthorized()) {
                System.out.println("LOGIN:: OK");
            } else {
                MaterialDialog.DialogOK(stackPane,"Notifications", " Incorrect username or password.", rootPane);
            }
        } else {
            MaterialDialog.DialogOK(stackPane, "Notifications"," Incorrect username or password.", rootPane);
        }

    }

    private boolean isAuthorized() {
        if (!login) {
            if (loginBus.IsValid(txtUsername.getText(), txtPassword.getText())) {
                System.out.println("LOGIN:: Login Success");
                login = true;
                return true;
            }
            else{
                login = false;
            }
        }
        return false;
    }

    private boolean isInValidInput() {
        return txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
