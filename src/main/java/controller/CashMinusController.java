package controller;

import functionality.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CashMinusController {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private Button buttonChoose;

        @FXML
        private TextField minusTextFiled;

        private int minusCash;

        @FXML
        void initialize() {
            buttonChoose.setOnAction(event -> {
                String category = ChooseCategoriesController.categoryName;

                DatabaseHandler dbHandler = new DatabaseHandler();
                String login = AuthController.login;

               try {
                   minusCash = Integer.parseInt(minusTextFiled.getText().trim());
               } catch (NumberFormatException t) {
                   ExceptionsController excep = new ExceptionsController();
                   excep.showAlertWithHeaderText();
               }
                try {
                    dbHandler.minusCategories(login, category, minusCash);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Controller control = new Controller();
                control.openNewScene("/view/Basic.fxml", buttonChoose);
            });
        }
    }
