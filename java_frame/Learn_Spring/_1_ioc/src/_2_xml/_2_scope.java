package _2_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class _2_scope {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("_2_xml/_2__scope.xml");

        // 2次获取同一bean（相同id）单例
        final _2_scope a1 = context.getBean("a", _2_scope.class);
        final _2_scope a2 = context.getBean("a", _2_scope.class);
        System.out.println(a1 + "    " + a2); // 同一obj

        // 2次获取同一bean（相同id）多例
        final _2_scope b1 = context.getBean("b", _2_scope.class);
        final _2_scope b2 = context.getBean("b", _2_scope.class);
        System.out.println(b1 + "    " + b2); // 不同obj
    }
}
