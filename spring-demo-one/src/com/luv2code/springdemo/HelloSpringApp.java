package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrive bean from spring container
        Coach theCoach=context.getBean("myCoach", Coach.class);
        //call methods on bean
        System.out.println(theCoach.getDailyWorkOut());

        //call new methods
        System.out.println(theCoach.getDailyFortune());
        //close
        context.close();
    }
}
