package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {

        //read spring config file
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(SportConfig.class);
        //get the b ean from spring container
        SwimCoach theCoach=context.getBean("swimCoach", SwimCoach.class);
        //call a method on bean
        System.out.println(theCoach.getDailyWorkout());
        //call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        //call our new swim coach methods
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());
        //close the context
        context.close();
    }
}
