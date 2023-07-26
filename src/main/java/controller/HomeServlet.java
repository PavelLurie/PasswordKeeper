package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action.equals("signup")){
            SignUpServlet signUpServlet = new SignUpServlet();
            signUpServlet.init();
            signUpServlet.doPost(req, resp);
        } else if (action.equals("signin")) {
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.init();
            loginServlet.doPost(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }
}
