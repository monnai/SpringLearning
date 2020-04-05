package springstudy.demo.test4.service;

/**
 * 打招呼
 */
public interface HelloService {
  //踩坑：测试default是不是子类可以不实现还能打印
  default void say() {
    System.out.println("默认say");
  }
}
