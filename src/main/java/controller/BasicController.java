package controller;

import functionality.Const;
import functionality.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class BasicController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonMinus;

    @FXML
    private Button buttonPlus;

    @FXML
    private PieChart pieChart;

    @FXML
    private Text budgetText;

    @FXML
    private Text expenseText;

    @FXML
    private Text remainderText;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String login = AuthController.login;

        int transport = dbHandler.getDataCategory(login, Const.USERS_TRANSPORT);
        int food = dbHandler.getDataCategory(login, Const.USERS_FOOD);
        int hygiene = dbHandler.getDataCategory(login, Const.USERS_HYGIENE);
        int cafe = dbHandler.getDataCategory(login, Const.USERS_CAFE);
        int entertainment = dbHandler.getDataCategory(login, Const.USERS_ENTERTAINMENT);
        int sport = dbHandler.getDataCategory(login, Const.USERS_SPORT);
        int pets = dbHandler.getDataCategory(login, Const.USERS_PETS);
        int health = dbHandler.getDataCategory(login, Const.USERS_HEALTH);
        int clothes = dbHandler.getDataCategory(login, Const.USERS_CLOTHES);
        int other = dbHandler.getDataCategory(login, Const.USERS_OTHER);
        int budget = dbHandler.getDataCategory(login, Const.USERS_BUDGET);
        int expense = totalExpenseCalculation(transport, food, health, cafe, entertainment, sport, pets, health, cafe,
                other);
        int remainder = budget - expense;

        budgetText.setText(Integer.toString(budget));
        expenseText.setText(Integer.toString(expense));
        remainderText.setText(Integer.toString(remainder));

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Транспорт \n" + transport, transport),
                        new PieChart.Data("Еда \n" + food, food),
                        new PieChart.Data("Гигиена \n" + hygiene, hygiene),
                        new PieChart.Data("Кафе \n" + cafe, cafe),
                        new PieChart.Data("Развлечения \n" + entertainment, entertainment),
                        new PieChart.Data("Спорт \n" + sport, sport),
                        new PieChart.Data("Животные \n" + pets, pets),
                        new PieChart.Data("Здоровье \n" + health, health),
                        new PieChart.Data("Одежда \n" + clothes, clothes),
                        new PieChart.Data("Прочее \n" + other, other));

        pieChart.setTitle("Расходы");
        pieChart.setData(pieChartData);
        //setting the direction to arrange the data
        pieChart.setClockwise(true);

        //Setting the length of the label line
        pieChart.setLabelLineLength(50);

        //Setting the labels of the pie chart visible
        pieChart.setLabelsVisible(true);

        //Setting the start angle of the pie chart
        pieChart.setStartAngle(180);


        Controller con = new Controller();
        buttonPlus.setOnAction(event ->
            con.openNewScene("/view/CashPlus.fxml", buttonPlus));
            buttonMinus.setOnAction(event ->
                con.openNewScene("/view/ChooseCategories.fxml", buttonMinus));


    }
        public int totalExpenseCalculation(int sum, int sum1, int sum2, int sum3, int sum4, int sum5,
                                            int sum6, int sum7, int sum8, int sum9) {
        return sum+sum1+sum2+sum3+sum4+sum5+sum6+sum7+sum8+sum9;
        }

}
