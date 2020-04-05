package springstudy.demo.test5.service.impl;

import javax.xml.bind.SchemaOutputResolver;
import org.springframework.stereotype.Component;
import springstudy.demo.test5.service.CryService;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/4 09:28
 */
@Component
public class ChickenCryService implements CryService {

  @Override
  public void cry() {
    System.out.println("小鸡哭了 喳喳喳");
  }
}
