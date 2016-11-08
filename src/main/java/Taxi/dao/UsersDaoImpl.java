package Taxi.dao;

import Taxi.Util.HibernateUtil;
import Taxi.domain.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ${BIM} on 02.09.2016.
 */
public class UsersDaoImpl implements UsersDao {
    private static Logger log = Logger.getLogger(UsersDaoImpl.class);

    @Override
    public List<Users> findAll() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Users");
            List<Users> userses = query.list();
            return userses;
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

    /*private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("Hibernate/hibernateConfig.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        return cfg.buildSessionFactory(standardServiceRegistry);
    }*/
}
