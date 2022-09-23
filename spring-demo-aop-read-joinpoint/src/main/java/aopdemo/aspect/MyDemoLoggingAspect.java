package aopdemo.aspect;

import aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
