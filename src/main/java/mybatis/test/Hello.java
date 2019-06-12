package mybatis.test;

import mybatis.entity.ManageSystem;
import mybatis.entity.Platform;
import mybatis.entity.User;
import mybatis.mapper.HelloMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 表字段：User(uid,uname,pwd,pid)
 *        platform(id,name,sid)
 *        managesystem(id,name)
 *
 * @author datacharm.cn
 */
public class Hello {
    /**
     * 普通查询
     */
    public static void getUsers(HelloMapper helloMapper){
        System.out.println("----普通查询----");
        List<User> users = helloMapper.getUsers();
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }

    /**
     * 一对多查询
     */
    public static void toMany(HelloMapper helloMapper){
        System.out.println("----一对多查询-----");
        List<Platform> platforms = helloMapper.getPlatforms();
        for (Platform platform : platforms) {
            System.out.println(platform.getName());
            List<User> pu = platform.getUsers();
            for (User user : pu) {
                System.out.println("\t"+user.getUname());
            }
        }
    }
    /**
     * 多对一查询
     */
    public static void toOne(HelloMapper helloMapper){
        System.out.println("----多对一查询-----");
        List<User> users = helloMapper.getUserPlatfrom();
        for (User user : users) {
            Platform platform = user.getPlatform();
            System.out.println(user.getUname()+"所在平台:"+platform.getName());
        }
    }

    /**
     *多对多查询
     */
    public static void nested(HelloMapper helloMapper){
        System.out.println("----多对多查询-----");
        List<ManageSystem> manageSystems = helloMapper.showAll();
        for (ManageSystem manageSystem : manageSystems) {
            System.out.println(manageSystem.getName());
            List<Platform> platforms = manageSystem.getPlatforms();
            for (Platform platform : platforms) {
                System.out.println("\t"+platform.getName());
                List<User> users = platform.getUsers();
                for (User user : users) {
                    System.out.println("\t\t"+user.getUname());
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session= sqlSessionFactory.openSession();
        HelloMapper helloMapper= session.getMapper(HelloMapper.class);

        getUsers(helloMapper);
        toMany(helloMapper);
        toOne(helloMapper);
        nested(helloMapper);

        session.commit();
        session.close();
    }


}
