package me.wgy.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志自定义注解
 *
 * @author wgy
 * @date 2018/11/21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {

  /**
   * 日志描述信息
   */
  String description() default "";
}
