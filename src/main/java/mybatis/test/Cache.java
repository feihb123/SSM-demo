package mybatis.test;

import mybatis.entity.User;
import mybatis.mapper.HelloMapper;
import mybatis.mapper.IfMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Mybatis一级缓存
 * @author datacharm.cn
 */
public class Cache {

    public static void getUsers(HelloMapper helloMapper){
        List<User> users = helloMapper.getUsers();
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }
    public static void getUsers(IfMapper ifMapper){
        List<User> users = ifMapper.getUsers("herb",null);
        for (User user : users) {
            System.out.println(user.getUname());
        }
    }

    /**
     *一级缓存
     * 默认开启以及缓存，从同一个sqlSession中取
     */
    public static void firstCache(SqlSessionFactory sqlSessionFactory){
        SqlSession session= sqlSessionFactory.openSession();
        HelloMapper helloMapper= session.getMapper(HelloMapper.class);
        System.out.println("-----第一次进数据库查询-----");
        getUsers(helloMapper);
        System.out.println("-----第二次从session中直接查-----");
        getUsers(helloMapper);
        SqlSession session2= sqlSessionFactory.openSession();
        HelloMapper helloMapper2= session2.getMapper(HelloMapper.class);
        System.out.println("-----第三次不同session还是从数据库查查-----");
        getUsers(helloMapper2);
    }
    /**
     *二级缓存，从同一个sqlSessionFactory中取
     * -> 查询的对象需要实现Serializable
     * -> 添加<setting name="cacheEnabled" value="true"/>
     * -> mapper.xml中添加<cache/>
     */
    public static void secondCache(SqlSessionFactory sqlSessionFactory){
        SqlSession session= sqlSessionFactory.openSession();
        IfMapper ifMapper= session.getMapper(IfMapper.class);
        System.out.println("-----第一次进数据库查询-----");
        getUsers(ifMapper);
        System.out.println("-----第二次从session中直接查-----");
        getUsers(ifMapper);
        //session关闭后才会将一级缓存中的数据添加到namespace的二级缓存中
        session.close();
        SqlSession session2= sqlSessionFactory.openSession();
        IfMapper ifMapper2= session2.getMapper(IfMapper.class);
        System.out.println("-----开启二级缓存，从同一个sqlSessionFactory,不重新查询数据库-----");
        getUsers(ifMapper2);
    }

    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        firstCache(sqlSessionFactory);
        secondCache(sqlSessionFactory);
    }
}
