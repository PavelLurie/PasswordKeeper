package dao;

import service.ConnectionToDatabase;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection connection = ConnectionToDatabase.getJDBCConnection();

    @Override
    public void createUserPassTable() {
        String sqlRequest = "CREATE TABLE IF NOT EXISTS users_pass(id SERIAL PRIMARY KEY, name VARCHAR(45), site VARCHAR(30), login VARCHAR(100), password VARCHAR(100), user_id INT REFERENCES users(id))";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addUserPass(String name, String site, String login, String password, int idUser) {
        String sqlRequest = "INSERT INTO users_pass(name, site, login, password, id_user) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, site);
            preparedStatement.setString(3, login);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, idUser);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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

        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM users")){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("password")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
