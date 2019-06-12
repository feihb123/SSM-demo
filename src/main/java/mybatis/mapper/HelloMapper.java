package mybatis.mapper;

import jdk.nashorn.internal.objects.annotations.Setter;
import mybatis.entity.ManageSystem;
import mybatis.entity.Platform;
import mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基于注解的一般查询，一对一，一对多查询
 * @author feihb
 */
@Mapper
@Repository
public interface HelloMapper {
    /**
     * 普通查询
     * @return User集合
     */
    @Select("select * from user where 1 = 1")
    List<User> getUsers();


    /**
     * 按User表中platform查询User
     */
    @Select("select * from user where pid = #{id}")
    List<User> findUsers(int id);

    /**
     * 按platform表中id查询
     */
    @Select("select * from platform where id = #{id}")
    List<Platform> findPlatform(int id);



    /**
     * 一对多查询
     */
    @Select("select * from platform where 1 = 1")
    @Results({
            /*@Result(property = "id" , column = "id"),*/
            @Result(property = "users",
                    /*javaType = List.class,*/
                    //对platform表中id属性进行一对多查询
                    column = "id",
                    many = @Many(select = "mybatis.mapper.HelloMapper.findUsers")
            )
    })
    List<Platform> getPlatforms();

    @Select("select * from user where 1 = 1")
    @Results({
            @Result(property = "platform",
                    column = "pid",
                    one = @One(select = "mybatis.mapper.HelloMapper.findPlatform")
            )
    })
    List<User> getUserPlatfrom();


    /**
     * 多对多查询 -> 即嵌套查询结果
     */
    @Select("select * from manageSystem where 1 = 1 ")
    @Results({
            @Result(property = "platforms",
                    column = "id",
                    many = @Many(select = "mybatis.mapper.HelloMapper.getPlatforms")
            )
    })
    List<ManageSystem> showAll();

}
