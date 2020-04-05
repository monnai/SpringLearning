package springstudy.demo.test1;

import java.math.BigDecimal;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/4/1 15:38
 */
public class test {

  @Test
  public void test1() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config.xml");
    Person myPersonStatic = (Person) ctx.getBean("myPersonStatic");
    System.out.println(myPersonStatic.toString());
    Person myPersonInstance = (Person) ctx.getBean("myPersonInstance");
    System.out.println(myPersonInstance.toString());
  }

  /**
   * <踩坑>
   * 浮点类型数字精确计算： 转换为String后利用BigDecimal
   */
  @Test
  public void test2() {
    System.out.println(new BigDecimal(0.1));
  }
}
