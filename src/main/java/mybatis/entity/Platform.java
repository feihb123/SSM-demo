package mybatis.entity;

import java.util.List;

/**
 * 用来容纳学生
 * @author datacharm.cn
 */
public class Platform {
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
