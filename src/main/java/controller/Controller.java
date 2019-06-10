package controller;

import functionality.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text regFirstText;

    @FXML
    private TextField regLoginField;

    @FXML
    private Button regButton;

    @FXML
    private PasswordField regPasswordField;

    @FXML
    private Hyperlink regTextHasAlready;


    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        regButton.setOnAction(event -> {
            String regLoginText = regLoginField.getText().trim();
            String regPasswordText = regPasswordField.getText().trim();
            dbHandler.signUpUser(regLoginText, regPasswordText);

            openNewScene("/view/auth.fxml", regButton);
        });

        regTextHasAlready.setOnAction(event -> openNewScene("/view/auth.fxml", regButton)); // Нажать на кнопку "Уже зарегистрирован" чтобы запустить без бд
    }


    public void openNewScene(String sceneName, Node node ) {        // метод для открытия следующего окна
        node.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(sceneName));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
