+ 作用：spring对jdbc进行封装，更方便操作db

# transaction

添加到 Service层 (业务逻辑层)

+ eg：转账

    + 数据库操作 dao（钱增加，钱减少）

    + 业务操作 service（调用dao的两个方法）

+ 2种方式, 实现事务管理:

    + 编程式事务管理: 对于每个事务, 都要写代码, 来处理事务

    + **声明式事务管理**: 通过配置, 增强代码, 来处理事务 (底层: AOP
        + **基于 注解**
        + 基于 xml

# 使用流程

## crud

+ 创建对象 + 注入属性（以下四个类为包含关系）

    + dataSource，jdbcTemplate，xxxDao，xxxService
    + 其中：
      + 自定义类：xml / **注解（需xml中设置组件扫描）**     
      +   其他类：xml / config类注解  


+ java 定义: 
  + dao 增删改查 (使用 JDBCTemplate
  + service 业务逻辑 (使用 dao
   
## transaction  

+ 先完成 crud 的步骤


+ 基于注解: 
  + xml / config类注解 (见_1_)
    + 创建事务管理器，注入dataSource
    + 开启事务注解
  + java: service 方法/类 上: Transaction注解, 添加事务处理


+ 基于xml
    + xml (见_1_)
        + 创建事务管理器，注入dataSource 

    + xml: 利用aop增强, 添加事务处理 



+ 测试: service有/无异常 * eg123
  + eg1 最常用

  + eg1,2见 `_2_transaction`, 两个eg只有文件 `_1_`不同

  + eg3 见 `_3_transaction_xml`

      |                                | eg1  | eg2          | eg3     |
      | ------------------------------ | ---- | ------------ | ------- |
      | bean: dataSource，jdbcTemplate | xml  | config类注解 | xml     |
      | 开启组件扫描  (为了下一步)   | xml  | config类注解 | xml     |
      | bean: Dao，Service             | 注解 | 注解         | 注解    |
      | bean: 事务管理器               | xml  | config类注解 | xml     |
      | 开启事务注解 (为了下一步)  | xml  | config类注解 | -       |
      | 设为事务                       | 注解 | 注解         | **xml** |




