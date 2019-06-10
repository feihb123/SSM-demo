package spring.app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import spring.entity.SampleBean;
import spring.entity.SmallBean;


/**
 * @author datacharm.cn
 */
public class SampleBeanApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        SampleBean sampleBean = context.getBean("sampleBean",SampleBean.class);
        System.out.println(sampleBean.toString());
        sampleBean.getBean().setName("bean!");
        System.out.println(sampleBean.getBean().getName());
    }



}
