package com.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component

// writing Point cut as another method
public class CurrencyServiceAspect {

    @Pointcut("@annotation(com.demo.annotations.InTransaction)")
    public void transactionAnnotationPointcut() {

    }

    //@Before("transactionAnnotationPointcut()")
    public void beforeTransactionAnnotationAdvice(JoinPoint joinPoint) {
        System.out.println("beforeTransactionAnnotationAdvice : " + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs())
        );
    }



    @Pointcut("within(com.demo.bls.*)")
    public void blsPackagePointcut() {

    }

    //@Before("blsPackagePointcut()")
    public void beforeBlsPackagePointcut(JoinPoint joinPoint) {
        System.out.println("beforeBlsPackagePointcut : " + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs())
        );
    }

    @Pointcut("@within(com.demo.annotations.Secured)")
    public void securedClassPointcut() {

    }

    //@Before("securedClassPointcut()")
    public void beforeSecuredClassPointcut(JoinPoint joinPoint) {
        System.out.println("beforeSecuredClassPointcut : " + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs())
        );
    }


    @Pointcut("bean(currency_service)")
    public void namedBeanPointcut() {

    }

    //@After("namedBeanPointcut()")
    public void afterNamedBeanAdvice(JoinPoint joinPoint) {
        System.out.println("afterNamedBeanAdvice : " + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs())
        );
    }



    @Pointcut("execution(* com.demo.bls.CurrencyService.getExchangeRate(..))")
    public void getExchangeRateMethodPointcut() {

    }

    //@Around("getExchangeRateMethodPointcut()")
    public Object aroundGetExchangeRateMethodAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before : aroundGetExchangeRateMethodAdvice" + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs()));

        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("After : aroundGetExchangeRateMethodAdvice");
        }
    }



    @Pointcut("args(String, String, int )")
    public void stringIntegerArgumentsMethodPointcut() {

    }

    //@After("stringIntegerArgumentsMethodPointcut()")
    public void afterStringAndIntegerArgumentsMethodPointcut(JoinPoint joinPoint) {
        System.out.println("After : afterStringAndIntegerArgumentsMethodPointcut" + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs()));
    }




    @Pointcut("@args(com.demo.annotations.Validated)")
    public void validatedArgumentPointcut() {

    }

    //@After("validatedArgumentPointcut()")
    public void afterValidatedArgumentAdvice(JoinPoint joinPoint) {
        System.out.println("After : afterValidatedArgumentPointcut" + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs()));
    }



    @Pointcut("@target(com.demo.annotations.Secured)")
    public void currencyServiceSecuredTargetPointcut() {

    }

    //@After("currencyServiceSecuredTargetPointcut()")
    public void afterCurrencyServiceTarget(JoinPoint joinPoint) {
        System.out.println("After : afterCurrencyServiceTarget" + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs()));
    }

    // Why point cut method using?
    @Pointcut("blsPackagePointcut() && transactionAnnotationPointcut()")
    public void blsPackageAndInTransactionPointcut() {

    }

    //@After("blsPackageAndInTransactionPointcut()")
    public void afterBlsPackageAndInTransactionAdvice(JoinPoint joinPoint) {
        System.out.println("After : afterBlsPackageAndInTransactionAdvice : " + joinPoint.getSignature()
                + " is invoked with " + Arrays.toString(joinPoint.getArgs()));
    }


    //@AfterThrowing(value = "execution(* com.demo.bls.CurrencyService.getCurrencyCountryName(..))", throwing = "exception")
    public void afterThrowingException(Exception exception) {
        System.out.println("Exception was thrown from getCurrencyCountryName : " + exception.getClass().getSimpleName());
    }


    @AfterReturning(value = "execution(* com.demo.bls.CurrencyService.getCurrencyCountryName(..))", returning = "value")
    public void afterReturningAdvice(String value) {
        System.out.println("Value returned from getCurrencyCountryName : " + value);
    }


}
