package springstudy.demo.test1;

/**
 * 实例工厂方法创建bean
 */
public class PersonFactoryInstance {

  private static Person person = new Person();

  private Person getInstance(){
    return this.person;
  }
}
