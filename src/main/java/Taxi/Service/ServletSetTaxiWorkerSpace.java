package Taxi.Service;

import Taxi.dao.OrderDaoImpl;
import Taxi.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ${BIM} on 14.09.2016.
 */
@WebServlet("/setTaxiWorkers")
public class ServletSetTaxiWorkerSpace extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String[] myJsonData = request.getParameterValues("carId");

        for (int i = 0; i < myJsonData.length; i++) {
            System.out.println(Integer.parseInt(myJsonData[i]));
            OrderDaoImpl orderDaoImpl= new OrderDaoImpl();
            Order order = new Order();
            order.setTaxiId(Integer.parseInt(myJsonData[i]));
           // orderDaoImpl.
        }


    }
}
