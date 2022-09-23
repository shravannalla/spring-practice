package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {
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

            //get a course
            int theId=10;
            Course tempCourse=session.get(Course.class, theId);

            //delete the course
            System.out.println("Deleting Course: "+tempCourse);
            session.delete(tempCourse);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            //add clean up code
            session.close();
            factory.close();
        }
    }


}
