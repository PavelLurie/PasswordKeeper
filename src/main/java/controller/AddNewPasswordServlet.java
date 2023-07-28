package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;
import model.UserModelIml;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/loginOK")
public class AddNewPasswordServlet extends HttpServlet implements AbstractServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER_NAME = "root";
        final String PASSWORD = "root";
        final String DRIVER = "org.postgresql.Driver";

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("action");


        if (a.equals("add")) {
            String name = req.getParameter("name");
            String site = req.getParameter("site");
            String login = req.getParameter("login");
            String password = req.getParameter("pass");
            //System.out.println(loginServlet.getId());
            //LoginServlet loginServlet = new LoginServlet();

            int idUser = model.getModelDate().getUser().getId(); // получить id вошедшего пользователя
            System.out.println(idUser);
            model.createUserPassTable();
            model.addUserPass(name, site, login, password, idUser);

        } else if (a.equals("new")) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/loginOK.jsp");
        dispatcher.forward(req, resp);
    }
}
