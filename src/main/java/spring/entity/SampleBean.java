package spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author datacharm.cn
 */
@Setter
@Getter
@ToString
public class SampleBean {
    private Integer id;
    private String tag;
    private String name;
    private Date date;
    private List<String> listData;
    private Set<String> setData;
    private Map<String,Object> mapData;
    private Properties properties;
    @Autowired
    private SmallBean bean;

    public SampleBean() {
    }

    public SampleBean(String name) {
        this.name = name;
    }
}
