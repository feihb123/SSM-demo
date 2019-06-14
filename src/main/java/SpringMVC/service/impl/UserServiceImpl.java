package SpringMVC.service.impl;


import SpringMVC.exception.UserException;
import SpringMVC.mapper.UserMapper;
import SpringMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author datacharm.cn
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,rollbackForClassName = "Exception")
    public void transactionTest(){
        userMapper.userInert();
        userMapper.userUpdate();
        //故意抛出异常使其回滚
        if (true) {
            throw new RuntimeException("transactionTest()");
        }
    }
}
