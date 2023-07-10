package DAO;

import Service.ConnectionToDatabase;
import Service.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection connection = ConnectionToDatabase.getJDBCConnection();

    @Override
    public void createUser(String name, String password) {
        String sqlRequest = "INSERT INTO users(name, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public List<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement("SELECT name, password FROM users")){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getString("name"), rs.getString("password")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

}
