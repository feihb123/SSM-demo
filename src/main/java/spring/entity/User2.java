package spring.entity;

/**
 * @author datacharm.cn
 */
public class User2 {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void show(){
        System.out.println("show()");
    }

    public void init(){
        /*System.out.println("User2 init()");*/
    }
    public void destroy(){
        /*System.out.println("User2 destroy()");*/
    }
}
