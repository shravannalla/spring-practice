package aopdemo.aspect;

import aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        //print out which method we are advicing on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @Afterreturning on method: "+method);

        //print out the results of the method call
        System.out.println("\n====>>> result is: "+result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>> result is: "+result);

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
        System.out.println("\n====>>> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSig=(MethodSignature) theJoinpoint.getSignature();

        System.out.println("Method: "+methodSig);

        //display the method arguments

        //get the arguments
        Object[] args= theJoinpoint.getArgs();

        //loop thru arguments
        for(Object tempArgs:args){
            System.out.println(tempArgs);

            if(tempArgs instanceof Account){
                //downcast and print account specific stuff
                Account theAccount=(Account) tempArgs;
                System.out.println("account name: "+theAccount.getName());
                System.out.println("account level: "+theAccount.getLevel());
            }
        }



    }


}
