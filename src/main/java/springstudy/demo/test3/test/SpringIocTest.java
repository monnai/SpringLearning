package springstudy.demo.test3.test;

import org.junit.Test;
import springstudy.demo.test3.context.SpringContext;
import springstudy.demo.test3.service.impl.UserService;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/4/1 22:35
 */
public class SpringIocTest {

  //  springstudy.demo.test3
  @Test
  public void test1() throws Exception {
    String path = "springstudy.demo.test3";
    SpringContext ctx = new SpringContext(path);
    UserService userService = (UserService) ctx.getBean("userbiz");
    System.out.println(userService.findOrder("lyl"));
  }
}
