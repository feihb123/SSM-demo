package spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aspect.AnnotationLoggerAspect;
import spring.service.TransactionService;

/**
 * 声明式事务使用
 * @author datacharm.cn
 */
public class TransactionApp {

    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("annotationApplicationContext.xml");
        TransactionService transactionService = ac.getBean("transactionService", TransactionService.class);
        transactionService.save();
    }
}
