package SpringMVC.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用来容纳学生
 * @author datacharm.cn
 */
public class Platform implements Serializable {

    private static final long serialVersionUID = -5981905054963597311L;
    private Integer id;
    private String name;
    List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
