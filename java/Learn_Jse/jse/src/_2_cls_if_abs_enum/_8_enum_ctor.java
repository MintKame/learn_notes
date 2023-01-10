package _2_cls_if_abs_enum;

enum A{
    a, b;
    private A(){
        System.out.println("aaa"); // 对于enum的每个单例，都会执行
    }
}


public class _8_enum_ctor {
    public static void main(String[] args) {
        System.out.println(A.a);
    }
}

/* 结果：
    aaa
    aaa
    a
 */