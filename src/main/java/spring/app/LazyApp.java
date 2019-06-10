package spring.app;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import spring.entity.User;
import spring.entity.User2;

/**
 * 懒加载
 * @author datacharm.cn
 */
public class LazyApp {
    /**
     * <bean id="lazy" class="entity.User2" lazy-init="true" init-method="init"></bean>
     * <bean id="user3" class="entity.User" init-method="init"></bean>
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        /**输出顺序(解开User中注释的输出)
         * User init()
         * User2 init()
         * 即添加懒加载后不是启动容器就创建实例了
         */
        User2 user2 = (User2)ac.getBean("lazy");

        User user = (User)ac.getBean("user3");
    }
}
