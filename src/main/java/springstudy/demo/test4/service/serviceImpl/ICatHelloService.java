package springstudy.demo.test4.service.serviceImpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springstudy.demo.test4.service.CatHelloService;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/3 11:03
 */
//@Component
//@Primary
public class ICatHelloService implements CatHelloService {

  @Override
  public void say() {
    System.out.println("猫咪修改后的叫声");
  }
}
