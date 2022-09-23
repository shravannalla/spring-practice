package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //create a session
        Session session=factory.getCurrentSession();

        try{

            //start a transaction
            session.beginTransaction();

            //get instructor from db
            int theId=1;
            Instructor tempInstructor=session.get(Instructor.class, theId);

            System.out.println("luv2code: Instructor: "+tempInstructor);

            //option 1: Call getter method while session is open
            System.out.println("luv2code: Courses: "+tempInstructor.getCourses());

            //commit transaction
            session.getTransaction().commit();

            session.close();

            System.out.println("\nSession is now closed..\n");

            //get courses for instructor
            System.out.println("luv2code: Courses: "+tempInstructor.getCourses());

            System.out.println("luv2code: Done..!");
        }
        finally {
            //add clean up code
            session.close();
            factory.close();
        }
    }


}
