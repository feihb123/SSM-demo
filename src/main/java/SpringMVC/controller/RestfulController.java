package SpringMVC.controller;

import SpringMVC.entity.User;
import SpringMVC.service.RestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author datacharm.cn
 */
@RestController

public class RestfulController {
    @Autowired
    RestService restService;

    @RequestMapping("/user")
    public ModelAndView user( @RequestParam(value = "start", defaultValue = "0") int start,
                              @RequestParam(value = "size", defaultValue = "8") int size){
        ModelAndView mav = new ModelAndView("rest");
        PageHelper.startPage(start,size,"uid asc");
        List<User> users = restService.getUsers();
        PageInfo<User> page = new PageInfo<>(users);
        mav.addObject("page",page);
        return mav;
    }

    @GetMapping("/user/{uid}")
    public ModelAndView get(User user){
        user = restService.get(user.getUid());
        System.out.println(user);
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("user",user);
        return mav;
    }

    @PutMapping("/user/{uid}")
    public ModelAndView update(User user){
        boolean flag = restService.update(user.getUname(),user.getUid());
        ModelAndView mav;
        if(flag){
            mav = new ModelAndView("redirect:/user");
            return mav;
        }
        mav = new ModelAndView("error");
        return mav;
    }

    @DeleteMapping("/user/{uid}")
    public ModelAndView delete(User user){

        boolean flag = restService.delete(user.getUid());
        ModelAndView mav;
        if(flag){
            mav = new ModelAndView("redirect:/user");
            return mav;
        }
        mav = new ModelAndView("error");
        return mav;
    }

    @PostMapping("/user")
    public ModelAndView add(User user){
        boolean flag = restService.inert(user);
        ModelAndView mav;
        if(flag){
            mav = new ModelAndView("redirect:/user");
            return mav;
        }
        mav = new ModelAndView("error");
        return mav;
    }



}
