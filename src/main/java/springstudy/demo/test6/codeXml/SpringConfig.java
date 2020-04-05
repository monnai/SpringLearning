package springstudy.demo.test6.codeXml;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 22:32
 */
@Configuration
public class SpringConfig {

  @Autowired
  MyBeforeTarget myBeforeTarget;

  @Autowired
  MyBeforeXml myBeforeXml;

  @Bean
  MyBeforeTarget myBeforeTarget() {
    return new MyBeforeTarget();
  }

  @Bean
  MyBeforeXml myBeforeXml() {
    return new MyBeforeXml();
  }

  @Bean
  ProxyFactoryBean springProxy() {
    ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
    proxyFactoryBean.setTarget(myBeforeTarget);
    proxyFactoryBean.setInterceptorNames("myBeforeXml");
    return proxyFactoryBean;
  }
}
