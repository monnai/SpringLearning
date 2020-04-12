package springstudy.demo.test6.test;

import java.lang.reflect.InvocationTargetException;
import javax.print.attribute.HashAttributeSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.logging.ClasspathLoggingApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springstudy.demo.test6.code.Test6Say;
import springstudy.demo.test6.proxy.MyProxyJdk;
import springstudy.demo.test6.proxy.NormalSay;
import springstudy.demo.test6.proxy.Say;
import springstudy.demo.test8.unxml.Test8Config;
import springstudy.demo.test8.unxml.Test8ConfigAspect;
import springstudy.demo.test8.unxml.WriteService;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 09:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Test8Config.class})
public class testMain {

  //spring aop版
  @Test
  public void test1() throws Exception {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config.xml");
    Test6Say test6Say = (Test6Say) ctx.getBean("test6Say");
    test6Say.say();
  }

  //jdk版

  @Test
  public void test2()
      throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    MyProxyJdk myProxyJdk = new MyProxyJdk();
    Say instance = myProxyJdk.getInstance();
    String hahah = instance.say("hahah");
    System.out.println(hahah);
//    NormalSay instance = myProxyJdk.getInstance();
//    String say = instance.say("试一下");
//    System.out.println(say);
//    instance = new NormalSay();
  }

  //复习注解配置aop
  @Autowired
  private Test8Config test8Config;

  @Autowired
//  @Qualifier(value = "test8Config")
  private Test8ConfigAspect test8ConfigAspect;

  @Test
  //注解成功
  public void test3() {
    test8Config.say();
    System.out.println(test8ConfigAspect);
  }

  //使用springtest 利用xml方式实现相同的效果
  @Test
  public void test4() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config-xml-aspect.xml");
    WriteService test8config = (WriteService) ctx.getBean("writeService");
    test8config.write();
  }
}
