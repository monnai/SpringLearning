package springstudy.demo.test5.service.impl;

import org.springframework.stereotype.Component;
import springstudy.demo.test5.service.CryService;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/3 17:26
 */
@Component
public class CatCryService implements CryService {

  @Override
  public void cry() {
    System.out.println("猫咪哭了 喵喵喵");
  }
}
