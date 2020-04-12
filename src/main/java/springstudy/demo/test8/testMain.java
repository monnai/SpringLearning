package springstudy.demo.test8;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/8 17:53
 */
public class testMain {


  @Test
  public void test1() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config-aspect.xml");
    Hair hair = (Hair) ctx.getBean("hair");
    System.out.println(hair.toString());
  }
}
