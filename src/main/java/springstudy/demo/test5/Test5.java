package springstudy.demo.test5;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import springstudy.demo.test5.service.CryService;
import springstudy.demo.test5.service.annotation.RountingRejected;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/3 21:20
 */
@Component
public class Test5 {


  @RountingRejected(value = "catCryService")
  private CryService cryService;

  @Test
  public void test() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config.xml");
    Test5 bean = ctx.getBean(Test5.class);
    bean.cryService.cry();
  }
}
