package _5_collection._1_usage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class _0_collection {


    public static void main(String[] args) {
        Collection collection = new ArrayList();

        // 增加
        // 能否加入重复obj，取决于是list还是set
        collection.add("abc");
        collection.add(123); // int -> Integer
        System.out.println(collection); // [abc, 123]

        Collection collection2 = new ArrayList();
        collection2.add("aabc");
        collection2.add(1234);

        collection.addAll(collection2);
        System.out.println(collection); // [abc, 123, aabc, 1234]

        // 信息
        System.out.println("size:" + collection.size()); // 4
        System.out.println("contains:" + collection.contains("def")); // false
        System.out.println("containsAll:" + collection.containsAll(collection)); // true
        System.out.println("isEmpty:" + collection.isEmpty()); // false

        // 删
        collection.remove(123);
        System.out.println(collection); // [abc, aabc, 1234]

        collection.clear();
        collection.removeAll(collection); // 相当于clear
        System.out.println(collection); // []
    }
}
