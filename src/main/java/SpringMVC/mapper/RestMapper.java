package SpringMVC.mapper;


import SpringMVC.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RestMapper {
    @Select("select * from user where 1 = 1")
    List<User> getUsers();

    @Select("select * from user where uid = #{id}")
    User get(int id);

    @Update("update user set uname = #{name} where uid = #{id}")
    int update(@Param("name") String name, @Param("id")int id);

    @Delete("delete from user where uid = #{id}")
    int delete(@Param("id")int id);

    @Insert("insert into user values(null,#{uname},'test',1)")
    int inert(User user);
}
