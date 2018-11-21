package me.wgy.log;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wgy
 * @date 2018/11/21
 */
@Aspect
@Component
public class LoggerAdvice {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAdvice.class);

  @Before("within(me.wgy..*) && @annotation(loggerManage)")
  public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
    LOGGER.info("执行方法[{}]开始,loggerManage.description()");
    LOGGER.info("方法签名[{}]", joinPoint.getSignature().toString());
    LOGGER.info("传入参数[{}]", Arrays.toString(joinPoint.getArgs()));
  }

  @AfterReturning("within(me.wgy..*) && @annotation(loggerManage)")
  public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
    LOGGER.info("执行 " + loggerManage.description() + " 结束");
  }

  @AfterThrowing(pointcut = "within(me.wgy..*) && @annotation(loggerManage)", throwing = "ex")
  public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception ex) {
    LOGGER.error("执行 " + loggerManage.description() + " 异常", ex);
  }
}
