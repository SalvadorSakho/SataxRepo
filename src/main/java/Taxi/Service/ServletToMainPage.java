package Taxi.Service;

import Taxi.dao.ClientsDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by ${BIM} on 07.06.2016.
 */
@WebServlet("/login")
public class ServletToMainPage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("loginForEnter");
        String pass = request.getParameter("password");
        String pageURL = "";

        ClientsDaoImpl clientsDaoImpl = new ClientsDaoImpl();

        for (int i = 0; i < clientsDaoImpl.loginPassValidation().size(); i++) {
            if (login.equals(clientsDaoImpl.loginPassValidation().get(i).getLogin()) && pass.equals(clientsDaoImpl.loginPassValidation().get(i).getPass())) {
                request.getSession().setAttribute("clientId", login);
                pageURL = "/workSpace";
                break;
            } else {
                pageURL = "/index.jsp";
            }
        }
        request.getRequestDispatcher(pageURL).forward(request, response);
    }
}

