package sample;

import javafx.scene.control.Button;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    Button buttonClickMe;

    public void handleButtonClickMe(){
        buttonClickMe.setText("Hello Guy");
    }
}
