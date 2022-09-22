package _5_collection._1_usage;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _2_set {
    public static void main(String[] args) {
        Set set  = new HashSet();
        set.add(123);
        set.add("abc");
        set.add("abc"); // 不可重复
        set.add(null);
        set.add(null); // 至多1个null
        System.out.println(set);
        // [null, abc, 123] 无序
        // 无序但是固定，取决于再如何存储

        // 特：见 _3_2_map
        //LinkedHashSet，LinkedHashMap 有序（加入顺序）
        //TreeSet，TreeMap有序（按大小）

        //! 遍历==========================================
        System.out.println("=====================");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        System.out.println("=====================");
        for (Object o : set) {
            System.out.println(o);
        }

    }
}
