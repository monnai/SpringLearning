package springstudy.demo.test6.proxy;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/5 11:28
 */
public class NormalSay implements Say{

  private String message;

  public String say(String message) {
    this.message = message;
    System.out.println("最普通的say");
    return this.message;
  }

}
