package model;

public interface UserModel {
    void createUserPassTable();
    void addUserPass(String name, String site, String login, String password, int idUser);

    void createUser(String name, String password);
    boolean isExist(String login, String password);
    boolean emailValidator(String login);
}
