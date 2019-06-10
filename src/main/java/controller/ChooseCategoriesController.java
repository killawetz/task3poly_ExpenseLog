package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import functionality.Const;

public class ChooseCategoriesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView transportPic;

    @FXML
    private ImageView foodPic;

    @FXML
    private ImageView healthPic;

    @FXML
    private ImageView cafePic;

    @FXML
    private ImageView hygienePic;

    @FXML
    private ImageView entertainmentPic;

    @FXML
    private ImageView sportPic;

    @FXML
    private ImageView petsPic;

    @FXML
    private ImageView otherPic;

    @FXML
    private ImageView clothesPic;

    public static String categoryName;

    @FXML
    void initialize() {
        Controller control = new Controller();

    transportPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", transportPic);
        categoryName = Const.USERS_TRANSPORT;
    });

    foodPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", foodPic);
        categoryName = Const.USERS_FOOD;
    });

    healthPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", healthPic);
        categoryName = Const.USERS_HEALTH;
    });

    cafePic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", cafePic);
        categoryName = Const.USERS_CAFE;
    });

    hygienePic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", hygienePic);
        categoryName = Const.USERS_HYGIENE;
    });

    entertainmentPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", entertainmentPic);
        categoryName = Const.USERS_ENTERTAINMENT;
    });

    sportPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", sportPic);
        categoryName = Const.USERS_SPORT;
    });

    petsPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", petsPic);
        categoryName = Const.USERS_PETS;
    });

    otherPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", otherPic);
        categoryName = Const.USERS_OTHER;
    });

    clothesPic.setOnMouseClicked(event -> {
        control.openNewScene("/view/CashMinus.fxml", clothesPic);
        categoryName = Const.USERS_OTHER;
    });
    }
    }