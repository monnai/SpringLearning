package springstudy.demo.test1;

/**
 * 静态工厂模式创建bean
 */
public class PersonFactoryStatic {

  private static Person person = new Person();

  static Person getInstance() {
    return person;
  }

  static {
    person.setAge(26);
  }
}
