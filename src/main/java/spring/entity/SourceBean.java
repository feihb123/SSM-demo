package spring.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * 为targetBean提供数据
 * @author datacharm.cn
 */

//@Getter
//@Setter

public class SourceBean {
    private Integer id;
    private String name;
    private List<String> cities;
    private Map<String,Object> session;
    private Properties properties;

    public SourceBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "SourceBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cities=" + cities +
                ", session=" + session +
                ", properties=" + properties +
                '}';
    }
}
