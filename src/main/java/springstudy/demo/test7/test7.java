package springstudy.demo.test7;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springstudy.demo.test7.service.Animal;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/6 17:00
 */
public class test7 {

  //需求1：拦截dog和person的所有方法，都洗手
  //需求2：只有人 的eat()需要洗手
  @Test
  public void test7() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config7.xml");
    Animal personProxy = (Animal) ctx.getBean("personProxy");
    personProxy.eat();
    personProxy.say();
    Animal dogProxy = (Animal) ctx.getBean("dogProxy");
    dogProxy.eat();
    dogProxy.say();

  }
}
