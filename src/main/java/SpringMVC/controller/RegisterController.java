package SpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author datacharm.cn
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("user_register_form");
        System.out.println("/register");
        return mav;
    }
}
