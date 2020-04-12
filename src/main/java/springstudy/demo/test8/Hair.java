package springstudy.demo.test8;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/8 17:55
 */
public class Hair {

  private Map<String, Object> map;

  private Properties properties;
  public void setMap(Map<String, Object> map) {
    this.map = map;
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  @Override
  public String toString() {
    return "Hair{" +
        "map=" + map +
        ", properties=" + properties +
        '}';
  }
}
