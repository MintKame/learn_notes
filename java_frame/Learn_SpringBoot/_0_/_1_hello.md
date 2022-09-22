# 步骤
1. maven设置：
   + idea设置为本地maven：
     + setting — build_tools — maven
       + home-dir：maven下载目录
       + user-settings-file：maven/conf/settings.xml
   + maven/conf/settings.xml，添加（见后）

2. pom.xml：parent，dependency，build 
3. MainApplication.java
4. XxxController.java 
5. 测试：直接运行main方法  
6. 自动配置：application.properties
    + 统一配置all（tomcat，springMVC...
    + 都有默认值

+ 简化：Spring Initailizr（项目初始化向导）自动完成 1-3

# 原理
    
+ 依赖管理，简化部署：见 _1_的 pom.xml 

+ 自动配置：见 _2_

```xml
<mirrors>
    <!--aliyun mirror-->
    <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>central</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
</mirrors>

<profiles>
    <!--compiler jdk version-->
    <profile>
        <id>jdk-1.8</id>
        <activation>
            <activeByDefault>true</activeByDefault>
            <jdk>1.8</jdk>
        </activation>
        <properties>
            <maven.compiler.source>1.8</maven.compiler.source>
            <maven.compiler.target>1.8</maven.compiler.target>
            <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
        </properties>
    </profile>
</profiles> 
```
