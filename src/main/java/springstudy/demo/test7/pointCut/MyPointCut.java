package springstudy.demo.test7.pointCut;

import java.lang.reflect.Method;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/6 17:33
 */
public class MyPointCut implements Pointcut {

  private ClassFilter classFilter;
  private MethodMatcher methodMatcher;

  public void setClassFilter(ClassFilter classFilter) {
    this.classFilter = classFilter;
  }

  public void setMethodMatcher(MethodMatcher methodMatcher) {
    this.methodMatcher = methodMatcher;
  }

  //筛选类
  @Override
  public ClassFilter getClassFilter() {
    return this.classFilter;
  }

  //筛选类中的方法
  @Override
  public MethodMatcher getMethodMatcher() {
    return this.methodMatcher;
  }

  //内部类能是public的，不然private的外面无法调用
 /* public static class MyClassFilter implements ClassFilter {

    @Override
    public boolean matches(Class<?> aClass) {
      if (aClass == Person.class) {
        return true;
      }
      return false;
    }
  }*/

  public class MyMethodMatcher implements MethodMatcher {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
      return "eat".equalsIgnoreCase(method.getName());
    }

    @Override
    public boolean isRuntime() {
      return false;
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
      return false;
    }
  }


}
