package springstudy.demo.test3.service.impl;

import springstudy.demo.test3.annotation.IocResource;
import springstudy.demo.test3.annotation.IocService;
import springstudy.demo.test3.service.IOrderService;
import springstudy.demo.test3.service.IUserService;

/**
 * @description:
 * @auther: gu.sc
 * @date: 2020/4/1 22:34
 */
@IocService(name = "userbiz")
public class UserService implements IUserService {

  @IocResource
  private IOrderService orderService;

  public String findOrder(String userName) {
    return orderService.findOrder(userName);
  }
}
