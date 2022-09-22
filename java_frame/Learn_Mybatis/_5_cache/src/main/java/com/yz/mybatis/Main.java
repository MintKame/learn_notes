package com.yz.mybatis;

import com.yz.mybatis.mapper.StudentMapper;
import com.yz.mybatis.pojo.Student5;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    SqlSessionFactory factory = null;

    {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* 缓存

     失效
         1.两次查询间，执行增删改，一二级都清除（与表数据库是否变化无关，取决于执行某些sql）
                每个增删改标签：flushCache="true"（默认）。若设置为false，则执行后不清除一二级缓存
                查询标签也可以设置（会清缓存），但无意义
         2.sqlSession相同，sqlSession.clearCache()。清除一级缓存（不影响二级）

     第三方缓存：(见官方文档)
         1）导入第三方缓存包
         2）导入用于整合三方cache的 适配包 (官方提供)
         3）mapper.xml中使用三方缓存
            <cache type="org.mybatis.caches.ehcache.EhcacheCache"></cache>
     */

    /* 一级缓存（本地缓存）
        每个session会话对应一个

        禁用一级缓存：
            config-setting：localCacheScope = STATEMENT（默认SESSION，即开启一级缓存）
     */
//    @Test
    void cache_session() throws IOException {
        SqlSession session = factory.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);

        Student5 student1 = studentMapper.findStudentById(1); // 一级缓存未命中，查数据库，存到一级缓存
        Student5 student2 = studentMapper.findStudentById(1); // 一级缓存  命中
        System.out.println(student1 == student2); // true

        session.close();
    }

    /* 二级缓存（全局缓存）
        每个namespace（mapper.xml文件的id）对应一个，可不同session间
        需要配置（以下设置只影响二级缓存）：
            config-setting： 开启CacheEnable（默认）
            Mapper.xml：     配置 cache
                             select语句,useCache=true（默认）
            pojo实现序列化接口   */
//    @Test
    void cache_namespace() throws IOException {
        SqlSession session1 = factory.openSession();
        StudentMapper mapper1 = session1.getMapper(StudentMapper.class);
        Student5 student1 = mapper1.findStudentById(1); // 二级一级缓存未命中，查数据库，存到一级
        session1.close(); // 关闭session后，一级缓存 存到 二级

        SqlSession session2 = factory.openSession();
        StudentMapper mapper2 = session2.getMapper(StudentMapper.class);
        Student5 student2 = mapper2.findStudentById(1); // 二级缓存 命中
        session2.close();

        System.out.println(student1 == student2); // false
    }
}