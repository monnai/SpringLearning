package springstudy.demo.test6.proxy;

import java.lang.reflect.Method;
import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @Description 体验cglib代理模式
 * @Auther gu.sc
 * @Date 2020/4/5 11:20
 */
public class MyProxyCglib {

  private static final NormalSay normalSay = new NormalSay();

  /*
    public String sayWhat(String message) {
      this.message = message;
      System.out.println("我说 ，这是cglib里面的sayWhat");
      return message;
    }*/
  public static NormalSay getInstance() {
    //cglib核心对象
    Enhancer enhancer = new Enhancer();
    //设置父类和methodInvocation
    enhancer.setSuperclass(NormalSay.class);
    enhancer.setCallback(new MethodInterceptor() {
      @Override
      public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object invoke = method.invoke(normalSay, objects);
        return invoke;
      }
    });
    return (NormalSay) enhancer.create();
  }
}
