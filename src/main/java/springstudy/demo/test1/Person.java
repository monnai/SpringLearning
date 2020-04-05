package springstudy.demo.test1;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/4/1 15:39
 */
public class Person {

  private int age;
  public void say(){
    System.out.println("好烦啊！！！");
  }

  @Override
  public String toString() {
    return "Person{" +
        "age=" + age +
        '}';
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
