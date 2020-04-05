package springstudy.demo.test3.service.impl;

import springstudy.demo.test3.annotation.IocService;
import springstudy.demo.test3.service.IOrderService;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/4/1 22:34
 */
@IocService
public class OrderService implements IOrderService {

  //接口中是public所以实现类也要public
  public String findOrder(String userName) {
    return new StringBuilder().append("用户").append(userName).append("的订单编号是：1001").toString();
  }
}
