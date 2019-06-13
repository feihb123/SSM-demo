package mybatis.test;

import mybatis.entity.ManageSystem;
import mybatis.entity.Platform;
import mybatis.entity.User;
import mybatis.mapper.ChooseMapper;
import mybatis.mapper.ForeachMapper;
import mybatis.mapper.HelloMapper;
import mybatis.mapper.IfMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 *        Mybatis动态查询
 * 表字段：User(uid,uname,pwd,pid)
 *        platform(id,name,sid)
 *        managesystem(id,name)
 *
 * @author datacharm.cn
 */
public class XmlHello {
    /**
     * if查询  方式1：不采用mapper接口类  ->较麻烦
     */
    public static void getUsersByXml(SqlSession session){
        System.out.println("----IF按XML查询----");
        Map<String,String> map = new HashMap<>(2);
        map.put("name","herb");
        map.put("pid","1");
        //命名空间
        List<User> users = session.selectList("mybatis.mapper.IfMapper.getUsers",map);
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }
    /**
     * if查询  方式2：通过mapper接口类
     */
    public static void getUsersByMapper(SqlSession session){
        System.out.println("----IF通过Mapper接口查询----");
        IfMapper mapper = session.getMapper(IfMapper.class);
        List<User> users = mapper.getUsers("herb",null);
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }

    /**
     * mybatis choose标签使用
     */
    public static void getUsersByChoose(SqlSession session){

        System.out.println("----Choose通过Mapper接口查询----");
        ChooseMapper mapper = session.getMapper(ChooseMapper.class);
        List<User> users = mapper.getUsers(null,null);
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }

    /**
     * foreach标签使用
     */
    public static void getUsersByForeach(SqlSession session){
        System.out.println("----通过Foreach遍历结果集查询----");
        ForeachMapper mapper = session.getMapper(ForeachMapper.class);
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("3");
        List<User> users = mapper.getUsersInList(list);
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }




    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session= sqlSessionFactory.openSession();
        getUsersByXml(session);
        getUsersByMapper(session);
        getUsersByChoose(session);
        getUsersByForeach(session);



        session.commit();
        session.close();
    }


}
