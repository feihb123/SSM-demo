import mybatis.entity.User;
import mybatis.mapper.HelloMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author datacharm.cn
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:web/WEB-INF/springMVCApplicationContext.xml"})
public class MybatisTest {
    @Autowired
    HelloMapper helloMapper;

    public void getUsers(){
        List<User> users = helloMapper.getUsers();
        for (User user : users) {
            user.getUname();
        }
    }
}
