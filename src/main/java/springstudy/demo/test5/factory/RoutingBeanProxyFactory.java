package springstudy.demo.test5.factory;

import java.util.Map;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description
 * todo 代理模式的学习
 * 明天学习尚硅谷的代理模式视频：
 * cglib jdk spring 三种代理模式
 * @Auther gu.sc
 * @Date 2020/4/3 22:28
 */
public class RoutingBeanProxyFactory {

  private final static String DEFAULT_BEAN_NAME = "helloServiceImpl";

  public static Object createProxy(String name, Class type, Map<String, Object> candidates) {
    ProxyFactory proxyFactory = new ProxyFactory();
    proxyFactory.setInterfaces(type);
    proxyFactory.addAdvice(new VersionRoutingMethodInterceptor(name, candidates));
    return proxyFactory.getProxy();
  }

  static class VersionRoutingMethodInterceptor implements MethodInterceptor {
    private Object targetObject;

    public VersionRoutingMethodInterceptor(String name, Map<String, Object> beans) {
      this.targetObject = beans.get(name);
      if (this.targetObject == null) {
        this.targetObject = beans.get(DEFAULT_BEAN_NAME);
      }
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
      return invocation.getMethod().invoke(this.targetObject, invocation.getArguments());
    }
  }
}

