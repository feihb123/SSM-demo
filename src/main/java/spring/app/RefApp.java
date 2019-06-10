package spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.entity.Person;

/**
 * ref用于注入对应id的对象
 * @author datacharm.cn
 */
public class RefApp {
    /**
     *    <bean id="tool" class="spring.entity.Tool">
     *         <property name="name" value="工具"></property>
     *     </bean>
     *
     *     <bean id="person" class="spring.entity.Person">
     *         <property name="name" value="人类"></property>
     *         <property name="tool" ref="tool"></property>
     *     </bean>
     *
     *     <bean id="person2" class="spring.entity.Person">
     *         <constructor-arg index="0" value="第二个人"></constructor-arg>
     *         <property name="tool" ref="tool"></property>
     *     </bean>
     */
    private static final Logger logger = LoggerFactory.getLogger(RefApp.class);

    public static void main(String[] args) {
        logger.info("start!");
        ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //property 注入
        Person person = (Person)ac.getBean("person");
        person.use();
        //constructor-arg 注入
        Person person2 = (Person)ac.getBean("person2");
        person2.use();

        ac.close();

    }

}
