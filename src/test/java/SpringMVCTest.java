import SpringMVC.entity.User;
import SpringMVC.mapper.HelloMapper;
import SpringMVC.mapper.IfMapper;
import SpringMVC.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author datacharm.cn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:web/WEB-INF/applicationContext.xml"})
public class SpringMVCTest {

    @Autowired
    HelloMapper helloMapper;
    @Autowired
    UserService userService;

    @Test
    public void getUsers(){

        List<User> users = helloMapper.getUsers();
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }

    @Test
    public void TransactionTest(){
        //测试出现异常回滚数据
        userService.transactionTest();
    }
}
