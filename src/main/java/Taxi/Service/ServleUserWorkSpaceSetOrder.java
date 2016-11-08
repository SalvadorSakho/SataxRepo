package Taxi.Service;

import Taxi.dao.ClientsDaoImpl;
import Taxi.dao.OrderDaoImpl;
import Taxi.domain.Clients;
import Taxi.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ${BIM} on 22.07.2016.
 */
@WebServlet("/orderFromWorkSpace")
public class ServleUserWorkSpaceSetOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String streetFrom = req.getParameter("streetFrom");
        String houseFrom = req.getParameter("houseFrom");
        String blockFrom = req.getParameter("blockFrom");
        String notes = req.getParameter("notes");
        String streetTo = req.getParameter("streetTo");
        String houseTo = req.getParameter("houseTo");
        String blockTo = req.getParameter("blockTo");
        String login = (String) req.getSession().getAttribute("inputIdLogin");
        String pageURL = "";
        Order order = new Order();
        Clients client = new Clients();
        OrderDaoImpl orderDao = new OrderDaoImpl();
        ClientsDaoImpl clientsDaoImpl = new ClientsDaoImpl();


        for (int i = 0; i < clientsDaoImpl.loginPassValidation().size(); i++) {
            if (login.equals(clientsDaoImpl.loginPassValidation().get(i).getLogin())) {

                client.setClientID(clientsDaoImpl.loginPassValidation().get(i).getClientID());
                client.setEmail(clientsDaoImpl.loginPassValidation().get(i).getEmail());
                client.setPhoneNumber(clientsDaoImpl.loginPassValidation().get(i).getPhoneNumber());
                client.setPass(clientsDaoImpl.loginPassValidation().get(i).getPass());
                client.setLogin(clientsDaoImpl.loginPassValidation().get(i).getLogin());
                client.setFio(clientsDaoImpl.loginPassValidation().get(i).getFio());
                req.getSession().setAttribute("clientId", login);

                order.setStreetFrom(streetFrom);
                order.setHouseFrom(houseFrom);
                order.setBlockFrom(blockFrom);
                order.setNotes(notes);
                order.setStreetTo(streetTo);
                order.setHouseTo(houseTo);
                order.setBlockTo(blockTo);
                order.setPhonenumber(clientsDaoImpl.loginPassValidation().get(i).getPhoneNumber());
                order.setFioOrder(clientsDaoImpl.loginPassValidation().get(i).getFio());
                order.setClientsId(client);
                order.setOrderDate(new Date());
                /*
                order.setTaxiId(1);
                order.setPrice(50);
                */
                orderDao.createOrder(order);
                req.getSession().setAttribute("clientId", login);
                pageURL = "orderAcceptedPageFromWorkSpace.jsp";
                break;
            }
        }
        req.getRequestDispatcher(pageURL).forward(req, resp);
    }
}