package DB.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
    public static void main(String[] args) {
        // Create DB.Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("DB/Hibernate.cfg.xml");
        // Create session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Creating Question
        Question q1 = new Question();
        q1.setQuestionId(1212);
        q1.setQuestion("what is java ?");

        //Creating Answer
        Answer answer = new Answer();
        answer.setAnswerId(343);
        answer.setAnswer("Java is programming language");
        answer.setQuestion(q1);  // creat a join column in Answer table
        q1.setAnswer(answer);

        //Creating Question
        Question q2 = new Question();
        q2.setQuestionId(242);
        q2.setQuestion("what is Collection Framwork  ?");

        //Creating Answer
        Answer answer2 = new Answer();
        answer2.setAnswerId(344);
        answer2.setAnswer("API to work with object in Java");
        answer2.setQuestion(q2);  // creat a join column in Answer table
        q2.setAnswer(answer2);

        //Creating Question
        Question q3 = new Question();
        q3.setQuestionId(234324);
        q3.setQuestion("what is c ?");

        //Creating Answer
        Answer answer3 = new Answer();
        answer3.setAnswerId(777);
        answer3.setAnswer("C is Structure programming language");
        answer3.setQuestion(q3);  // creat a join column in Answer table
        q3.setAnswer(answer3);



        //session
        Session s = sessionFactory.openSession();
//        Session session = sessionFactory.getCurrentSession(); // this is new version
        Transaction transaction = s.beginTransaction();

        //save     // Save or update
//        s.persist(q1);  //Replace the s.save(q1) line with: The persist method is the preferred way to save new entities in newer versions of Hibernate. It schedules the entity for insertion during the transaction commit.
//        s.persist(q2);  //Replace the s.save(q1) line with: The persist method is the preferred way to save new entities in newer versions of Hibernate. It schedules the entity for insertion during the transaction commit.
         s.persist(q1);//deprecated since version 6.0
         s.persist(q2);//deprecated since version 6.0
         s.persist(q3);//deprecated since version 6.0
//         s.saveOrUpdate(q1);  //this is a new version
            s.persist(answer);
            s.persist(answer2);
            s.persist(answer3);
        transaction.commit();


        //Fetching............
        Question newQ = (Question) s.get(Question.class, 1212);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());
        s.close();
        sessionFactory.close();

    }
}
