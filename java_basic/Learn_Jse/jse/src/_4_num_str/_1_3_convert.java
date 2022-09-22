package _4_num_str;

public class _1_3_convert {
    public static void main(String[] args) {

        Integer integer = 1;

        //auto: after jdk1.5(include)
        //拆箱 int <- Integer
        int num1 = integer.intValue();
        int num2 = integer; // auto: 底层为 integer.intValue()

        //装箱 int -> Integer
        Integer integer0 = new Integer(1);
        Integer integer1 = Integer.valueOf(123);
        /*
            public static Integer valueOf(int i) {
                // 常缓存：-128 ~ 127
                if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
                    return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
                return new Integer(i);
            }
        */
        Integer integer2 = 123; // auto: 底层为  Integer.valueOf(123)

        //! result?
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b); // F, different obj

        Integer c = 1;
        Integer d = 1;
        System.out.println(c == d); // T: Integer.valueOf(1), from cache, same obj

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f); // F: Integer.valueOf(128), create diff obj

        int g = 128;
        Integer h = 128;
        System.out.println(g == h); // T: 先转化为int，再比较值

        //! different ?
        Object obj1, obj2;

        obj1 = true ? new Integer(1) : new Double(2.0);

        if (true) obj2 = new Integer(1);
        else obj2 = new Double(2.0);

        System.out.println(obj1.getClass()); // Double
        System.out.println(obj2.getClass()); // Integer
        // reason: 三元运算作为一个整体，类型转换为Double

    }
}
