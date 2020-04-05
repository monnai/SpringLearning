package springstudy.demo.test5.service.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Auther gu.sc
 * @Date 2020/4/3 21:22
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//@Component 踩坑：这个东西有用吗？
public @interface RountingRejected{
  String value() default "";

}
