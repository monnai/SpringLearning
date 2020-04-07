package springstudy.demo.test7.advice;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/6 16:55
 */
public class MyAdvice implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] objects, Object o) throws Throwable {
    System.out.println("wash hand ......");
  }
}
