package springstudy.demo.test9;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springstudy.demo.test9.service.PayService;
import springstudy.demo.test9.service.dao.PayDao;
import springstudy.demo.test9.service.serviceImpl.PayServiceImpl;
import springstudy.demo.test9.service.serviceImpl.PayServicePlusImpl;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/9 16:10
 */
@ContextConfiguration(locations = "classpath:spring-config-tx.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class testMain {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Test
  public void test1() {
    System.out.println(jdbcTemplate.update(" update ceshi1 set xx = 1 "));
  }

/*
  public void test2() {
    //spring jdbc提供
    DataSourceTransactionManager datasource = new DataSourceTransactionManager();
  }*/

  @Autowired
  PayServiceImpl payService;
  @Autowired
  PayDao payDao;

  @Test
  public void test2() {

    boolean pay = payService.pay("顾寿辰", "曹雅婷", 1000);
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

  @Autowired
  private PayServicePlusImpl payPlus;

  @Test
  public void F() {
    payPlus.payPlus();
  }

  @Test
  public void G() {
    payService.paylog();
  }

  //  测试同一个service
  /*@Test
  public void G() {
    payService.payPlus();
  }*/
  @Test
  public void H() {
    payPlus.payPlus1();
  }
}
