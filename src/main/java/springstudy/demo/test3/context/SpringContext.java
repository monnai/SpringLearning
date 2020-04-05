package springstudy.demo.test3.context;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;
import springstudy.demo.test3.annotation.IocResource;
import springstudy.demo.test3.annotation.IocService;
import springstudy.demo.test3.util.ClassUtil;

/**
 * @description: 模拟spring容器
 * @auther: gu.sc
 * @date: 2020/4/1 22:33
 */
public class SpringContext {

  private String path;
  private static ConcurrentHashMap<String, Object> initBean = null;

  public SpringContext(String path) {
    this.path = path;
  }

  /**
   * 根据beanId初始化bean
   */
  public Object getBean(String beanId) throws Exception {
    List<Class> classes = findAnnotationService();
    if (classes == null || classes.isEmpty()) {
      throw new Exception("not found anything bean is useding initial");
    }
    initBean = initBean(classes);
    if (initBean == null || initBean.isEmpty()) {
      throw new Exception("initial bean is empty or null");
    }
    Object object = initBean.get(beanId);
    initAttribute(object);
    return object;
  }

  /**
   * 初始化依赖的属性
   */
  private void initAttribute(Object object) throws Exception {
    Class<?> classInfo = object.getClass();
    Field[] fields = classInfo.getDeclaredFields();
    for (Field field : fields) {
      boolean flag = field.isAnnotationPresent(IocResource.class);
      if (flag) {
        IocResource iocResource = field.getAnnotation(IocResource.class);
        if (iocResource != null) {
          String beanId = field.getName();
          Object attrObject = getBean(beanId);
          if (attrObject != null) {
            field.setAccessible(true);
            field.set(object, attrObject);
          }
        }
      }
    }
  }

  private ConcurrentHashMap<String, Object> initBean(List<Class> classes)
      throws IllegalAccessException, InstantiationException {
    ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
    String beanId;
    for (Class clazz : classes) {
      Object object = clazz.newInstance();
      IocService annotation = (IocService) clazz.getDeclaredAnnotation(IocService.class);
      if (annotation != null) {
        String value = annotation.name();
        if (!value.equalsIgnoreCase("")) {
          beanId = value;
        } else
          beanId = toLowerCaseFirstOne(clazz.getSimpleName());
        map.put(beanId, object);
      }
    }
    return map;
  }

  /**
   * 首位转换小写
   */
  private String toLowerCaseFirstOne(String simpleName) {
    if (Character.isLowerCase(simpleName.charAt(0))) {
      return simpleName;
    } else {
      return String.valueOf(Character.toLowerCase(simpleName.charAt(0))) + simpleName.substring(1);
    }
  }


  //踩坑 test的类必须只能有一个public的无参构造器
  @Test

  public void test22() {
    System.out.println(1);
//    UserService userService = new UserService();
//    initAttribute(userService);
  }


  //ctrl alt b 查看接口实现类
  //alt 7 左侧查看类方法
  //ctrl alt h 方法调用树
  //ctrl alt f7 变量在哪里调用
  //自动生成not null
  private List<Class> findAnnotationService() throws Exception {
    if (path == null || path.equals("")) {
      throw new Exception("扫描包不可为空");
    }
    List<Class<?>> classes = ClassUtil.getClasses(path);
    if (classes == null || classes.size() == 0) {
      throw new Exception("该包下没有@iocservice的类");
    }
    ArrayList<Class> annotationClass = new ArrayList<>();
    for (Class clazz : classes) {
      IocService iocService = (IocService) clazz.getDeclaredAnnotation(IocService.class);
      if (iocService != null) {
        annotationClass.add(clazz);
      }
    }
    return annotationClass;
  }

}
