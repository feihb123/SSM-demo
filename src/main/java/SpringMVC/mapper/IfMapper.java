package SpringMVC.mapper;

import SpringMVC.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * If.xml对应接口
 * @author datacharm.cn
 */
@Mapper
public interface IfMapper {

    List<User> getUsers(@Param("name") String name, @Param("pid") Integer pid);
}
