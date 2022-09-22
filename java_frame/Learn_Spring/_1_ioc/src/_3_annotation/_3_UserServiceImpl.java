package _3_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class _3_UserServiceImpl implements _3_UserService {
// 2. 注解: 注入属性，不用定义setter
    //! 注入非对象
    @Value(value = "user service")
    String serviceName;

    //! 注入对象 （userDao：多种方式，见下
    /** 1 Autowired：
     *      根据 属性类型，注入 已创建的该类的对象
     *      若属性类型为Interface，会找它的实现类来注入
     *      问题：Interface有多个实现类
     *      解决：见2   */
//    @Autowired
//    _3_UserDao userDao;

    /** 2 Qualifier：
     *      根据 属性名, 注入
     *      和 @Autowired 一起用    */
//    @Autowired
//    @Qualifier(value = "hahaha")
//    _3_UserDao userDao;

    /** 3 Resource：不推荐，非spring提供
     *      可以根据类型注入
     *      可以根据名称注入   */
//    @Resource //根据类型注入
//    _3_UserDao userDao;

    @Resource(name = "hahaha") //根据名称注入
    _3_UserDao userDao;


    public void add() {
        System.out.println("welcome to " + serviceName);

        System.out.println("Service add");

        if(userDao != null)
            userDao.add();
        else
            System.out.println("dao is null!");
    }
}
