package com.zhangzemin.AspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    /**
     * 前置通知
     */
    @Before("execution(* com.zhangzemin.dao.UserDao.addUser(..))")
    public void before(){
        System.out.println("前置通知...");
    }

    /**
     * 后置通知
     */
    @AfterReturning(value = "execution(* com.zhangzemin.dao.UserDao.addUser(..))",returning = "returnVal")
    public void afterReturning(Object returnVal){
        System.out.println("后置通知..."+returnVal);
    }

    /**
     * 环绕通知
     * @param joinPoint 可用于执行切点的类
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.zhangzemin.dao.UserDao.addUser(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前...");
        Object obj = joinPoint.proceed();
        System.out.println("环绕通知后...");
        return obj;
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* com.zhangzemin.dao.UserDao.addUser(..))",throwing = "e")
    public void afterThrowable(Throwable e){
        System.out.println("出现异常:msg="+e.getMessage());
    }

    /**
     * 最终通知
     */
    @After(value = "execution(* com.zhangzemin.dao.UserDao.addUser(..))")
    public void after(){
        System.out.println("最终通知...");
    }
}
