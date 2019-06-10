package functionality;

import java.sql.*;

public class DatabaseHandler extends Configs {
    private Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?" +
                "autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Class.forName("com.mysql.jdbc.Driver");
        try {
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbConnection;
    }

    public void signUpUser(String username, String password) {
        String insert = "INSERT INTO " + Const.USERS_TABLE +
                "(" + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + ")" + "VALUES(?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, username);
            prSt.setString(2, password);
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(String username, String password) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND "
                + Const.USERS_PASSWORD + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, username);
            prSt.setString(2, password);
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

    public int getDataCategory(String username, String category) throws SQLException, ClassNotFoundException {
        int result = 0;
                
        String select = "SELECT " + category + " FROM " + Const.USERS_TABLE + " WHERE " + Const.USERS_USERNAME + "=?";

        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        prSt.setString(1, username);
        ResultSet resSet = prSt.executeQuery();
        if(resSet.next()){
            result = resSet.getInt(category);
        }
        return result;
    }



    public void addSum(String username, int sum) throws SQLException {
        String select = "UPDATE " + Const.USERS_TABLE + " SET " + Const.USERS_BUDGET + " = " + Const.USERS_BUDGET +
                "+" + sum + " WHERE " + Const.USERS_USERNAME + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, username);
            prSt.executeUpdate();
            prSt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void minusCategories(String username, String category, int sum) throws SQLException {
        String select = "UPDATE " + Const.USERS_TABLE + " SET " + category + " = " + category +
                "+" + sum + " WHERE " + Const.USERS_USERNAME + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, username);
            prSt.executeUpdate();
            prSt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}