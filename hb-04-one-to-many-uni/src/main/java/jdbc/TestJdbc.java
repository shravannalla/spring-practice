package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        String user="hbstudent";
        String pass="Shra1@griet";
        try{
            System.out.println("Connecting to jdbc: "+jdbcUrl);
            Connection myConn= DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
