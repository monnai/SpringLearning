package springstudy.demo.test8.unxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import springstudy.demo.test8.Hair;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/8 20:55
 */
@Configuration
//将另一个作为次要配置类引入，也可以写多个@configuation
@Import(value = {Test8Config1.class})
//不臊面的话其他注解扫不进去
@ComponentScan(basePackages={"springstudy"})
public class Test8Config {

  @Bean
  Hair hair1() {
    return new Hair();
  }

/*  @Bean
  Test8ConfigAspect test8ConfigAspect() {
    //问题：是不是纯注解配置相当于只配置了bean 没有配置aop切面？？？
    return new Test8ConfigAspect();
  }*/

  public void say() {
    System.out.println(123);
  }
}
