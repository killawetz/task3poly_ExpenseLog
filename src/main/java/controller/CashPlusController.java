package controller;

import functionality.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class CashPlusController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField fieldText;

    private int plusCash;

    @FXML
    void initialize() {
        buttonAdd.setOnAction(event -> {
            DatabaseHandler dbHandler = new DatabaseHandler();

            Controller control = new Controller();
            try {
                plusCash = Integer.parseInt(fieldText.getText().trim());
            } catch (NumberFormatException t) {
                ExceptionsController excep = new ExceptionsController();
                excep.showAlertWithHeaderText();
            }

            String login = AuthController.login;
            try {
                dbHandler.addSum(login, plusCash);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            control.openNewScene("/view/Basic.fxml", buttonAdd);
        });
}
}
