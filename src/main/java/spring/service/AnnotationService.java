package spring.service;

import org.springframework.stereotype.Service;

/**
 * 利用xml配置的服务类
 * @author datacharm.cn
 */
@Service
public class AnnotationService {

    public void function(){
        System.out.println("Annotation Service Function()!");
    }
}
