package springstudy.demo.test7.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/6 17:27
 */
public class MyPointCutAdvisor implements PointcutAdvisor {
  //私有化
  private Pointcut pointcut;
  private Advice advice;

  //xml注入
  public void setPointcut(Pointcut pointcut) {
    this.pointcut = pointcut;
  }

  public void setAdvice(Advice advice) {
    this.advice = advice;
  }

  @Override
  public Pointcut getPointcut() {
    return this.pointcut;
  }

  @Override
  public Advice getAdvice() {
    return this.advice;
  }

  @Override
  public boolean isPerInstance() {
    return false;
  }
}
