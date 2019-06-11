package spring.ascpect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 切面
 * @author datacharm.cn
 */
@Component
@Aspect
public class AnnotationLoggerAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationLoggerAspect.class);
    /**
     * 切入点
     */
    @Pointcut("execution(* spring.service.AnnotationService.*.*(..))")
    public void aspect(){

    }

    @Around("aspect()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("切点：" + joinPoint.getSignature().getName());
        LOGGER.info("start!");
        Object object = joinPoint.proceed();
        LOGGER.info("end!");
        return object;
    }
}
