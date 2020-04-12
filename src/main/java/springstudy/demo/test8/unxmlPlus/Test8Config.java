package springstudy.demo.test8.unxmlPlus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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
//@ComponentScan(basePackages={"springstudy"})
public class Test8Config {

  @Bean
   Hair hair1() {
   return new Hair();
  }

  void say() {
    System.out.println(123);
  }
}
