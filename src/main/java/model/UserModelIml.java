package model;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserModelIml implements UserModel {
    UserDAO userDAO = new UserDAOImpl();
    ModelDate modelDate = new ModelDate();

    public ModelDate getModelDate() {
        return modelDate;
    }

    public void setModelDate(ModelDate modelDate) {
        this.modelDate = modelDate;
    }

    @Override
    public void createUserPassTable() {
        userDAO.createUserPassTable();
    }

    @Override
    public void addUserPass(String name, String site, String login, String password, int idUser) {
        userDAO.addUserPass(name, site, login, password, idUser);
    }

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

    @Override
    public boolean emailValidator(String login) {
        String reg = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(login);

        if (matcher.matches()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int getIdFromTable(String login, String password) {
        for (User user : userDAO.getAllUsers()){
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(password)){
                return user.getId();
            }
        }
        return 0;
    }

    @Override
    public User getIdFromTable2(String login, String password) {
        for (User user : userDAO.getAllUsers()){
            if (user.getLogin().equals(login) &&
                    user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
