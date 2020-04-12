package springstudy.demo.test9.service;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/9 16:25
 */
public interface PayService {

  /*
     测试事务用
     谁给谁转多少钱
   */
  boolean pay(String from, String to, int money);
}
