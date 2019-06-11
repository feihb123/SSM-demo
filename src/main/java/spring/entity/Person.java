package spring.entity;

import java.io.Serializable;

/**
 * @author datacharm.cn
 */
public class Person implements Serializable {
    private Tool tool;
    private String name ;

    public Person() {
    }

    public Person(Tool tool, String name) {
        this.tool = tool;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void use(){
        System.out.println(name+"使用"+tool.getName());
    }
}
