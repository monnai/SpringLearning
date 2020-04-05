package springstudy.demo.test4.service.serviceImpl;

import springstudy.demo.test4.service.DogHelloService;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/3 11:05
 */
public class IDogHelloService implements DogHelloService {

  @Override
  public void say() {
    System.out.println("狗狗修改后的叫声，汪汪汪");
  }
}
