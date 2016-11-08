package Taxi.Service;

import Taxi.dao.OrderDaoImpl;
import Taxi.domain.Clients;
import Taxi.domain.Order;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ${BIM} on 24.06.2016.
 */


@WebServlet("/orderReestration")
public class ServletOrderReestration extends HttpServlet {

    private static Logger log = Logger.getLogger(ServletReestration.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String streetFrom = request.getParameter("streetFrom");
        String houseFrom = request.getParameter("houseFrom");
        String blockFrom = request.getParameter("blockFrom");
        String notes = request.getParameter("notes");
        String streetTo = request.getParameter("streetTo");
        String houseTo = request.getParameter("houseTo");
        String blockTo = request.getParameter("blockTo");
        String phonNumber = request.getParameter("phonenumber");
        String fioOrder = request.getParameter("fioOrder");

        Clients client = new Clients();
        client.setPhoneNumber(phonNumber);
        client.setFio(fioOrder);
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date today = new Date();
        OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
        Date todayWithZeroTime = null;
        try {
            todayWithZeroTime = formatter.parse(formatter.format(today));

            log.info("Connection established");

            Order order = new Order();
            order.setStreetFrom(streetFrom);
            order.setHouseFrom(houseFrom);
            order.setBlockFrom(blockFrom);
            order.setNotes(notes);
            order.setStreetTo(streetTo);
            order.setHouseTo(houseTo);
            order.setBlockTo(blockTo);
            order.setPhonenumber(phonNumber);
            order.setFioOrder(fioOrder);
            order.setClientsId(client);
            order.setTaxiId(4);
            order.setOrderDate(todayWithZeroTime);
            order.setPrice(Math.round((float) (Math.random() * 100)));

            orderDaoImpl.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("orderAcceptedPage.jsp").forward(request, response);
    }
}
