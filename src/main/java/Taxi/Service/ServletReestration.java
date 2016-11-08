package Taxi.Service;

import Taxi.dao.ClientsDaoImpl;
import Taxi.domain.Clients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ${BIM} on 09.06.2016.
 */
@WebServlet("/reestration")
public class ServletReestration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fioForReestration = request.getParameter("fioReestration");
        String loginForReestration = request.getParameter("loginReestration");
        String passForReestration = request.getParameter("passwordReestration");
        String phoneForReestration = request.getParameter("phonenumberReestration");
        String emailForReestration = request.getParameter("emailReestration");

        Clients client1 = new Clients();
        ClientsDaoImpl clientsDao = new ClientsDaoImpl();

        client1.setFio(fioForReestration);
        client1.setLogin(loginForReestration);
        client1.setPhoneNumber(phoneForReestration);
        client1.setEmail(emailForReestration);
        client1.setPass(passForReestration);
        clientsDao.createClient(client1);
        request.getSession().setAttribute("clientId", loginForReestration);
        request.getRequestDispatcher("/workSpace").forward(request, response);
    }
}
