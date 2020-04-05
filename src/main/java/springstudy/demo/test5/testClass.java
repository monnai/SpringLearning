package springstudy.demo.test5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/4 09:07
 */
public class testClass {

  private static ArrayList arrayList = new ArrayList();

  /* public static void main(String[] args) {
     Field[] declaredFields = testClass.class.getDeclaredFields();
     Field field = declaredFields[0];
     System.out.println(field.getType());
     System.out.println(field.getType().getClass());
   }*/
 /*public static void main(String[] args) {
   Class<?>[] interfaces = ArrayList.class.getInterfaces();
   System.out.println(ArrayList.class.getInterfaces().toString());
 }*/
  static class Person {

    private int age;
    private List shoes;

    int getAge() {
      return this.age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public List getShoes() {
      return shoes;
    }

    public void setShoes(List shoes) {
      this.shoes = shoes;
    }
  }

  public static void main(String[] args) throws Exception{
    //测试setValue
    Person person = new Person();
    LinkedHashMap<String, Object> valueMap = new LinkedHashMap<>();
    Hashtable map1 = new Hashtable();
    map1.put("age","12");
    map1.put("shoes", "耐克,阿迪达斯,康辉");
    valueMap.putAll(map1);
    setValue(person,Person.class,valueMap);
    System.err.println(person.getAge());
  }

  /*
    valueMap -> keySet
    foreach keySet
    找到当前属性名对应的属性 ->获取属性类型不然都是string
    内循clazz对应的所有方法，为找到setter
    利用setter根据类型进行赋值
   */
  public static void setValue(Object instance, Class clazz, Map<String, Object> valueMap)
      throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
    Method[] declaredMethods = clazz.getDeclaredMethods();
    Set<String> set = valueMap.keySet();
    Iterator<String> iterator = set.iterator();
    while (iterator.hasNext()) {
      String keyName = iterator.next();
      //根据注入名，找到类中的属性
      Field field = clazz.getDeclaredField(keyName);
      for (Method method : declaredMethods) {
        String methodName = method.getName();
        if (methodName.equalsIgnoreCase("set" + keyName)) {
          //找到了setter 进行赋值
          //属性类型
          String type = field.getType().getName();
          switch (type) {
            case "int":
              //踩坑：String->int   integer.praseInt integer.valueOf
              //int->String s+""; String.valueOf() Integer.toString();
              method.invoke(instance, Integer.valueOf((String) valueMap.get(keyName)) );
              break;
            case "java.util.List":
              String o = (String) valueMap.get(keyName);
              String[] values = o.split(",");
              List<String> valueColl = Arrays.asList(values);
              method.invoke(instance, valueColl);
              break;
          }
        }
      }
    }
  }
}
