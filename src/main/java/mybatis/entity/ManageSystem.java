package mybatis.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ManageSystem包含Platform，Platform包含User
 * @author datacharm.cn
 */
@Setter
@Getter
public class ManageSystem {
    private Integer id;
    private String name;
    private List<Platform> platforms;
}
