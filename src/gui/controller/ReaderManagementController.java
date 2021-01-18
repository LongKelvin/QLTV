package gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ReaderManagementController {

    ObservableList<String> search_by_list = FXCollections.observableArrayList("Reader ID","Name","Email");
    @FXML
    private ChoiceBox search_by;

    @FXML
    private TableColumn<?, ?> Stt;

    @FXML
    private TableColumn<?, ?> Reader_id;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> Date_of_birth;

    @FXML
    private TableColumn<?, ?> Address;

    @FXML
    private TableColumn<?, ?> Email;

    @FXML
    private TableColumn<?, ?> Date_of_card_issuance;

    @FXML
    private TableColumn<?, ?> Expiry_date;

    @FXML
    private TableColumn<?, ?> Number_of_issued_books;

    @FXML
    private TableColumn<?, ?> Number_of_issues;

    @FXML
    private TableColumn<?, ?> Fines;

    @FXML
    private TableColumn<?, ?> Reader_type_id;

    @FXML
    private TextField reader_id;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField email;

    @FXML
    private DatePicker date_of_birth;

    @FXML
    private DatePicker expiry_date;

    @FXML
    private TextField number_of_issues;

    @FXML
    private TextField reader_type_id;

    @FXML
    private DatePicker date_of_card_issuance;

    @FXML
    private TextField number_of_issued_books;

    @FXML
    private TextField fines;

    @FXML
    private Button view_button;

    @FXML
    private Button add_button;

    @FXML
    private Button remove_button;

    @FXML
    private Button edit_button;

    @FXML
    private TextField search_field;

    @FXML
    private Button search_button;

    @FXML
    private void initialize(){
        search_by.setValue("Reader ID");
        search_by.setItems(search_by_list);

    }
    @FXML
    void Click_add_button(ActionEvent event) {

    }

    @FXML
    void Click_edit_button(ActionEvent event) {

    }

    @FXML
    void Click_remove_button(ActionEvent event) {

    }

    @FXML
    void Click_search_button(ActionEvent event) {

    }

    @FXML
    void Click_view_button(ActionEvent event) {

    }

}
