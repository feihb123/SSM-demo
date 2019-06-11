package spring.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.service.CommonService;

import java.util.Calendar;

/**
 * xml配置AOP
 * @author datacharm.cn
 */
public class AopApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac =new ClassPathXmlApplicationContext("aopApplicationContext.xml");
        CommonService commonService = ac.getBean("commonService", CommonService.class);
        commonService.function();

    }
}
