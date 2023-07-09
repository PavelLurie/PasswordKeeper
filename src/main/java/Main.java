import DAO.UserDAO;
import DAO.UserDAOImpl;
import Service.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static UserDAO userDAO = new UserDAOImpl();
    public static void main(String[] args) {
        if (!check().isEmpty()){
            System.out.println("Вы вошли в систему");
        }else {
            System.out.println("Неправильный пароль или логин");
        }

    }

    public static List<Integer> check(){
        List<Integer> indices = new ArrayList<>();
        User user = new User("user3", "qwerty78");
        for (int i = 0; i < userDAO.getAllUsers().size(); i++) {
            if (userDAO.getAllUsers().get(i).toString().equals(user.toString())) {
                indices.add(i);
            }
        }
        return indices;
    }
}
