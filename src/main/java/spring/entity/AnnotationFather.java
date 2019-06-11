package spring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注解中需要装配对象的类
 * @author datacharm.cn
 */
@Component
public class AnnotationFather {
    @Autowired
    private AnnotationSon annotationSon;

    public AnnotationSon getAnnotationSon() {
        return annotationSon;
    }

    public void setAnnotationSon(AnnotationSon annotationSon) {
        this.annotationSon = annotationSon;
    }
}
