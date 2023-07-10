package DAO;

import Service.User;

import java.util.List;

public interface UserDAO {
    void createUser(String name, String password);
    List<User> getAllUsers();

}
