package SpringMVC.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 为RestService织入日志
 * @author datacharm.cn
 */
@Aspect
public class LoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("execution(* SpringMVC.service.*.*(..))")
    public void pointCut(){

    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(ProceedingJoinPoint joinPoint){
        LOGGER.error("服务层出现异常："+joinPoint.getSignature());
    }
}
