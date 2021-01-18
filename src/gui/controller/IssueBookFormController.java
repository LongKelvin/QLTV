package gui.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class IssueBookFormController {
    @FXML
    private TableView<?> table_info;

    @FXML
    private TextField reader_id;

    @FXML
    private TableColumn<?, ?> book_id;

    @FXML
    private TableColumn<?, ?> book_name;

    @FXML
    private TableColumn<?, ?> type_of_book;

    @FXML
    private TableColumn<?, ?> author;

    @FXML
    private JFXButton cancel_button;

    @FXML
    private JFXButton save_button;

    @FXML
    private TextField reader_name;

    @FXML
    void Click_cancel_button(ActionEvent event) {

    }

    @FXML
    void Click_save_button(ActionEvent event) {

    }

}
