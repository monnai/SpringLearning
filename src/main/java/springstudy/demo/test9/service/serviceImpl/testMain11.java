/*
package springstudy.demo.test9.service.serviceImpl;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springstudy.demo.test9.service.dao.PayDao;

*/
/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/9 16:10
 *//*

@ContextConfiguration(locations = "classpath:spring-config-tx.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class testMain11 {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Test
  public void test1() {
    System.out.println(jdbcTemplate.update(" update ceshi1 set xx = 1 "));
  }

*/
/*
  public void test2() {
    //spring jdbc提供
    DataSourceTransactionManager datasource = new DataSourceTransactionManager();
  }*//*


  @Autowired
  PayServiceImpl payService;
  @Autowired
  PayDao payDao;

  @Test
  public void test2() {

    boolean pay = payService.pay("顾寿辰", "曹雅婷", 1000,1);
  }

  @Test
  public void d() {
    BigDecimal 顾寿辰 = payDao.getMoneyByUserName("顾寿辰");
    System.out.println(顾寿辰);
  }
  @Test
  public void E() {
     payService.TestIsolation();
  }

}
*/
