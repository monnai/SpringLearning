package springstudy.demo.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 自定义bean后置处理器 有几个bean执行几次
 * todo 这个后置处理器有问题，使用它后静态工厂初始化bean失败
 */
//@Component
public class MyBeanPostProfessor implements BeanPostProcessor {

  private static int modCount = 1;
  private static int modCount1 = 1;

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    System.err.println("do before" + modCount++ + "time" + "beanName:" + beanName);
    //如果是Person类，返回代理对象
    ClassLoader classLoader = bean.getClass().getClassLoader();
    Class<?>[] interfaces = bean.getClass().getInterfaces();
    System.err.println(classLoader);
    InvocationHandler handler = new InvocationHandler() {
      //todo method.invoke后方法不能正常调用
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //输出一个打印
        //变更一下say的大小写
        return method.invoke(proxy,args);
      }
    };
    //todo 尝试三种获取类的方法
    Object proxyInstance = Proxy.newProxyInstance(classLoader, interfaces, handler);
    return proxyInstance;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.err.println("do After" + modCount1++ + "time" + "beanName:" + beanName);
    return bean;
  }
}
