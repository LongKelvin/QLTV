package gui;

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
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        //Parent root = FXMLLoader.load(getClass().getResource("userLogin.fxml"));
        Scene scene = new Scene(createVBoxLayout(), 300, 200);
        primaryStage.setTitle("Đăng Nhập");
        primaryStage.setScene(scene);
        primaryStage.show();

        getAllUsers();

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
                passLabel, passwordField, hbox);

        return vbox;
    }

    private DBUtils dbUltils = null;
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    String result = "";

    /**
     * getAllUsers method.<br>
     *
     * @return resultSet;
     */
    public void getAllUsers() {

        // Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.

        String sqlSelectAll = "SELECT TOP (1000) [MATK]\n" +
                "      ,[TENTK]\n" +
                "      ,[MATKHAU]\n" +
                "      ,[MACHUCVU]\n" +
                "      ,[MANV]\n" +
                "  FROM [QLTV].[dbo].[TAIKHOANNV]";

        try {
            dbUltils = new DBUtils();
            connection = dbUltils.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                System.out.println(resultSet.getString("TENTK"));
                System.out.println(resultSet.getString("MATKHAU"));
                System.out.println(resultSet.getString("MACHUCVU"));
                System.out.println("-----------------------");

                //result.add(usersDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
