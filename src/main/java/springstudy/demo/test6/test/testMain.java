package springstudy.demo.test6.test;

import java.lang.reflect.InvocationTargetException;
import javax.print.attribute.HashAttributeSet;
import org.junit.Test;
import org.springframework.boot.context.logging.ClasspathLoggingApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springstudy.demo.test6.code.Test6Say;
import springstudy.demo.test6.proxy.MyProxyJdk;
import springstudy.demo.test6.proxy.NormalSay;
import springstudy.demo.test6.proxy.Say;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 09:53
 */
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
}
