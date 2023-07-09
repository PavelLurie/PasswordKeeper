package Controller;

import DAO.UserDAO;
import Model.UserModel;


import Model.UserModelIml;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("")
public class LoginServlet extends HttpServlet {
    private Connection connection;
    private UserModel model;



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
        this.model = new UserModelIml();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (model.isExist(login, password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", login);

//            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/loginOK.jsp");
//            dispatcher.forward(req, resp);

            resp.sendRedirect("/loginOK.jsp");

        } else {
            // вывести на этой же странице, что пароль или логин не верный.
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/loginNotOK.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // этот метод отдает результат во вьюху.

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }
}
