package springstudy.demo.test7.service.serviceImpl;

import springstudy.demo.test7.service.Animal;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/6 16:27
 */
/*
     批注：本来想在接口中默认实现两个方法 ，然后想通过在子类中改变属性的方式打印出子类想打印的语句，但是interface中的属性
     是public static final的 ，虽然能用接口名.属性的方式得到，可是不能改变
 */
public class Person implements Animal {

  @Override
  public void say() {
    System.out.println("person say...");
  }

  @Override
  public void eat() {
    System.out.println("person eat...");
  }

}
