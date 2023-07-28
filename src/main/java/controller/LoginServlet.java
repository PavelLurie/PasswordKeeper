package controller;

import entity.User;
import jakarta.servlet.annotation.WebServlet;
import model.UserModel;


import model.UserModelIml;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet implements AbstractServlet{

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

        String login = req.getParameter("login");
        String password = req.getParameter("password");



        if (model.isExist(login, password)){
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            resp.sendRedirect("/loginOK");

            User user = model.getIdFromTable2(login, password);
            model.getModelDate().setUser(user);


        } else {
            // вывести на этой же странице, что пароль или логин не верный.
            PrintWriter pw = resp.getWriter();
            pw.write("Password notOk");
//            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/loginNotOK.jsp");
//            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // этот метод показывает первононачальное состояние вьюхи.

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }
}
