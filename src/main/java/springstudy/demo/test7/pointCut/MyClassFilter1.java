package springstudy.demo.test7.pointCut;

import org.springframework.aop.ClassFilter;
import springstudy.demo.test7.service.serviceImpl.Person;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/6 18:08
 */
public class MyClassFilter1 implements ClassFilter {

  //踩坑呀：
  /*
  wash hand ......
person eat...
person say...
21:59:52.854 [main] DEBUG org.springframework.aop.framework.ProxyFactoryBean - Advice has changed; recaching singleton instance
21:59:52.854 [main] DEBUG org.springframework.aop.framework.ProxyFactoryBean - Advice has changed; recaching singleton instance
dog eat ...
dog say ...
开始的时候直接写的return null
导致没有类能够进行匹配，没能出来
   */
  @Override
  public boolean matches(Class<?> aClass) {
    return aClass == Person.class;
  }
}
