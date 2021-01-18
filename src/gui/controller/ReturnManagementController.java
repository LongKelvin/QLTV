package gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class ReturnManagementController {

    @FXML
    private TableColumn<?, ?> Return_id;

    @FXML
    private TableColumn<?, ?> Reader_id;

    @FXML
    private TableColumn<?, ?> Reader_name;

    @FXML
    private TableColumn<?, ?> Date_of_issue;

    @FXML
    private TableColumn<?, ?> Date_of_return;

    @FXML
    private TableColumn<?, ?> Number_of_issued_books;

    @FXML
    private TableColumn<?, ?> Fines;

    @FXML
    private TextField return_id;

    @FXML
    private TextField reader_id;

    @FXML
    private TextField reader_name;

    @FXML
    private TextField number_of_issued_books;

    @FXML
    private TextField fines;

    @FXML
    private Button new_return_button;

    @FXML
    private TextField search_field;

    ObservableList<String> search_by_list = FXCollections.observableArrayList("Return ID","Reader ID");
    @FXML
    private ChoiceBox search_by;

    @FXML
    private Button search_button;

    @FXML
    private DatePicker date_of_issue;

    @FXML
    private DatePicker date_of_return;

    @FXML
    private void initialize(){
        search_by.setValue("Return ID");
        search_by.setItems(search_by_list);

    }

    @FXML
    void Click_new_return_button(ActionEvent event) {

    }

    @FXML
    void Click_search_button(ActionEvent event) {

    }

}
