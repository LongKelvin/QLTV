package gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BookManagementController {

    @FXML
    private TextField book_id;

    @FXML
    private TextField book_name;

    @FXML
    private TextField author;

    @FXML
    private TextField publisher;

    @FXML
    private TextField type_of_book_id;

    @FXML
    private TextField price;

    @FXML
    private TextField number_of_issues;


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

    ObservableList<String> search_by_list = FXCollections.observableArrayList("Book ID","Book Name");
    @FXML
    private ChoiceBox search_by;

    @FXML
    private Button search_button;

    @FXML
    private DatePicker year_published;
    @FXML
    private DatePicker date_of_entry;

    @FXML
    private TableColumn<?, ?> Book_id;

    @FXML
    private TableColumn<?, ?> Book_name;

    @FXML
    private TableColumn<?, ?> Author;

    @FXML
    private TableColumn<?, ?> Type_of_book_id;

    @FXML
    private TableColumn<?, ?> Publisher;

    @FXML
    private TableColumn<?, ?> Year_published;

    @FXML
    private TableColumn<?, ?> Date_of_entry;

    @FXML
    private TableColumn<?, ?> Price;

    @FXML
    private TableColumn<?, ?> Quantity;

    @FXML
    private TableColumn<?, ?> Number_of_issues;

    @FXML
    private TextField quantity;

    @FXML
    private void initialize(){
        search_by.setValue("Book ID");
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
