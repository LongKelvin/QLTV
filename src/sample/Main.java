package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(createVBoxLayout(), 300, 200);
        primaryStage.setTitle("Đăng Nhập");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public VBox createVBoxLayout() {
        VBox vbox = new VBox();

        vbox.setSpacing(10);
        vbox.setPadding(new Insets(5));
        vbox.setAlignment(Pos.CENTER_LEFT);

        Label userLabel = new Label("User Name ");
        Label passLabel = new Label("Password ");
        TextField userTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setPadding(new Insets(8));
        loginButton.setMaxWidth(150);

        Button cancelButton = new Button("Cancel");
        cancelButton.setPadding(new Insets(8));
        cancelButton.setMaxWidth(150);

        HBox hbox = new HBox();
        hbox.setSpacing(50);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(loginButton, cancelButton);



        vbox.getChildren().addAll(userLabel, userTextField,
                passLabel, passwordField,hbox);

        return vbox;
    }
    

}
