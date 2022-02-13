#### 参考案例 https://segmentfault.com/a/1190000040510401

##### SPI 机制
service provider interface 面向接口
- 使用 `ServiceLoader` ，找寻 `Meta-INF/services` 下文件
- 改文件名字 必须和 provider 全名一直（包含package）
- 该机制应用 springboot 自动装配中的 `@EnableConfiguration`

##### Spring Boot 自动装配原理

举例子： `spring-boot-starter-data-redis`

- 放在spring-boot-autoconfigura的组件中
    - autoconfiguration 下面有个`spring.factories`的文件
  ![](https://segmentfault.com/img/remote/1460000040510407)
    - 查看autoconfig 在 `EnableAutoConfiguration`下 自动装载特别多springboot其他组件
    - 往下翻一下， 能够找到 `RedisAutoConfiguration`
    - 在 `RedisAutoConfiguration`类 中 有生成`@Bean`  `redisTemplate`
##### Spring中的一些注入方式
- 通常有 `@Component，@Bean`
- 比如：`EnableAsync`开启异步 如何生效？
  - 利用 `@Import`， 它有三中方式
    - 普通`@Import` ，比如某些类没法被 注入到spring容器中，可以通过某个`@Configuration`类上面天界 `@Import` 注入
    - 实现`ImportSelector`接口，当Spring扫描到，将会调用`selectImports`方法，将`selectImports`中返回的String数组中的类注入到容器中批量注入
    - 实现`ImportBeanDefinitionRegistrar`接口 当Spring扫描到该类时，将会调用`registerBeanDefinitions`方法
![](https://segmentfault.com/img/remote/1460000040510412)
    - `EnableAutoConfiguration`本质上也是 import注入
    - `importSelector` 会获取 `getAutoConfigurationEntry` - entry 去哪里获取呢？
    - 来自 `META-INF/spring.factories`
    - 就是加载配置文件，并且读取key为`EnableAutoConfiguration`的配置
