package spring.app;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Calendar;

/**
 * 抽象对象实例创建
 * @author datacharm.cn
 */
public class AbstractApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        //抽象方法需要加 factory-method="getInstance"
        Calendar calendar = (Calendar)ac.getBean("calendar");

    }
}
