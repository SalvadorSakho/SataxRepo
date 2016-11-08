package Taxi.Service;

import Taxi.dao.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ${BIM} on 02.09.2016.
 */
@WebServlet("/workerValidation")
public class ServletWorkerValidation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("userLoginId");
        String pass = request.getParameter("userPasswordId");

        UsersDaoImpl usersDaoImpl = new UsersDaoImpl();
        String answer = "";

        for (int i = 0; i < usersDaoImpl.findAll().size(); i++) {
            if (login.equals(usersDaoImpl.findAll().get(i).getUserLogin()) && pass.equals(usersDaoImpl.findAll().get(i).getUserPassword())) {
                answer = "exist";
                request.getSession().setAttribute("userLoginId", login);
                break;
            } else {
                answer = "Notexist";
            }
        }
        response.getWriter().write(answer);
    }
}
