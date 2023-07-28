package dao;

import entity.User;

import java.util.List;

public interface UserDAO {
    void createUserPassTable();
    void addUserPass(String name, String site, String login, String password, int idUser);
    void createUser(String name, String password);
    List<User> getAllUsers();


}
