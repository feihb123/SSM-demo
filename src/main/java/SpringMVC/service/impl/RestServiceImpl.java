package SpringMVC.service.impl;

import SpringMVC.aspect.LoggerAspect;
import SpringMVC.entity.User;
import SpringMVC.mapper.RestMapper;
import SpringMVC.service.RestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author datacharm.cn
 */
@Service
public class RestServiceImpl implements RestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    @Autowired
    RestMapper restMapper;

    @Override
    public List<User> getUsers() {
        return restMapper.getUsers();
    }

    @Override
    public User get(int id) {
        LOGGER.info("Rest进入get服务层");
        return restMapper.get(id);
    }

    @Override
    public boolean update(String name, int id) {
        LOGGER.info("Rest进入update服务层");
        int flag = restMapper.update(name, id);
        System.out.println(flag);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        LOGGER.info("Rest进入delete服务层");
        int flag = restMapper.delete(id);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean inert(User user) {
        LOGGER.info("Rest进入inert服务层");
        int flag = restMapper.inert(user);
        if(flag > 0){
            return true;
        }
        return false;
    }
}
