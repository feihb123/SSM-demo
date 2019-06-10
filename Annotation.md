### SSM 中常用注解：
1. **@Autowired**
    
    - @Autowired顾名思义，就是自动装配，其作用是为了消除代码Java代码里面的getter/setter与bean属性中的property。
    
    - @Autowired默认按类型匹配的方式，在容器查找匹配的Bean，当有且仅有一个匹配的Bean时，Spring将其注入@Autowired标注的变量中。
    - @Autowired默认情况下必须要求依赖对象必须存在，如果要允许null值，可以设置它的required属性为false，如@Autowired(required=false) 
2. **@Resource**
    - @Resource的作用相当于@Autowired
    - @Autowired按byType自动注入
    - @Resource默认按 byName自动注入
    
    - @Resource有两个属性是比较重要的，分是name和type，Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。
    - @Resource装配顺序
　　(1). 如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
　　(2). 如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
　　(3). 如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
　　(4). 如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配
3. **@Autowired和@Resource区别**
    - 用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，并用于构建bean定义，初始化Spring容器。

4. **@Configuration**
    - 如果容器中有一个以上匹配的Bean，则可以通过@Qualifier注解限定Bean的名称
    - 用法：直接在@Autowired下方@Qualifier("bean")
5. **@Component**
    - 把普通pojo实例化到spring容器中，相当于配置文件中的
```xml
       <bean id="" class=""/>
```
6. **@Controller**
    - 在控制层使用（controller层）
    - 标识一个Spring类是Spring MVC controller处理器
    - 返回的内容就是对应的页面
7. **@RestController**
    - @RestController是@Controller和@ResponseBody的结合体
    - 如果使用@RestController注解Controller，则Controller中的方法无法返回页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是return里的内容。(一般返回JSON内容)
8. **@Service**
    - 在业务逻辑层使用（service层）
    - 自动根据bean的类名实例化一个首写字母为小写的bean
    - 例如Bean实例化为bean，自定义名字名字:@Service("name")
9. **@Repository** 
    - 在数据访问层使用（dao层）
    - @Repository用于标注数据访问组件，即DAO组件
10. **@Mapper** 
    - 代替Mybatis的mapper映射文件
    - 把mapper这个DAO交給Spring管理
    - 自动根据一个添加@Mapper注解的接口生成一个实现类 


11. **@Scope**
    - 值有:singleton,prototype,request,session,globalSession
    - request，session和global session类型只适用于web程序
    - singleton：表明容器中创建时只存在一个实例，所有引用此bean都是单一实例（即单例模式）。
    - prototype：spring容器在进行输出prototype的bean对象时，会每次都重新生成一个新的对象给请求方（即原型模式）。
    - request：spring容器中XmlWebApplicationContext会为每个HTTP请求创建一个全新的RequestPrecessor对象，当请求结束后，该对象的生命周期即告结束。
    - session：Spring容器会为每个独立的session创建属于自己的全新的。UserPreferences实例，比request scope的bean会存活更长的时间。
    - globalSession：global session只有应用在基于porlet的web应用程序中才有意义，它映射到porlet的global范围的session，如果普通的servlet的web 应用中使用了这个scope，容器会把它作为普通的session的scope对待。
 
12. **@PostConstruct**
    - 相当于init-method,使用在方法上，当Bean初始化时执行。

13. **@PreDestroy**
    - 相当于destory-method，使用在方法上，当Bean销毁时执行。

14. **@Lazy**
    - 表示懒加载，即延迟初始化

15. **@Qualifier**
    - 如果容器中有一个以上匹配的Bean，则可以通过@Qualifier注解限定Bean的名称
    - 用法：直接在@Autowired下方@Qualifier("bean")

16. **@Primary**
    - 作用与@Qualifier类似
    - 如果容器中有一个以上匹配的Bean，则注入@Primary注解的类

17. **@Async**
    - 基于@Async标注的方法，称之为异步方法
    - 这些方法将在执行的时候，将会在独立的线程中被执行，调用者无需等待它的完成，即可继续其他的操作。

### 注解applicationContext配置：
1.使用annotation-config
```xml
    <context:annotation-config/>
```
- 是用于激活那些已经在spring容器里注册过的bean上面的注解。
- (无论是通过xml的方式还是通过package sanning的方式)

2.使用component-scan
```xml
<context:component-scan base-package="" />
```
- component-scan除了具有annotation-config的功能之外，
- component-scan还可以在指定的package下扫描以及注册javabean 