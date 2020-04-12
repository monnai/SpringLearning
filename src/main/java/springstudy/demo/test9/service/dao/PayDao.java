package springstudy.demo.test9.service.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PayDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PayDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public enum ChangeType {
    add("+"), subtract("-"), multiply("*"), divide("/");
    private String type;

    String getType() {
      return this.type;
    }

    ChangeType(String type) {
      this.type = type;
    }

  }

  /**
   * 更改钱数
   *
   * @param userName 账户名
   * @param changeMoney 变更金额
   * @param type 加减乘除
   */
  public boolean changeMoney(String userName, BigDecimal changeMoney, ChangeType type) {
    int resultCode = jdbcTemplate.update(
        " update pay set money = money " + type.getType() + "?  where userName = ?  ", ps -> {
          //old money +/-
          ps.setObject(1, changeMoney);
          ps.setString(2, userName);
        });
    return resultCode > 0;
  }
  @Transactional(propagation = Propagation.SUPPORTS)
  public BigDecimal getMoneyByUserName(String userName) {
    return jdbcTemplate
        .queryForObject(" select money from pay where username = ? ", new String[]{userName}, BigDecimal.class);
  }

  public BigDecimal getCount() {
    return jdbcTemplate
        .queryForObject(" select count(*) from pay ", BigDecimal.class);
  }

  /*  @Test
    public void t() {
      changeMoney("顾寿辰", new BigDecimal(20), ChangeType.add);
    }*/
  public void addLog() {
    jdbcTemplate
        .execute(" insert into paylog(time) values  ('" + LocalDate.now() + "   " + LocalTime.now()+"')");
  }

}
