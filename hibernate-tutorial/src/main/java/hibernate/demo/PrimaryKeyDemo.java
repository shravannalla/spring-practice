package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create a session
        Session session=factory.getCurrentSession();

        try{
            //create 3 student objects
            System.out.println("Creating 3 new student object..");
            Student tempStudent1=new Student("Virat","Kohli","virat@luv2code.com");
            Student tempStudent2=new Student("Rohit","Sharma","rohit@luv2code.com");
            Student tempStudent3=new Student("Rishab","Pant","rishab@luv2code.com");

            //start a transaction
            session.beginTransaction();
            //save the student object
            System.out.println("Saving the students..");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }
}
