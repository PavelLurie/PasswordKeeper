package Controller;

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
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signUp = req.getParameter("signup");
        String signIn = req.getParameter("signin");
        String reset = req.getParameter("reset");

        System.out.println("signIn is " + signIn);
        System.out.println("signUp is " + signUp);
        System.out.println("reset is " + reset);

        LoginServlet loginServlet = new LoginServlet();
        SignUpServlet signUpServlet = new SignUpServlet();

        if (signUp != null){
            signUpServlet.init();
            signUpServlet.doPost(req, resp);
        } else if (signIn != null) {
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
