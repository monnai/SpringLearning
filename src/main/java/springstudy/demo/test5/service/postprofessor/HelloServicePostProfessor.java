package springstudy.demo.test5.service.postprofessor;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import springstudy.demo.test5.factory.RoutingBeanProxyFactory;
import springstudy.demo.test5.service.CryService;
import springstudy.demo.test5.service.annotation.RountingRejected;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/3 21:26
 */
@Component
public class HelloServicePostProfessor implements BeanPostProcessor {

  @Autowired
  private ApplicationContext applicationContext;

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
     //todo 这里不行啊，困了，明天弄 2020-04-04修复完成
  @Override
  //批注 ：在springioc容器初始化所有bean之后，执行
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    //获取ioc中的test5bean
    Class<?> clazz = bean.getClass();
    //获取test5的类 springstudy.demo.test5.Test5
    Field[] fields = clazz.getDeclaredFields();
    //获取test5类的所有属性
    for (Field field : fields) {
      //筛选bean的属性中 自定义注解标记的
      if (field.isAnnotationPresent(RountingRejected.class)) {
        //踩坑：getType返回这个属性的类 类.getClass返回java.lang.class
        Class<?> clazz1 = field.getType();
        if (!clazz1.isInterface()) {
            throw new BeanCreationException("这不是接口啊");
            //踩坑:如果throw在try里面，后面的继续执行
          }
        try {
          //进行处理 将bean中的属性根据注解value的要求，从ioc容器中找出后 进行绑定
          this.handleRoutingInjected(field, bean);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        }
      }

    }
    return bean;
  }

 /* public static void main(String[] args) {
    HashMap hashMap = new HashMap();
    hashMap.put("haha", "1212");
    hashMap.put("hehe", "2323");
    //踩坑：如果是定义迭代器了，next能走到下一个
    //如果仅仅是hashMap.entrySet().interator().next();永远是1212
    Iterator next = hashMap.entrySet().iterator();
    while (next.hasNext()) {
      Map.Entry<String, String> next1 = (Entry<String, String>) next.next();
      String key = next1.getKey();
      String value = next1.getValue();
      System.out.println(key + " " + value);
    }
  }*/
  //问题：CryService不是一个接口？？
 public static void main(String[] args) {
   boolean anInterface = CryService.class.isInterface();
   System.out.println(anInterface);
 }
  //找到ico容器中两个
  private void handleRoutingInjected(Field field, Object bean) throws IllegalAccessException {
    Map<String, Object> candidates = this.applicationContext.getBeansOfType((Class<Object>) field.getType());
    field.setAccessible(true);
    if (candidates.size() == 1) {
      field.set(bean, candidates.entrySet().iterator().next());
    }
    /*else if (candidates.size() == 2) {
      //注解里面的value
      String injectVal = field.getAnnotation(RountingRejected.class).value();
     Object proxy =  RoutingBeanProxyFactory.createProxy(injectVal, field.getType(), candidates);
     field.set(bean,proxy);
    } else {
      throw new IllegalArgumentException("不能有两个以上标记的" + field.getType());
    }*/
    else {
      //注解的value
      String injVal = field.getAnnotation(RountingRejected.class).value();
      Object proxy = RoutingBeanProxyFactory.createProxy(injVal, field.getType(), candidates);
      field.set(bean,proxy);
    }
  }
  //代理工厂

}
