package springstudy.demo.test6.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 10:29
 */
@Configuration
public class MyConfiguation {

  //踩坑 :is there an unresolvable circular reference 循环注入
  //分析：spring本身是有构造器注入的，从ioc中找到test6Say
  //循环注入是以上的基础上，将自己又注入到参数里。。。what？
  //todo 循环注入详解：
  /*
  bean的生命周期：
  new bean
  注入依赖（属性赋值）
  获取bean名称 获取beanfactory实例
  bean定义之前 bean定义之后 bean定义时
  bean销毁时
   */
  //构造器sette r
  //config中autowired是注入不进来的
  /*@Bean
  Test6Say test6Say(Test6Say test6Say) {
    test6Say.say();
    return new Test6Say();
  }*/
  //批注： 这就是注解方式的手动配置bean @component等是自动注入
  @Bean
  Test6Say test6Say() {
    return new Test6Say();
  }

  @Bean
  MyAspect myAspect() {
    return new MyAspect();
  }
}
