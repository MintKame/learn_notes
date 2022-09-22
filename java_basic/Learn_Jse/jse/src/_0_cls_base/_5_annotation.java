package _0_cls_base;

/*
annotation = metadata
    to 修饰pkg, cls, member, ctor, local var
    不影响程序逻辑，but可被编译或运行
*/

public class _5_annotation {
    // 常见*3:
    @Deprecated()
    @SuppressWarnings({"all"})
    @Override
    public String toString() { return super.toString(); }

    // 查看注解源码，类型为@interface，注解类

    /*      元注解：用于修饰注解的注解
        Documented  注解在javadoc体现
        Retention   注解的作用范围（SOURCE, CLASS, RUNTIME）表示注解保存至源代码，.class编译文件，运行文件
        Target      注解的使用位置（CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE）
        Inherited   eg. 修饰注解a，某个类使用注解a，子类会继承注解a
    */


    /*      常见注解*3:
        Deprecated: 元素（类，方法）过时，用于新旧版本兼容和过渡
            @Documented
            @Retention(RetentionPolicy.RUNTIME)
            @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})

        SuppressWarnings: 抑制编译器警告，{""}写入抑制的信息类型
            @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
            @Retention(RetentionPolicy.SOURCE)

        Override: compiler检查，方法需要Override父类方法
            @Target(ElementType.METHOD) // 只可以修饰方法
            @Retention(RetentionPolicy.SOURCE)
    */
}