package springstudy.demo.test6.test;

import javax.swing.text.html.HTML.Tag;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springstudy.demo.test6.codeXml.MyBeforeTarget;
import springstudy.demo.test6.proxy.MyProxyCglib;
import springstudy.demo.test6.proxy.NormalSay;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 18:33
 */
public class testMainCg {

  @Test
  public void test1() {
    NormalSay instance = MyProxyCglib.getInstance();
    String cgcgcg = instance.say("cgcgcg");
    System.out.println(cgcgcg);
  }

  /*
  脑图： 自定义target类有say()
        自定义targetBefore 实现了MethodBeforeAdvice 重写before 指定在前面做什么
        target放入ioc targetBefore放入ioc
        定义ProxyFarctoryBean的bean，属性注入以上两个 ，注入属性target和interceptorNames
        测试时，获取代理对象，能实现before效果

        注解实现相同功能 将两个类放到ioc管理  弄一个配置类 配置PorxyFactoryBean
        缺点：不灵活，这种配置一个before 所有的方法就都before了而且after没有还要配置很多个
   */




  @Test
  public void test2() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config-aspect.xml");
    MyBeforeTarget target = (MyBeforeTarget) ctx.getBean("springProxy");
    target.targetSay();
  }
}
