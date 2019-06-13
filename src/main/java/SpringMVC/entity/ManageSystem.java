package SpringMVC.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * ManageSystem包含Platform，Platform包含User
 * @author datacharm.cn
 */
@Setter
@Getter
public class ManageSystem implements Serializable {

    private static final long serialVersionUID = -5641758692029265659L;
    private Integer id;
    private String name;
    private List<Platform> platforms;
}
