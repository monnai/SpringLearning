package springstudy.demo.test6.codeXml;

import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 21:59
 */
//@Component
public class MyBeforeXml implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] objects, Object o) throws Throwable {
    System.out.println("before");
  }
}
