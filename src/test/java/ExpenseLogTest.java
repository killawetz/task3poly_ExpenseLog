import controller.AuthController;
import controller.BasicController;
import functionality.Const;
import functionality.DatabaseHandler;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ExpenseLogTest {
    int foodExpense = 2250;
    String login = "user1337";
    String password = "test";

    @Test
    public void testDb() throws SQLException, ClassNotFoundException {
        AuthController control = new AuthController();
        DatabaseHandler dbHandler = new DatabaseHandler();
        int expectation = dbHandler.getDataCategory(login, Const.USERS_FOOD);
        assertEquals(foodExpense, expectation);
    }

    @Test
    public void testTotalExpense() {
        BasicController basic = new BasicController();
        int sum = basic.totalExpenseCalculation(0, 10, 20, 30, 40, 50, 60, 70, 80, 90);
        assertEquals(450, sum);
    }
}