package Model;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import Service.User;

public class UserModelIml implements UserModel {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    public void createUser(String name, String password) {
        userDAO.createUser(name, password);
    }

    @Override
    public boolean isExist(String login, String password) {
        for (User user : userDAO.getAllUsers()){
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
