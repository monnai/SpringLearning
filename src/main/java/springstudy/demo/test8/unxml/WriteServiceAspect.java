package springstudy.demo.test8.unxml;

import jdk.nashorn.internal.ir.JoinPredecessor;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/9 11:42
 */
public class WriteServiceAspect {

  public void log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("日志。。。");
    proceedingJoinPoint.proceed();
    System.out.println("log ...");
  }
}
