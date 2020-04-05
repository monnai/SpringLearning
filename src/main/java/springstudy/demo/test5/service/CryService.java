package springstudy.demo.test5.service;

public interface CryService {

  default void cry() {
    System.out.println("默认的哭 ，我太难啦");
  }
}
