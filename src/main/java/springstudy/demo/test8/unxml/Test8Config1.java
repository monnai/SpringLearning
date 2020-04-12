package springstudy.demo.test8.unxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springstudy.demo.test8.Hair;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/8 20:55
 */
@Configuration
public class Test8Config1 {

  @Bean
   Hair hair1() {
   return new Hair();
  }

  void say() {
    System.out.println(123);
  }
}
