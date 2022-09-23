package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create a session
        Session session=factory.getCurrentSession();

        try{

            //start a transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents=session.createQuery("from Student").getResultList();
            //display the students
            displayStudents(theStudents);

            //query students: lastName='Kohli'
            theStudents=session.createQuery("from Student s where s.lastName='Kohli'").getResultList();

            //display the students
            System.out.println("\n\nStudents who have last name of Kohli");
            displayStudents(theStudents);

            //query students: lastName='Kohli' or firstName='Yuvraj'
            theStudents=session.createQuery("from Student s where s.lastName='Kohli' " +
                    "or s.firstName='Yuvraj'").getResultList();
            System.out.println("\n\nStudents who have last name of Kohli or first name of Yuvraj");
            displayStudents(theStudents);

            //query students: email ends with ab@luv2code.com
            theStudents=session.createQuery("from Student s where s.email like '%ab@luv2code.com'").getResultList();
            System.out.println("\n\nStudents whose email ends with ab@luv2code.com");
            displayStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done..!");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }


}
