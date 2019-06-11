package spring.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.entity.SourceBean;
import spring.entity.TargetBean;

/**
 * @author datacharm.cn
 */
public class TransmitApp {
    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("dataApplicationContext.xml");
        SourceBean source = ac.getBean("source", SourceBean.class);
        System.out.println(source.toString());
        TargetBean targetBean = ac.getBean("target",TargetBean.class);
        System.out.println(targetBean.toString());
        ac.close();
    }
}
