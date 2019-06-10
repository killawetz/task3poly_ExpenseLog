package controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ExceptionsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonOk;

    Controller control = new Controller();

    @FXML
    void initialize() {
        buttonOk.setOnAction(event ->
            control.openNewScene("/view/Basic.fxml", buttonOk));
    }

    public void printError(Node node){
        control.openNewScene("/view/Exceptions.fxml", node);
    }

    public void showAlertWithHeaderText() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("ACHTUNG!!!!");
        alert.setContentText("Неверный формат ввода! Попробуйте еще раз! =)");

        alert.showAndWait();
    }
}
