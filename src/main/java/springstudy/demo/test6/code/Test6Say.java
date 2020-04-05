package springstudy.demo.test6.code;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 10:26
 */
//@Component
public class Test6Say {

  public void say() throws Exception {
    System.out.println("这是test6的say 666");
      throw new Exception("随便的exception");
  }
}
