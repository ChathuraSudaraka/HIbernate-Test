package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

/**
 * Builds and provides access to a singleton SessionFactory.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = build();

    private static SessionFactory build() {
        try {
            // Try standard location first
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception primary) {
            try {
                // Fallback for projects that keep it under conf/
                return new Configuration().configure("conf/hibernate.cfg.xml").buildSessionFactory();
            } catch (Exception secondary) {
                RuntimeException ex = new RuntimeException(
                        "SessionFactory build failed. Tried 'hibernate.cfg.xml' and 'conf/hibernate.cfg.xml'.", secondary);
                ex.addSuppressed(primary);
                throw ex;
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
