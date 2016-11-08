package Taxi.dao;

import Taxi.Util.HibernateUtil;
import Taxi.domain.Order;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${BIM} on 08.08.2016.
 */
public class OrderDaoImpl implements OrderDao {

    private static Logger log = Logger.getLogger(OrderDaoImpl.class);
    HibernateUtil hibernateUtil = new HibernateUtil();

    @Override
    public Integer createOrder(Order order) {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        Integer id;
        try {
            session.getSessionFactory().openSession();
            System.out.println("We opened Sessin " + order.getClientsId());
            session.beginTransaction();
            id = (Integer) session.save(order);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.getSessionFactory().close();
            }
            hibernateUtil.getSessionFactory().close();
        }
        return null;
    }

    public List<Order> getOrders() {
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Order");
            List<Order> orders = query.list();
            return orders;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.getSessionFactory().close();
            }
            hibernateUtil.getSessionFactory().close();
        }
        return null;
    }

    public ArrayList<Order> getLastFive(Integer userCid) {
        Session session = hibernateUtil.getSessionFactory().openSession();

        try {
            Query query = session.createQuery("from Order o join o.clients c where o.clients = :Cid").setInteger("Cid", userCid); /*джоин ТАБЛИЦА и НАЗВАНИЯ ПОЛЕЙ ТАБЛИЦИ*/
            List<Object[]> orders = (List<Object[]>) query.list(); /*при джоине возвращает масив ОБЪЕКТОВ*/
            ArrayList<Order> orderArrayList = new ArrayList<>();
            for (Object[] tuple : orders) {
                Order ue = (Order) tuple[0];
                orderArrayList.add(ue);
            }
            return orderArrayList;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
}
