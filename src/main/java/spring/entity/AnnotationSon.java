package spring.entity;

import org.springframework.stereotype.Component;

/**
 * 注解中被装配的对象
 * @author datacharm.cn
 */
@Component
public class AnnotationSon {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
