package springstudy.demo.test7.service.serviceImpl;

import springstudy.demo.test7.service.Animal;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/6 16:38
 */
public class Dog implements Animal {

  @Override
  public void say() {
    System.out.println("dog say ...");
  }

  @Override
  public void eat() {
    System.out.println("dog eat ...");
  }
}
