package gui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class AddReaderController {


    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField address;

    @FXML
    private JFXDatePicker date_of_birth;

    @FXML
    private JFXDatePicker expiry_date;

    @FXML
    private JFXDatePicker date_of_card_issuance;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField fines;

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
