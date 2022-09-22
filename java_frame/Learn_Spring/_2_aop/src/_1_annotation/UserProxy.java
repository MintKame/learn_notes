package _1_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect     // 增强类，会 生成代理对象
@Order(1)   // 对于一个方法，有多个增强类，设置增强类优先级（执行顺序，越小越先）
public class UserProxy {

    @Before(value = "execution(* _1_annotation.UserDao.add (..))")
    void before(){ // 增强
        System.out.println("before");
    }

    /* 增强到哪 (哪个类的哪个方法)
        切入点表达式：
            execution([权限修饰符] [返回类型（可省略）] [类全路径].[方法名]([参数列表]) )

            常用*（通配符）
                举例 1:对 com.atguigu.dao.BookDao 类里面的 add 进行增强
                execution(* com.atguigu.dao.BookDao.add(..))

                举例 2:对 com.atguigu.dao.BookDao 类里面的所有的方法进行增强
                execution(* com.atguigu.dao.BookDao.* (..))

                举例 3:对 com.atguigu.dao 包里面所有类,类里面所有方法进行增强
                execution(* com.atguigu.dao.*.* (..))
     */

    @After(value = "execution(* _1_annotation.UserDao.add (..))")
    void after(){
        System.out.println("after");
    }

    @AfterReturning(value = "execution(* _1_annotation.UserDao.add (..))")
    void afterReturn(){
        System.out.println("afterReturn");
    }

    @AfterThrowing(value = "execution(* _1_annotation.UserDao.add (..))")
    void afterThrow(){
        System.out.println("afterThrow");
    }

    @Around(value = "execution(* _1_annotation.UserDao.add (..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System. out.println("around之前");
        proceedingJoinPoint.proceed();      //被增强的方法执行
        System. out.println("around之后");
    }

    //! 切入点抽取
    // 作用：多个增强 增强到 同一个切入点 ----------------------------------
    @Pointcut(value = "execution(* _1_annotation.UserDao.remove (..))") // 定义一个函数，写上被抽取的切入点
    void userDaoRemove(){}

    @Before(value = "userDaoRemove()") // 带有被抽取的切入点的 函数名
    void beforeRemove(){
        System.out.println("before");
    }

    @After(value = "userDaoRemove()")
    void afterRemove(){
        System.out.println("after");
    }

}
