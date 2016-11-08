package Taxi.dao;

import Taxi.domain.Order;

import java.util.List;

/**
 * Created by ${BIM} on 08.08.2016.
 */
public interface OrderDao {
    Integer createOrder(Order order);
    List<Order> getOrders();
}
