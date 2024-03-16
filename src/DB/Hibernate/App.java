package DB.Hibernate;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; // Import the DB.Hibernate Configuration class

import java.io.FileInputStream;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        // Create DB.Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("DB/Hibernate.cfg.xml");

        // Create session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        //entity
        Student st = new Student();
        st.setId(101);
        st.setName("Rishi");
        st.setCity("Basti");
        System.out.println(st);

        // Create and save address entity
        Address ad = new Address();
        ad. setStreet( "street " ) ;
        ad . setCity( " DELHI " ) ;
        ad. setOpen (true) ;
        ad. setAddressDate(new Date());
        ad . setX(1234.234) ;

        //Reading image
        FileInputStream fileInputStream = new FileInputStream("src/DB/Hibernate/Rishi-singh.png");
        byte[] data = new byte[fileInputStream.available()];
        fileInputStream.read(data);


       ad.setImage(data);
        session.save(st);
        session.save(ad);
        // Commit transaction
        transaction.commit();

        // Close session
        session.close();

        // Close session factory
        sessionFactory.close();
    }
}
