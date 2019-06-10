package controller;

import functionality.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AuthController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text authFirstText;

    @FXML
    private TextField authLoginField;

    @FXML
    private Button authButton;

    @FXML
    private PasswordField authPasswordField;

    public static String login;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        authButton.setOnAction(event -> {
            login = authLoginField.getText().trim();

            String regLoginText = authLoginField.getText().trim();
            String regPasswordText = authPasswordField.getText().trim();
            try {
                loginUser(regLoginText, regPasswordText);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }



    public void loginUser(String username, String password) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet result = dbHandler.getUser(username, password);

        boolean checking = false;
        while (result.next()) {
            checking = true;
        }
        if (checking) {
             Controller control = new Controller();
             control.openNewScene("/view/Basic.fxml", authButton);
        }
    }
}
