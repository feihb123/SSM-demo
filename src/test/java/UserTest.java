import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.entity.SampleBean;
import spring.entity.SmallBean;
import spring.entity.User;

import java.util.Date;

/**
 * @author datacharm.cn
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件
public class UserTest {
    @Autowired
    Date date;
    @Autowired
    SampleBean sampleBean;
    @Autowired
    SmallBean smallBean;

    @Test
    public void show(){
        System.out.println(date);
    }

    @Test
    public void showBean(){
        System.out.println(sampleBean.toString());
        sampleBean.getBean().setName("bean!");
        System.out.println(sampleBean.getBean().getName());
    }

    @Test
    public void showSmallBean(){
        sampleBean.setName("bean!");
        System.out.println(sampleBean.getName());
    }




}
