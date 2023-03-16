## spring-jdbc模块是为了契合DataSource多数据源的切换
- Spring中提供的基础类
    - 继承AbstractRoutingDataSource
    - 实现DataSource

![img.png](img.png)
```javascript
// 从上述图片分析：抽象类AbstractDataSource是Spring框架的DataSource类的默认实现
// 数据库操作方面集中于 spring-jdbc 依赖

```


```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;
/**
 * 根据application.xml配置属性来装配DataSource数据源
 */
@Bean
@ConfigurationProperties(prefix = "spring.datasource.datasource1")
public DataSource dataSouce(){
    return new DruidDataSource();
}
```
### 切换数据源的两种方式
- mybatis 插件的形式（应用场景：读写分离）
- AOP + 自定义注解 的方式 切换数据源