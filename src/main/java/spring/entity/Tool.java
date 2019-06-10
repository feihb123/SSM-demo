package spring.entity;

import java.io.Serializable;

/**
 * @author datacharm.cn
 */
public class Tool implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
