package spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author datacharm.cn
 */
public class LoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        LOGGER.info("end log:" + joinPoint.getSignature().getName());
        return object;
    }
}
