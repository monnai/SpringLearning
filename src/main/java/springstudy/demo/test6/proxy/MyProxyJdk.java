package springstudy.demo.test6.proxy;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 11:20
 */
public class MyProxyJdk {

  private static final NormalSay normalSay = new NormalSay();
  //这个注解的相当宝贵：出现了invoke循环调用问题
 /* public Object getInstance() {
    Class<?>[] interfaces = NormalSay.class.getInterfaces();
    //这个写的有问题：代理的时候一直报错误，invoke一直调用而且栈溢出
    //查阅相关文章后发现 invocation实例中的method.invoke里面的toString()方法其实调用invocationHandler的invoke()方法
    //导致了循环调用，不停的输出语句。那么如何解决呢
    Object o = Proxy
        .newProxyInstance(normalSay.getClass().getClassLoader(), NormalSay.class.getInterfaces(),
            (proxy, method, args) -> {
//              System.out.println("jdk的代理模式开始处理");
              try {
                System.out.println("ssss");
                Object invoke = method.invoke(proxy, args);
              } catch (IllegalAccessException e) {
                e.printStackTrace();
              } catch (IllegalArgumentException e) {
                e.printStackTrace();
              } catch (InvocationTargetException e) {
                throw e.getCause();
              }
              return proxy;
            });
    return o;
    //Method threw 'java.lang.reflect.UndeclaredThrowableException' exception. Cannot evaluate com.sun.proxy.$Proxy4.toString()
  }*/

  public static void main(String[] args) {
    Class<?>[] interfaces = NormalSay.class.getInterfaces();
    System.out.println(interfaces);
  }
  //踩坑：一般一个类的成员变量能够不初始化，类加载的时候会初始化为默认值 但是final修饰的就必须在构造器结束之前初始化好
  /*  private final int a;*/
//  {a = 2;}

/*
  public MyProxyJdk(int a) {
    this.a = a;
  }
*/

  //踩坑：final修饰的
/*
  static {
//    final String o = (String) new Object();
//    o+="23"; 对象不可变
    final ArrayList a = new ArrayList();
    a.add("23");
    System.out.println(a.toString());
    //踩坑：  final的对象不能变更指向
//    normalSay = new NormalSay();
  }
*/

  /*
    void test2() {
      test(2);
    }

    void test(final int c) {
  //    c++; 踩坑:final修饰的不可变
      final int a = 2;
    }*/
  //代理模式是提供一个对象还是注解把结果运行了？？
  public Say getInstance()
      throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
   /* Object o = Proxy.newProxyInstance(normalSay.getClass().getClassLoader(),
        normalSay.getClass().getInterfaces(), (proxy, method, args) -> null);
    return o;*/
   //问题分析：为什么不能转成NormalSay？ 因为面向接口编程，->Say 在ProxyClass的时候已经生成为Say的proxy了，接口不能往下面转
    Class<?> proxyClass = Proxy.getProxyClass(Say.class.getClassLoader(), new Class[]{Say.class});
    Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
    Object o = constructor.newInstance(new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        return null;
        Object invoke = method.invoke(normalSay, args);
        return invoke;
      }
    });
    //todo 问题：为什么invoke里面什么都不做，返回的代理对象是null？
    return (Say) o;

  }
}
