# 分布式事务公共模块说明
## 一些组内配置信息
nacos（注册中心和配置中心）`123.57.156.184:8848`

nacos管理平台 `http://123.57.156.184:8848/nacos/index.html` 用户名 `nacos` 密码 `bosstrainWP`

seata 123.57.156.184:8091

nacos和seata都配置使用了mysql，数据库 `123.57.156.184:3306` 用户名 `bosstrain` 密码 `Boss20Train@#$`

## 分布式事务一些基础概念

seata及AT模式 [官方文档-seata介绍](http://seata.io/zh-cn/docs/overview/what-is-seata.html)
[官方文档-AT模式](http://seata.io/zh-cn/docs/dev/mode/at-mode.html)

事务分组（与参数txServiceGroup对应） [官方文档-事务分组介绍](http://seata.io/zh-cn/docs/user/transaction-group.html)

seata的配置 [SpringCloud + Nacos集群 + Seata1.2.0 最新版集群](https://blog.csdn.net/wenjunlong88_easy/article/details/106913753)

seata示例 [官方示例代码](https://github.com/seata/seata-samples/blob/master/doc/quick-integration-with-spring-cloud.md#fileconf)

另：一个很简单的示例放在gitlab usage-example项目下

### 配置项说明

大部分都不需要进行修改，其中有两个要注意的地方：
application.yml中的seata.tx-service-group和seata.service.vgroupMapping

这两个地方都是指事物分组，之所以出现了两次，是因为一个是指定当前app所在事务分组，一个是配置事务分组的映射信息，
简单说前者是从后者获取对应的集群名，由于这里使用了file模式，所以出现了两次
组内集群默认都是default，所以这些配置也不需要更改

## 使用说明
- 在要使用的数据库添加AT模式需要的表
  - 执行 undo_log.sql
- 依赖项
```xml
        <!--Seata 包-->
        <dependency>
            <groupId>io.seata</groupId>
            <artifactId>seata-spring-boot-starter</artifactId>
            <version>1.2.0</version>
            <exclusions>
                <exclusion>
                    <groupId>io.seata</groupId>
                    <artifactId>seata-all</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>io.seata</groupId>
            <artifactId>seata-all</artifactId>
            <version>1.2.0</version>
        </dependency>
        <!-- druid -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
        </dependency>
```
- 修改application.yml中的数据源配置，改为自己的数据库
- 在application或者javaconfig类引入DataSourceProxyAutoConfiguration.class
```java
@Import(DataSourceProxyAutoConfiguration.class)
```
- 在需要开启分布式事务的方法上加上注解
```java
@GlobalTransactional(rollbackFor = Exception.class)
```

## 终
1. 涉及分布式事务的地方才开启全局事务，不然会影响性能
2. 做好服务层异常处理，远程服务上，如果全局事务被提交了再发生异常，那么远程的事务也不会被回滚
