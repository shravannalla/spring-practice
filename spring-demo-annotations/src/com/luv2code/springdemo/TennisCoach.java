package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
    //default constructor
    public TennisCoach(){
        System.out.println(">>Inside default constructor");
    }

    //define init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">>Inside doMyStartupStuff method");
    }

    //define my destroy method
    @PreDestroy
    public  void doMyCleanupStuff(){
        System.out.println(">>Inside doMyCleanupStuff method");
    }

    //define a setter method

    /*@Autowired
    public void doSomeCrazyStuff(FortuneService theFortuneService){
        System.out.println(">>Inside doSomeCrazyStuff method");
        fortuneService=theFortuneService;
    }*/

    /*
    @Autowired
    public TennisCoach(FortuneService theFortuneService){
        fortuneService=theFortuneService;
    }
     */
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
