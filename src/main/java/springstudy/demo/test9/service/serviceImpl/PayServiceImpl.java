package springstudy.demo.test9.service.serviceImpl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springstudy.demo.test9.service.PayService;
import springstudy.demo.test9.service.dao.PayDao;
import springstudy.demo.test9.service.dao.PayDao.ChangeType;

@Service
public class PayServiceImpl implements PayService {

  final PayDao payDao;

  @Autowired
  public PayServiceImpl(PayDao payDao) {
    this.payDao = payDao;
  }

  /*
   高并发的问题：脏读 不可重复读 幻读
   mysql隔离级别 读未提交 读已提交 可重复读 序列化
   事务的传播机制
   事务的失效
   手动抛异常会不会触发事务
   默认的隔离级别 异常过滤

   问题：上来就不生效
   */
  @Override
  @Transactional()
  public boolean pay(String from, String to, int money) {
    //jdbc操作，成功true 失败false 异常事务管理
    try {
      BigDecimal gu1 = payDao.getMoneyByUserName("顾寿辰");
      System.out.println(gu1);
      boolean rst1 =
          payDao.changeMoney(from, new BigDecimal(money), ChangeType.subtract);
      BigDecimal gu2 = payDao.getMoneyByUserName("顾寿辰");
      System.out.println(gu2);
      boolean rst2 =
          payDao.changeMoney(to, new BigDecimal(money), ChangeType.add);
//      int a = 1 / 0;
    } catch (ArithmeticException e) {
      System.err.println(e.getMessage());
      //踩坑：catch捕获后如果没有重新抛出异常不会被aop捕获，不能被事务管理
      throw new RuntimeException();
    } finally {
      //事务回滚是在finally之前还是之后相关源码是如何实现的:finally之后回滚
      BigDecimal gu3 = payDao.getMoneyByUserName("顾寿辰");
      System.out.println(gu3);

    }
    return true;
  }

/*
show VARIABLES like '%autocommit%'
show global variables like '%isolation%';
set global transaction_isolation ='read-committed';
set autocommit =0
set autocommit =1

update pay set money = 23 where username = "杨晴"
insert into pay values ('赵树彬',12);
delete from pay where username = '赵树彬';
select * from pay

commit;
ROLLBACK

*/

  /**
   * cmd改了11 没提交 本来12 事务隔离级别 READ_UNCOMMITTED  11 READ_COMMITTED 12 REPEATABLE_READ 12 ? count 3 SERIALIZABLE  卡主了 批注：
   * mysql对于autocommit默认是1 自动提交后一次事务就结束了 隔离级别是相对于事务的，设置隔离级别，仅仅相对于当前链接，对其他线程没有影响 * READ_UNCOMMITTED  11 其他线程操作的记录，没提交也能查到
   * * READ_COMMITTED 12      没提交的查不到 * REPEATABLE_READ 12 ? count 3 对于当前事务，其他线程变更记录了，也对本线程没影响 * SERIALIZABLE
   * 一个线程的操作没有结束，表锁死，其他线程无法操作
   *
   * 事务的失效场景： throw new RuntimeException();
   */
  @Transactional(isolation = Isolation.REPEATABLE_READ)
  public void TestIsolation() {
//    BigDecimal gu = payDao.getMoneyByUserName("杨晴");
    BigDecimal count = payDao.getCount();
//    System.out.println(gu);
    System.out.println(count);
    BigDecimal count1 = payDao.getCount();
//    System.out.println(gu);
    System.out.println(count1);
  }

  /**
   * 事务的传播性：一方收钱 一方付款 记录日志
   */
  //问题：一个service里面的事务相互调用事务如何处理？
  @Transactional()
  public void gupay() {
    payDao.changeMoney("顾寿辰", new BigDecimal(1000), ChangeType.subtract);
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void caoreceive() {
    System.out.println(121212);
    payDao.changeMoney("曹雅婷", new BigDecimal(1000), ChangeType.add);
    int i =1/0;
  }

  //问题：感觉这个事务的传播性没啥用啊？
//not supported 标注的代码无论如何都没有事务
  @Transactional(propagation = Propagation.NESTED)
  public void paylog() {
    payDao.addLog();
  }
  //使用this调用本service的方法，不能进行事务传播
//  @Transactional
 /* public void payPlus() {
    this.gupay();
    this.caoreceive();
//    int i = 1/0;
    this.paylog();
  }*/
}
