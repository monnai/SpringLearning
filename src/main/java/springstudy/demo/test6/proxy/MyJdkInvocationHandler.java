package springstudy.demo.test6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 16:30
 */
public class MyJdkInvocationHandler implements InvocationHandler {

  private Say say;

  public MyJdkInvocationHandler(Say say) {
    this.say = say;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return proxy;
  }
}
