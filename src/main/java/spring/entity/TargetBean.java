package spring.entity;

/**
 * 值取自sourceBean
 * @author datacharm.cn
 */
public class TargetBean {

    private int id;
    private String name;
    private String city;
    private String role;
    private String driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "TargetBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", role='" + role + '\'' +
                ", diver='" + driver + '\'' +
                '}';
    }
}
