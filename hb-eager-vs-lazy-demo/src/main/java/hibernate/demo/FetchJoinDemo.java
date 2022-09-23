package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
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

            //Option 2: Hibernate query with HQL

            //get instructor from db
            int theId=1;

            Query<Instructor> query=
                    session.createQuery("select i from Instructor i " +
                            "JOIN FETCH i.courses " +
                            "where i.id=:theInstructorId",
                            Instructor.class);

            //set parameter on query
            query.setParameter("theInstructorId", theId);

            //execute query and get instructor
            Instructor tempInstructor=query.getSingleResult();

            System.out.println("luv2code: Instructor: "+tempInstructor);


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
