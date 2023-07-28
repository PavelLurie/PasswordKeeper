package model;

import entity.User;

public interface UserModel {
    void createUserPassTable();
    void addUserPass(String name, String site, String login, String password, int idUser);

    void createUser(String name, String password);
    boolean isExist(String login, String password);
    boolean emailValidator(String login);

    int getIdFromTable(String login, String password);
    User getIdFromTable2(String login, String password);

   void setModelDate(ModelDate modelDate);
   ModelDate getModelDate();
}
