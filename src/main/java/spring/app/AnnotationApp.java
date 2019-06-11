package spring.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aspect.AnnotationLoggerAspect;
import spring.entity.AnnotationFather;
import spring.entity.Person;
import spring.service.AnnotationService;


/**
 * 注解方式配置Spring
 * @author datacharm.cn
 */

public class AnnotationApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationLoggerAspect.class);

    public static void main(String[] args) {

        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
        //自动装配
        AnnotationFather annotationFather = ac.getBean("annotationFather", AnnotationFather.class);
        System.out.println(annotationFather.getAnnotationSon());

        //AOP
        AnnotationService annotationService = ac.getBean("annotationService", AnnotationService.class);
        try {
            annotationService.function();
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }


    }
}
