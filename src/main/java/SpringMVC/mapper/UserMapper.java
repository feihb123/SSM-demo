package SpringMVC.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user values(null,'test','test',1)")
    void userInert();

    @Insert("update user set pwd = '123' where uid = 24")
    void userUpdate();

}
