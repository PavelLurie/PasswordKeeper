package Controller;

import Model.UserModel;
import Model.UserModelIml;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {
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
        String repass = req.getParameter("repass");


        if (model.emailValidator(login)) {

            if (password.equals(repass)) {
                model.createUser(login, password);
                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/signupOK.jsp");
                dispatcher.forward(req, resp);


            } else {
                PrintWriter pw = resp.getWriter();
                pw.write("Password notOk");

            }
        }else {
            PrintWriter pw = resp.getWriter();
            pw.write("E-mail notOk");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
