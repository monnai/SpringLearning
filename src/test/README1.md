##### test8 
      testMain测试了Map 和Properties属性注入
      unxml：测试，纯注解配置spring
      unxml：配置junit spring组件整合
      复习了spring aop测试xml配置总结如下
        <bean id="writeService" class="springstudy.demo.test8.unxml.WriteService"></bean>
        <bean id="writeServiceAspect" class="springstudy.demo.test8.unxml.WriteServiceAspect"></bean>
      
        <aop:config>
          相当于@Aspect
          <aop:aspect ref="writeServiceAspect">
            相当于@Before
            <aop:before method="log"
              pointcut="execution(public void springstudy.demo.test8.unxml.WriteService.write(..))"></aop:before>
          </aop:aspect>
        </aop:config>
        
#####  test9
       使用jdbcTemplate连本地mysql创建数据库test20200409 创建表account
       编写payService模拟老公给老婆转账   
       事务总结:
       mysql对于autocommit默认是1 自动提交后一次事务就结束了
          * 隔离级别是相对于事务的，设置隔离级别，仅仅相对于当前链接，对其他线程没有影响
          *    * READ_UNCOMMITTED  11  其他线程操作的记录，没提交也能查到
          *    * READ_COMMITTED 12      没提交的查不到
          *    * REPEATABLE_READ 12 ? count 3 对于当前事务，其他线程变更记录了，也对本线程没影响
          *    * SERIALIZABLE  一个线程的操作没有结束，表锁死，其他线程无法操作
       
       事务失效：① 事务能捕捉到Error和RuntimeException ,其他的无法捕捉，除非使用rollbackfor
                  进行指定
               ② @transaction必须注解在public 方法上不然不起作用
               ③数据库不支持事务或者mysql没用InnoDb 
               https://www.jianshu.com/p/d4c3634447d0       

       事务的传播性：
       REQUIRED 如果外层有就用，没有自己开
       REQUIRED_NEW 不管外层有没有，都自己开 (保证内层不受外面干扰)
       SUPPORTS 外层有就用，没有就不用
       NOT_SUPPORTED 外层没有事务正好，有事务将外面事务挂起
                     （暂时不用，也不提交，直接执行内层代码，所以有一个效果是进行更新操作卡死）
       MANDATORY 强制外层有事务 有就用，没有抛异常 No existing transaction found
       NEVER   外层没有事务正好，有事务抛异常 Existing transaction found for transaction marked with propagation 'never'
       NESTED  外层没有时新建事务，有事务时嵌套事务
       注意：如果是内层创建一个事务，也只是属于内层的，对外层以及其他事务没有影响
      
      
      

      
 
