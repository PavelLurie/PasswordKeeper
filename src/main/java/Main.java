import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

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

        //System.out.println(userDAO.getAllUsers());
        Test test = new Test();
        test.math();
        System.out.println(test.getA());

    }

    public static List<Integer> check(){
        List<Integer> indices = new ArrayList<>();
        User user = new User(2, "user2", "qwerty");
        for (int i = 0; i < userDAO.getAllUsers().size(); i++) {
            if (userDAO.getAllUsers().get(i).toString().equals(user.toString())) {
                indices.add(i);
            }
        }
        return indices;
    }
}

class Test{
     private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void math(){
        setA(5);
    }
}