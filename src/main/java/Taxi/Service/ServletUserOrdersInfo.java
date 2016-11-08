package Taxi.Service;

import Taxi.dao.ClientsDaoImpl;
import Taxi.dao.OrderDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by ${BIM} on 10.07.2016.
 */
@WebServlet("/usersOrders")
public class ServletUserOrdersInfo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String loginForTabOrders = (String) request.getSession().getAttribute("clientId");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        ClientsDaoImpl clientsDaoImpl = new ClientsDaoImpl();
        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

        for (int i = 0; i < clientsDaoImpl.loginPassValidation().size(); i++) {
            if (loginForTabOrders.equals(clientsDaoImpl.loginPassValidation().get(i).getLogin())) {
                if (orderDaoImpl.getLastFive(clientsDaoImpl.loginPassValidation().get(i).getClientID()).size() <= 5) {
                    for (int z = orderDaoImpl.getLastFive(clientsDaoImpl.loginPassValidation().get(i).getClientID()).size() - 1; z >= 0; z--) {
                        response.setContentType("text/html;charset=UTF-8");
                        response.getWriter().write(
                                orderDaoImpl.getLastFive(clientsDaoImpl.loginPassValidation().get(i).getClientID()).get(z).getStreetFrom() + " "  /*[Ljava.lang.Object; cannot be cast to Taxi.domain.Order*/
                                        + orderDaoImpl.getLastFive(clientsDaoImpl.loginPassValidation().get(i).getClientID()).get(z).getHouseFrom() + ","
                                        + orderDaoImpl.getLastFive(clientsDaoImpl.loginPassValidation().get(i).getClientID()).get(z).getStreetTo() + " "
                                        + orderDaoImpl.getLastFive(clientsDaoImpl.loginPassValidation().get(i).getClientID()).get(z).getHouseTo() + ","
                                        + simpleDateFormat.format(orderDaoImpl.getLastFive(clientsDaoImpl.loginPassValidation().get(i).getClientID()).get(z).getOrderDate()) + ","
                                        + "Nisan" + ","
                                        + 50 + ";");
                    }
                } else if (orderDaoImpl.getOrders().size() >= 6) {
                    for (int z = orderDaoImpl.getOrders().size() - 1; z > orderDaoImpl.getOrders().size() - 6; z--) {

                        response.setContentType("text/html;charset=UTF-8");
                        response.getWriter().write(
                                orderDaoImpl.getOrders().get(z).getStreetFrom() + " "
                                        + orderDaoImpl.getOrders().get(z).getHouseFrom() + ","
                                        + orderDaoImpl.getOrders().get(z).getStreetTo() + " "
                                        + orderDaoImpl.getOrders().get(z).getHouseTo() + ","
                                        + simpleDateFormat.format(orderDaoImpl.getOrders().get(z).getOrderDate()) + ","
                                        + "Nisan" + ","
                                        + 50 + ";");
                    }
                }
            }
        }
    }
}