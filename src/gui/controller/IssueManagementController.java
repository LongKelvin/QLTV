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

public class IssueManagementController {

    @FXML
    private TextField issue_id;

    @FXML
    private TextField reader_id;

    @FXML
    private TextField reader_name;
    @FXML
    private TextField number_of_issued_books;

    @FXML
    private Button new_issue_button;

    @FXML
    private Button remove_button;

    @FXML
    private Button edit_button;

    @FXML
    private TextField search_field;

    ObservableList<String> search_by_list = FXCollections.observableArrayList("Issue ID","Reader ID");
    @FXML
    private ChoiceBox  search_by;


    @FXML
    private DatePicker date_of_issue;

    @FXML
    private DatePicker date_of_return;

    @FXML
    private TableColumn<?, ?> Issue_id;

    @FXML
    private TableColumn<?, ?> Reader_id;

    @FXML
    private TableColumn<?, ?> Date_of_issue;

    @FXML
    private TableColumn<?, ?> Date_of_return;

    @FXML
    private TableColumn<?, ?> Number_of_issued_books;

    @FXML
    private Button search_button;
    @FXML
    private void initialize(){
        search_by.setValue("Issue ID");
        search_by.setItems(search_by_list);

    }

    @FXML
    void Click_edit_button(ActionEvent event) {

    }

    @FXML
    void Click_new_issue_button(ActionEvent event) {

    }

    @FXML
    void Click_remove_button(ActionEvent event) {

    }

    @FXML
    void Click_search_button(ActionEvent event) {

    }

}
