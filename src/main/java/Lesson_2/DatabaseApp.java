package Lesson_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseApp {

    static final String DATABASEURL = "jdbc:sqlite:javadb.db";
    static Connection connection;
    static Statement statement;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DATABASEURL);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {
        DatabaseApp databaseApp = new DatabaseApp();
        databaseApp.createTable();
        databaseApp.insertNewBike("bike1", "no1");
        databaseApp.insertBikePS("model","serial");
        System.out.println(databaseApp.searchBike());
//        databaseApp.dropTable();


    }

    public void createTable() throws SQLException {
        String createTable = "create table if not exists bike(" +
                "id integer not null primary key," +
                " model varchar(30) not null," +
                " serialNumber varchar(30))";

        statement.execute(createTable);
    }

    public void insertNewBike(String name, String serial) throws SQLException {
        String insertNewBike = "insert into bike(model,serialNumber) values('" + name + "','" + serial + "')";
        statement.execute(insertNewBike);
    }
    public void insertBikePS(String model, String serial) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into bike(model,serialNumber) values(?,?)");
        for (int i = 0; i<11; i++){
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, serial);
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
    }

    public List<Bike> searchBike() throws SQLException {
        String sql = "select * from bike";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Bike> bikeList = new ArrayList<>();
        while (resultSet.next()) {
            bikeList.add(new Bike(
                    resultSet.getInt("id"),
                    resultSet.getString("model"),
                    resultSet.getString("serialNumber")));

//            System.out.println(nt"id = " + resultSet.getInt("id")
//                    + " " + resultSet.getString("model")
//                    + " " + resultSet.getString(3));
        }
        return bikeList;
    }

    public void dropTable() throws SQLException {
        String dropTable = "drop table bike";
        statement.execute(dropTable);
    }
}
