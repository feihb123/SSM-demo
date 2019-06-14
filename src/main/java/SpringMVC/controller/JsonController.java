package SpringMVC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 返回json 这里使用jackson包
 * @author datacharm.cn
 */
@Controller
public class JsonController {
    @RequestMapping("/json")
    @ResponseBody
    public Map getMessage(){
        Map<String,String> map = new HashMap<>(5);
        map.put("1","一");
        map.put("2","二");
        map.put("3","三");
        map.put("4","四");
        List<String> list = new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");
        ResponseEntity<Map> entity = new ResponseEntity(map, HttpStatus.OK);
        //return entity;
        return map;
    }
}
