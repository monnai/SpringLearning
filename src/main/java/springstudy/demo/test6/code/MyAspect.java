package springstudy.demo.test6.code;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 09:54
 */
//踩坑：spring使用aop需要aop相关包 ，springboot使用需要starter
/*
   相关概念：
   Aspect 切面：一个类，定义切入点和通知
   JoinPoint 连接点 一般指目标的方法比如一个数据库操作add()
   Pointcut  切入点 比如用切点表达式切入了add()方法后 ，这就是一个切入点
   Advice  通知 有before after afterReturning afterThrowing around
   Aop代理 springaop能有两种 cglib和jdk方法
 */

@Aspect
public class MyAspect {

  //定义切点
  @Pointcut("execution(public void springstudy.demo.test6.code.Test6Say.*(..))")
  private void pointCut() {

  }

  //踩坑：通知语法怎么写？value->指向pointCut 也就是通知切入到哪个点
  @Before("pointCut()")
  void before() {
    System.out.println("before...");
  }

  @After("pointCut()")
  void after() {
    System.out.println("after...");
  }

  @AfterReturning("pointCut()")
  void afterReturning() {
    System.out.println("after returning...");
  }

  @AfterThrowing("pointCut()")
    //踩坑：如果切点方法中抛出的异常在自己方法中处理了
    //那么异常存在于方法里面不会暴露给外面
    //不会被afterReturning捕捉到，afterThrowing不执行
  void afterThrowing() {
    System.out.println("after throwing...");
  }

}
