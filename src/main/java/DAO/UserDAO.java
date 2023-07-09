package DAO;

import Service.User;

import java.util.List;

public interface UserDAO {
    void createUser();
    List<User> getAllUsers();

}
