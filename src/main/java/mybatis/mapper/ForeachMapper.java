package mybatis.mapper;

import mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Foreach.xml对应接口
 * @author datacharm.cn
 */
@Mapper
public interface ForeachMapper {
    /**
     *你可以将任何可迭代对象（如 List、Set 等）
     *Map对象或者数组对象传递给 foreach 作为集合参数。
     */
    List<User> getUsersInList(List<String> list);
}
