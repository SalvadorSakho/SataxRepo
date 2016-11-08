package Taxi.Service;

import Taxi.dao.OrderDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by ${BIM} on 10.09.2016.
 */
@WebServlet("/ordersTableForStuff")
public class ServletOrdersTableForWorkers extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
        
        for (int z = orderDaoImpl.getOrders().size() - 1; z >= 0; z--) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(
                    orderDaoImpl.getOrders().get(z).getOrderId() + ","
                            + orderDaoImpl.getOrders().get(z).getStreetFrom() + " "
                            + orderDaoImpl.getOrders().get(z).getHouseFrom() + ","
                            + orderDaoImpl.getOrders().get(z).getStreetTo() + " "
                            + orderDaoImpl.getOrders().get(z).getHouseTo() + ","
                            + orderDaoImpl.getOrders().get(z).getFioOrder() + ","
                            + orderDaoImpl.getOrders().get(z).getNotes() + ","
                            + simpleDateFormat.format(orderDaoImpl.getOrders().get(z).getOrderDate()) + ","
                            + orderDaoImpl.getOrders().get(z).getTaxiId() + ","
                            + orderDaoImpl.getOrders().get(z).getPrice() + ";");
        }
    }
}

