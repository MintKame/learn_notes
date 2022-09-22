package _4_tool;

import org.junit.jupiter.api.Test;

public class _3_junit {
    /*
        JUnit：java的单元测试框架
        优点：测试代码不用全部写在main，不用来回切换，可以直接run/debug一个函数
     */
    // 引入JUnit 5
    int a = 1;

    @Test // 非静态函数，调用前先创建一个对象
    public void test1(){
        System.out.println("test1: a=" + a);
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }
}
