package spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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
     * 如 execution(* spring.service.AnnotationService.*(..)) 对AnnotationService所有方法切入
     * execution(* spring.service.*.*(..)) 对service包下所有类切入
     */
    @Pointcut("execution(* spring.service.*.*(..))")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        LOGGER.info("Before!");
    }

    @After("pointCut()")
    public void after(){
        LOGGER.info("After!");
    }

    @AfterReturning(pointcut="pointCut()",returning="returnVal")
    public void afterReturn(JoinPoint joinPoint, Object returnVal){
        LOGGER.info("AOP AfterReturning Advice:" + returnVal);
    }

    @AfterThrowing(pointcut="pointCut()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        LOGGER.error("AOP AfterThrowing Advice..." + error);
        LOGGER.info("AfterThrowing...");
    }
    @Around("pointCut()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("切点：" + joinPoint.getSignature().getName());
        LOGGER.info("start!");
        Object object = joinPoint.proceed();
        LOGGER.info("end!");
        return object;
    }
}
