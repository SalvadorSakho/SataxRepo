package Taxi.dao;

import Taxi.Util.HibernateUtil;
import Taxi.domain.Clients;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ${BIM} on 28.07.2016.
 */
public class ClientsDaoImpl implements ClientsDao {
    private static Logger log = Logger.getLogger(ClientsDaoImpl.class);
    HibernateUtil hibernateUtil = new HibernateUtil();

    public List<Clients> loginPassValidation() {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Clients c");
            List<Clients> clients = query.list();
            return clients;

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


    @Override
    public List<Clients> findAll() {
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery(" from Clients");
        List<Clients> clients = query.list();
        return clients;
    }

    @Override
    public Integer createClient(Clients clients) {
        Session session = null;
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        try {
            log.info("Reference to SessionFactory " + sessionFactory);
            log.info("Connection established");
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(clients);

            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
        return null;
    }



    /*private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("Hibernate/hibernateConfig.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        return cfg.buildSessionFactory(standardServiceRegistry);
    }*/

}
