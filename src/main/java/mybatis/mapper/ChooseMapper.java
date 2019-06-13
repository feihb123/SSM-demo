package mybatis.mapper;

import mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Choose.xml对应接口
 * @author datacharm.cn
 */
@Mapper
public interface ChooseMapper {

    List<User> getUsers(@Param("name") String name, @Param("pid") Integer pid);
}
