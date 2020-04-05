package springstudy.demo.test4.service;

import springstudy.demo.test4.service.HelloService;

public interface CatHelloService extends HelloService {
   //踩坑：这里不能有private修饰，private是类内部才能用的 这是接口
    String nose = "鼻子不灵敏";
}
