package Model;

public interface UserModel {
    void createUser(String name, String password);
    boolean isExist(String login, String password);
    boolean emailValidator(String login);
}
