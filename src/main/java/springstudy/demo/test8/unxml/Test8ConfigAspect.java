package springstudy.demo.test8.unxml;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/9 09:57
 */
@Aspect
@Component
public class Test8ConfigAspect {

  @Before("pointCutExpression()")
  void say() {
    System.out.println("before ...");
  }
   @After("pointCutExpression()")
  void after() {
    System.out.println("after ...");
  }

  @Around("pointCutExpression()")
  //踩坑：@Around的时候需要手动调用方法执行
  void around(ProceedingJoinPoint invocation) throws Throwable {
    System.out.println("around before...");
    invocation.proceed();
    System.out.println("around after...");

  }
  @AfterReturning("pointCutExpression()")
  void afterReturning() {
    System.out.println("after returning ...");
  }

  @Pointcut("execution(public void springstudy.demo.test8.unxml.Test8Config.say(..))")
  void pointCutExpression() {

  }
}

