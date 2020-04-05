package springstudy.demo.test5.service.impl;

import org.springframework.stereotype.Component;
import springstudy.demo.test5.service.CryService;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/3 17:25
 */
@Component
public class DogCryService implements CryService {

  @Override
  public void cry() {
    System.out.println("狗狗哭了 汪汪汪");
  }
}
