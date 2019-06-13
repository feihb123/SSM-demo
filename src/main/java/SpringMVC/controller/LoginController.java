package SpringMVC.controller;

import SpringMVC.entity.User;
import SpringMVC.mapper.HelloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author datacharm.cn
 */
@Controller
public class LoginController {
    @Autowired
    HelloMapper helloMapper;

    @RequestMapping("/login")
    public String login(){
        List<User> users = helloMapper.getUsers();
        for (User user : users) {
            System.out.println(user.getUname());
        }
        return "user_login_form";
    }
    

}
