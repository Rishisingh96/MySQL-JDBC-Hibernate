package DB.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; // Import the DB.Hibernate Configuration class

public class EmDemo {
    public static void main(String[] args) {
     Configuration configuration = new Configuration();
     configuration.configure("DB/Hibernate.cfg.xml");

        SessionFactory factory = configuration.buildSessionFactory();


        Student student1 = new Student();

        student1.setId(123);
        student1.setCity("Basti");
        student1.setName("Rishi singh");

        Certificate certificate = new Certificate();
        certificate.setCourse("Java");
        certificate.setDuration("2 month");

        student1.setCertificaet(certificate);


        Student student12 = new Student();
        student12.setId(12334);
        student12.setCity("Indore");
        student12.setName("Garima singh");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Hibernate");
        certificate2.setDuration("1 month");

        student12.setCertificaet(certificate2);

        Session s = factory.openSession();

        Transaction tx =s.beginTransaction();

        //object save
        s.save(student1);
        s.save(student12);
        //Object save

        tx.commit();
        s.close();
        factory.close();

    }
}
