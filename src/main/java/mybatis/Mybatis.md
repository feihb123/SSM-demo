## 1.Mybatis主要核心组件
- SqlSessionFactoryBuilder（构造器）
>它会根据配置或者代码来生成SqlSessionFactory，采用的是分步构建的Builder模式。

- SqlSessionFactory（工厂模式）
>依靠它来生成SqlSession，使用的是工厂模式。

- SqlSession（会话）

  >一个既可以发送SQL 执行返回结果，也可以获取Mapper的接口。在现在技术中，一般会让其在业务代码中消失，而是采用Mybatis提供的 SQL Mapper接口编程技术，它能够提高代码的可读性和可维护性。

  >在Mybatis中，SqlSession是其核心接口。在Mybatis中有两个实现类，DefaultSqlSession 和 SqlSessionManager。DefaultSqlSession 是单线程使用的，而SqlSessionManager是多线程使用的。SqlSession的作用类似于JDBC 中的Connection对象，代表着一个连接资源的作用。常用的作用主要有三个：获取Mapper接口；发送SQL给数据库；控制数据库事务。

  >SqlSession发送SQL给数据库主要有两种方式，一种是SqlSession直接发送，另外一种是通过SqlSession获取Mapper接口再发送。综合比较来看，后者是一种更好的方式。主要是因为使用Mapper接口编程可以消除SqlSession带来的功能性代码，提高可读性，而SqlSession发送SQL，需要一个SQL id去匹配SQL，比较晦涩难懂。使用Mapper接口，类似于roleMapper.getRole(1L)，是完全面向对象的语言，更能体现业务的逻辑。此外，使用Mapper.getRole(1L)的方式，编译器会进行错误的校验，这样更能方便查看是否存在错误。

- SQL Mapper（映射器）
>它是由一个Java接口和XML 文件（或注解）构成，需要给出相应的SQL 和映射原则。它负责发送SQL去执行，并返回结果。

- 映射器是Mybatis中最重要、最复杂的组件，它可以配置以下内容：
  + 描述映射规则；
  + 提供SQL语句，并可以配置SQL参数类型、返回类型、缓存刷新等信息；
  + 配置缓存；
  + 提供动态SQL

## 2.Mybatis配置
- 全局配置：mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>
    <!--需要按顺序填写标签！-->

    <!--数据库配置文件-->
    <properties resource="db.properties"/>
    <!--mybatis日志设置-->
    <settings>
        <setting name="logImpl" value="SLF4J"></setting>
    </settings>
    <!--给整个package中的javabean取别名，默认首字母小写-->
    <typeAliases>
        <package name="mybatis/entity"/>
    </typeAliases>
    <!--环境配置-->
    <environments default="development">
        <environment id="development">
            <!--事务管理-->
            <transactionManager type="JDBC"/>
            <!--数据源->配置数据库连接信息-->
            <dataSource type="POOLED">
                <!--注入db.properties中属性-->
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>
    <!--配置mapper形式 class:mapper接口  resource:xml配置文件-->
    <mappers>
        <mapper class="mybatis.mapper.HelloMapper"/>
        <mapper resource="mapper/IfMapper.xml"/>
        <mapper resource="mapper/ChooseMapper.xml"/>
        <mapper resource="mapper/ForeachMapper.xml"/>
    </mappers>
</configuration>
```
- mapper.xml配置文件格式

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace -> mapper接口所在位置-->
<mapper namespace="mybatis.mapper.IfMapper">
    <!--具体增删改查操作-->
    <select id="getUsers" resultType="User">
        select * from user where 1 = 1
        <if test="name != null">
            and uname like concat('%',#{name},'%')
        </if>
        <if test="pid != null">
            and pid = #{pid}
        </if>
    </select>
</mapper>
```
## 3.其他注意点
- #{} 和 ${} 区别

  - #{}是预编译处理，${}是字符串替换。

  - Mybatis在处理#{}时，会将sql中的#{}替换为?号，调用PreparedStatement的set方法来赋值；

  - Mybatis在处理${}时，就是把${}替换成变量的值。

  - 使用#{}可以有效的防止SQL注入，提高系统安全性。

## 4.Mybatis缓存
- 一级缓存
>Mybatis对缓存提供支持，但是在没有配置的默认情况下，它只开启一级缓存，一级缓存只是相对于同一个SqlSession而言。所以在参数和SQL完全一样的情况下，我们使用同一个SqlSession对象调用一个Mapper方法，往往只执行一次SQL，因为使用SelSession第一次查询后，MyBatis会将其放在缓存中，以后再查询的时候，如果没有声明需要刷新，并且缓存没有超时的情况下，SqlSession都会取出当前缓存的数据，而不会再次发送SQL到数据库。

  - 一级缓存的生命周期:

     a、MyBatis在开启一个数据库会话时，会 创建一个新的SqlSession对象，SqlSession对象中会有一个新的Executor对象。Executor对象中持有一个新的PerpetualCache对象；当会话结束时，SqlSession对象及其内部的Executor对象还有PerpetualCache对象也一并释放掉。

     b、如果SqlSession调用了close()方法，会释放掉一级缓存PerpetualCache对象，一级缓存将不可用。

     c、如果SqlSession调用了clearCache()，会清空PerpetualCache对象中的数据，但是该对象仍可使用。

      d、SqlSession中执行了任何一个update操作(update()、delete()、insert()) ，都会清空PerpetualCache对象的数据，但是该对象可以继续使用

  - 判断某两次查询是完全相同的查询:

    - mybatis认为，对于两次查询，如果以下条件都完全一样，那么就认为它们是完全相同的两次查询。

      a、传入的statementId

      b、查询时要求的结果集中的结果范围

      c、这次查询所产生的最终要传递给JDBC java.sql.Preparedstatement的Sql语句字符串（boundSql.getSql() ）

      d、传递给java.sql.Statement要设置的参数值

- 二级缓存
  >SqlSessionFactory层面上的二级缓存默认是不开启的，二级缓存的开席需要进行配置，实现二级缓存的时候，MyBatis要求返回的POJO必须是可序列化的。 也就是要求实现Serializable接口，配置方法很简单，只需要在映射XML文件配置就可以开启缓存了<cache/>。

  - 如果我们配置了二级缓存就意味着：

    a、映射语句文件中的所有select语句将会被缓存。

    b、映射语句文件中的所欲insert、update和delete语句会刷新缓存。

    c、缓存会使用默认的Least Recently Used（LRU，最近最少使用的）算法来收回。

    d、根据时间表，比如No Flush Interval,（CNFI没有刷新间隔），缓存不会以任何时间顺序来刷新。

    e、缓存会存储列表集合或对象(无论查询方法返回什么)的1024个引用

    f、缓存会被视为是read/write(可读/可写)的缓存，意味着对象检索不是共享的，而且可以安全的被调用者修改，不干扰其他调用者或线程所做的潜在修改。

>来源：https://www.cnblogs.com/happyflyingpig/p/7739749.html
