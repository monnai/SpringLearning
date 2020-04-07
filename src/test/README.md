  ##### test1:
        实现了实例工厂和静态工厂创建
  ##### test2：
         BeanPostProfessor
  ##### test3: 
         手写springioc
         对三种获取class的方法进行了测试
  ##### test4：
         前期准备：踩了些坑
  ##### test5：
        模拟需求：接口中有多个实现类需要使用@Primary
        现在自定义后置处理器实现这个需求
        体会了工厂设计模式 职责链模式和代理模式
        模拟了setter方式属性注入 testClass        
  ##### test6：spring代理模式：
         总结了切面、切入点、通知等概念 
         见MyAspect MyConfiguation Test6Say testMain 
         尝试jdk代理模式和cglib代理模式 见test6的proxy文件夹
         methodBeforeAdvice 
  ##### test7：springAop 课件uml图
         Animal  eat(aop增强洗手) say(不需要增强)
           |_Person
           |_Dog 
         
         Advisor顾问getAspect()--MethodBeforeAdvice--MyBeforeAdvice
             |                                             |_before() 增强方法 
             | 
             |_PiointCutAdvisor() getPointCut()
                                      |_PointCut切入点 getClassFilter getMethodMatcher              
                                                              |_ClassFilter     |_MethodMatcher
                                                                过滤类              过滤方法
         ProxyFactoryBean spring提供的代理类
                |_target 被代理目标
                |_interceptor 拦截器

         总结：
         classPathXmlApplication.new的时候初始化ioc容器 放入bean
         初始化pointcut advice 注入advisor
         初始化代理对象proxy 将原对象注入target advisor注入interceptor
=======
  #### 标题
  **字体加粗**            
  *ddddd*   
  ***加粗斜体***  
  ~删除线~  
  有序列表  
  无序列表    
  ***
     分割线
  test1:实现了实例工厂和静态工厂创建bean
  test2：BeanPostProfessor
  test3: 手写springioc
=======
         对三种获取class的方法进行了测试
  ##### test4：
         前期准备：踩了些坑
  ##### test5：
        模拟需求：接口中有多个实现类需要使用@Primary
        现在自定义后置处理器实现这个需求
        体会了工厂设计模式 职责链模式和代理模式
        模拟了setter方式属性注入 testClass        
  ##### test6：spring代理模式：
         总结了切面、切入点、通知等概念 
         见MyAspect MyConfiguation Test6Say testMain 
         尝试jdk代理模式和cglib代理模式 见test6的proxy文件夹
      
  ##### test7：springAop 课件uml图
         Animal  eat(aop增强洗手) say(不需要增强)
           |_Person
           |_Dog 
         
         Advisor顾问getAspect()--MethodBeforeAdvice--MyBeforeAdvice
             |                                             |_before() 增强方法 
             | 
             |_PiointCutAdvisor() getPointCut()
                                      |_PointCut切入点 getClassFilter getMethodMatcher              
                                                              |_ClassFilter     |_MethodMatcher
                                                                过滤类              过滤方法
         ProxyFactoryBean spring提供的代理类
                |_target 被代理目标
                |_interceptor 拦截器

         总结：
         classPathXmlApplication.new的时候初始化ioc容器 放入bean
         初始化pointcut advice 注入advisor
         初始化代理对象proxy 将原对象注入target advisor注入interceptor
