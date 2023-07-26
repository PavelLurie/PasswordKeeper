package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    private ConnectionToDatabase() {
    }
    public static Connection getJDBCConnection(){

        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //connection.setAutoCommit(false);
        }catch (SQLException e){
            System.out.println("Соединение не установлено");
            throw new RuntimeException(e);
        }

        return connection;
    }
}
