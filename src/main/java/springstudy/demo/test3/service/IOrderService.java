package springstudy.demo.test3.service;

import springstudy.demo.test3.annotation.IocService;

public interface IOrderService {
       //接口方法默认是public的 不能是static static是基于类的，接口不是类 不能是final需要其他类实现
        String findOrder(String userName);
}
