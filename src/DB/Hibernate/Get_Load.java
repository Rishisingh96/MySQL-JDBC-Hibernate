package DB.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Get_Load {
    public static void main(String[] args) {
        // Create DB.Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("DB/Hibernate.cfg.xml");

        // Create session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create session
        Session session = sessionFactory.openSession();

        //
        Student student = (Student) session.load(Student.class,108);
        System.out.println(student);

//        Address ad = (Address)session.get(Address.class,88);
//        System.out.println(ad.getStreet());
        session.close();
        sessionFactory.close();
    }
}
