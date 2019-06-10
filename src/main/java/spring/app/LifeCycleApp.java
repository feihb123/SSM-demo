package spring.app;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import spring.entity.User;

/**
 * bean实例化模式和生命周期
 * @author datacharm.cn
 */
public class LifeCycleApp {
    public static void main(String[] args) {

        //读取web-inf下文件使用：( ConfigurableApplicationContext相对ApplicationContext增加refresh()和close())
        //ConfigurableApplicationContext ac = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        //读取classPath路径使用（resources）：
        ConfigurableApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        /**
         *<bean id="user" class="spring.entity.User"></bean>
         */
        User user = (User) ac.getBean("user");
        user.setName("user1");
        User user2 = ac.getBean("user",User.class);
        user2.setName("user2");
        //默认使用单例模式
        /*输出：
            user2
            user2
         */
        System.out.println(user.getName());
        System.out.println(user2.getName());

        /**
         *<bean id="user2" class="spring.entity.User" scope="prototype"></bean>
         */
        //scope 选 prototype 可以有多个对象
        User user3 = (User) ac.getBean("user2");
        user3.setName("user3");
        User user4 = (User) ac.getBean("user2");
        user4.setName("user4");
        //每次都会新建一个bean
        /*输出：
             user3
             user4
         */
        System.out.println(user3.getName());
        System.out.println(user4.getName());

        /**
         *    <bean id="user3" class="spring.entity.User" init-method="init"></bean>
         *
         *     <bean id="user4" class="spring.entity.User" init-method="init" scope="prototype"></bean>
         *
         *     <bean id="user5" class="spring.entity.User" destroy-method="destroy" ></bean>
         *
         *     <bean id="user6" class="spring.entity.User" destroy-method="destroy" scope="prototype"></bean>
         */
        //singleton init-method  容器创建就调用，且只有一次
        User user5 = (User) ac.getBean("user3");
        User user6 = (User) ac.getBean("user3");
        //prototype init-method  创建时才调用，每次创建都调用
        User user7 = (User) ac.getBean("user4");
        User user8 = (User) ac.getBean("user4");

        //singleton 在容器关闭时调用destroy方法
        //prototype 不会执行destroy方法
        ac.close();

    }
}
