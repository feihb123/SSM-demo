package mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author datacharm.cn
 */
@Getter
@Setter
public class User implements Serializable {
    private int uid;
    private String uname;
    private String pwd;
    private int pid;
    private Platform platform;

}
