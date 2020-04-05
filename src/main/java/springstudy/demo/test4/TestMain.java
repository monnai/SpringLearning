package springstudy.demo.test4;

import javax.annotation.PostConstruct;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import springstudy.demo.test4.service.HelloService;
import springstudy.demo.test4.service.serviceImpl.ICatHelloService;

/**
 * 1.体会一下@primary 2.使用BeanPostProcessor优化代码 3.自己手写BeanPostProcessor
 */
@Component
public class TestMain {

  /**
   * 踩坑 :
   *
   * @Autowired @Resource Qualifier
   * @Autowired按byType自动注入，而@Resource默认按 byName自动注入罢了
   */
  //踩坑：静态能注入进去吗
  @Autowired
  //踩坑：@Resource 不支持静态
  public static HelloService helloService;
  //  @Autowired xml配置
  public HelloService helloService1;

  //问题：@postConstruct什么时候起作用？
  @PostConstruct
  void set() {
    helloService = helloService1;
  }

  //解决没有setter的问题：

  public void setHelloService1(HelloService helloService1) {
    this.helloService1 = helloService1;
  }

  @Test
  public void test1() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config.xml");
//    test helloService = (test) ctx.getBean("test");
//    helloService.helloService.say();
    //批注：第一次ioc中没有HelloService的实现类，所以空指针了
    //批注2：第二次cat加上了@Component依然空指针。。？
   /* ICatHelloService cat = (ICatHelloService) ctx.getBean(ICatHelloService.class);
    cat.say();*/
    //打印出了猫咪修改后的叫声 说明ioc里面有了cat
    //踩坑：static属性是输入类的，springioc一般是管理的对象实例，所以操作不了，尝试一下网上方法
    helloService.say();
    //成功输出了猫咪的叫声，利用普通的@Autowired进行DI注入，然后利用@PostConstruct进行增强
  }

  @Test
  public void test2() {
    ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
        "spring-config.xml");
    TestMain TestMain = (springstudy.demo.test4.TestMain) ctx.getBean("testMain");
    //idea一般实例调用静态属性不会提示
    TestMain.helloService.say();
    //xml里面有test
    //test的属性利用类型自动注入
    //加上setter后  输出猫咪修改后的叫声
    //自动装配//名称
  }

  //划重点：现在HelloService利用的方式配置 testMain bean的时候 按照类型自动注入有两个相同类型的bean
  // ICatHelloService zhu注解注入的   helloService1 xml注入的 利用@Primary后能将ICatHelloService成功注入
  //现在到了今天的重点,利用自定义后置处理器进行增强处理

  @Test
  public void test3() {

  }


}

//踩坑： 内部类 和类嵌套能使用junit吗？不能。。
/*class test1 {

  @Test
  public void test1() {
    System.out.println(1);
  }

}*/
