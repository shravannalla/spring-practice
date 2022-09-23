package aopdemo.aspect;

import aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger=Logger.getLogger(getClass().getName());

    @Around("execution(* aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        //print out the method we are advising on
        //print out which method we are advising on
        String method=theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n====>>> Executing @Around on method: "+method);

        //get begin timestamp
        long begin=System.currentTimeMillis();

        //now, let's execute the method
        Object result=null;
        try {
            result=theProceedingJoinPoint.proceed();
        }catch (Exception e){
            //log the exception
            myLogger.warning(e.getMessage());

            //rethrow the exception

            throw e;
        }


        //get end timestamp
        long end=System.currentTimeMillis();

        //compute duration and display it
        long duration=end-begin;
        myLogger.info("\n====>>> Duration: "+duration / 1000.0+"seconds");

        return result;
    }

    @After("execution(* aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        //print out which method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("\n====>>> Executing @After (finally) on method: "+method);

    }

    @AfterThrowing(
                pointcut = "execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
                throwing="theExc")
    public void afterThrowingFindAccountsAdvice(
                    JoinPoint theJoinpoint, Throwable theExc){

        //print out which method we are advising on
        String method=theJoinpoint.getSignature().toShortString();
        myLogger.info("\n====>>> Executing @AfterThrowing on method: "+method);

        //log the exception
        myLogger.info("\n====>>> The exception is: "+theExc);

    }

    @AfterReturning(
            pointcut = "execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        //print out which method we are advicing on
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("\n====>>>> Executing @AfterReturning on method: "+method);

        //print out the results of the method call
        myLogger.info("\n====>>> result is: "+result);

        convertAccountNamesToUpperCase(result);

        myLogger.info("\n====>>> result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for(Account tempAccount: result){
            //get uppercase version of name
            String theUpperName=tempAccount.getName().toUpperCase();

            //update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinpoint){
        myLogger.info("\n====>>> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSig=(MethodSignature) theJoinpoint.getSignature();

        myLogger.info("Method: "+methodSig);

        //display the method arguments

        //get the arguments
        Object[] args= theJoinpoint.getArgs();

        //loop thru arguments
        for(Object tempArgs:args){
            myLogger.info(tempArgs.toString());

            if(tempArgs instanceof Account){
                //downcast and print account specific stuff
                Account theAccount=(Account) tempArgs;
                myLogger.info("account name: "+theAccount.getName());
                myLogger.info("account level: "+theAccount.getLevel());
            }
        }



    }


}
