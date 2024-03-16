package DB.Hibernate;

import org.hibernate.SessionFactory;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        Properties propertyies = null;
        if (sessionFactory == null) {

          //  Configuration configuration = new Configuration();
            propertyies = new Properties();
            System.out.println(propertyies);
        }
        return (SessionFactory) propertyies;
    }
}
