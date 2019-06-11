package spring.app;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.entity.Person;
import spring.entity.Tool;


/**
 * @author datacharm.cn
 */

public class AutowiredApp {
    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("autowiredApplicationContext.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person.getTool().getName());
    }
}
