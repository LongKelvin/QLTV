package gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
public class AddEmployeeController {

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXDatePicker date_of_birth;

    @FXML
    private JFXTextField phone;

    @FXML
    private JFXTextField degree;

    @FXML
    private JFXTextField department;

    @FXML
    private JFXTextField position;

    @FXML
    private JFXButton save_button;

    @FXML
    private JFXButton cancel_button;

    @FXML
    void Click_cancel_button(ActionEvent event) {

    }

    @FXML
    void Click_save_button(ActionEvent event) {

    }


}
