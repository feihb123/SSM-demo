package spring.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 利用xml配置的服务类，作为切点
 * @author datacharm.cn
 */
@Service
public class AnnotationService {

    public void function() throws Exception {
        System.out.println("Annotation Service Function()!");
        throw new Exception("This is exception");
    }
}
