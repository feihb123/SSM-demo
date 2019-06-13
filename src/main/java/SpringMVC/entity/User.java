package SpringMVC.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author datacharm.cn
 */
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = -6634729845403813102L;
    private int uid;
    private String uname;
    private String pwd;
    private int pid;
    private Platform platform;

}
