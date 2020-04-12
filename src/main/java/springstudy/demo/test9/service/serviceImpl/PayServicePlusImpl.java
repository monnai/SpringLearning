package springstudy.demo.test9.service.serviceImpl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springstudy.demo.test9.service.PayService;
import springstudy.demo.test9.service.dao.PayDao;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/11 21:14
 */

@Service
public class PayServicePlusImpl implements PayService {

  @Override
  public boolean pay(String from, String to, int money) {
    return false;
  }

  @Autowired
  private PayServiceImpl payService;
  @Autowired
  private PayDao payDao;

  @Transactional
  public void payPlus() {
    payService.gupay();
    //如果这里出异常，是12执行 三不执行 三者独立 还是 三者都不执行 还是1执行23不执行？？
    //答案：1执行 后面没执行 分析 1是一个独立的事务，能完成执行事务提交，之后发生了异常2都没有走。
    int i = 1 / 0;
    payService.caoreceive();
    payService.paylog();
  }

  //问题：上来没有事务，调用第一个的时候人家看见没有自己弄一个，下一个方法是算有事务还是没有事务呢？
  @Transactional
  public void payPlus1() {
    BigDecimal money1 = payDao.getMoneyByUserName("顾寿辰");
    payService.gupay();
    BigDecimal money2 = payDao.getMoneyByUserName("顾寿辰");
    System.out.println(money1);
    System.out.println(money2);
    payService.caoreceive();
    payService.paylog();
  }
}
