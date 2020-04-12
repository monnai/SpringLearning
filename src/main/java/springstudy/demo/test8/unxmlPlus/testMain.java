package springstudy.demo.test8.unxmlPlus;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springstudy.demo.test8.Hair;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/8 20:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Test8Config.class)
public class testMain {

//  @Before
//  public void propare() {
//    System.out.println(12455);
//  }

  @Resource(name = "hair1")
  private Hair hair1;

  @Autowired
  Test8Config bean;

  @Autowired
  Test8Config1 bean1;

  @Test
  public void test1() {
    //构造器：
//    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("springstudy");
//    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
//        Test8Config.class);
//    Hair hair1 = (Hair) ctx.getBean("hair1");
    System.out.println(hair1);
//    Test8Config bean = ctx.getBean(Test8Config.class);
    bean.say();
//    Test8Config1 bean1 = ctx.getBean(Test8Config1.class);
    bean1.say();
    //无论我这个配置类加不加@configuation hair都能ioc test8config也都有？？？
    //用一个configuation启动后，其他的@configuation不加载

    //踩坑：类构造器初始化，可不加@configuation也能正常
    //扫描路径配置必须加@configuation
    //@bean必须和@configuation配合使用
  }
}
