package _5_collection._1_usage;

import java.util.*;

public class _3_1_map {
    public static void main(String[] args) {
        Map map  = new HashMap();

        // 增
        map.put(123, null);
        map.put("abc", null);
        map.put("abc", "abc");// key不可重复，替换之前的value
        map.put(null, 123);
        map.put(null, 456); // key至多1个null，替换之前的value
        map.put("def", null); // value可以重复,  可以多个null
        System.out.println(map); // 无序 {null=456, abc=null, def=null, 123=123}

        // 删
        map.remove(null);
        // map.clear();
        System.out.println(map);

        // 查
        if (map.containsKey("abc"))
            System.out.println(map.get("abc")); // abc
        System.out.println(map.size()); // 3
        System.out.println(map.isEmpty()); // F

        //! 遍历 （it，增强） *（keyset，values，entrySet）======================
        Set keySet = map.keySet(); // 声明类型 Set
        System.out.println(keySet.getClass()); // 运行类型 HashMap$KeySet
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next(); // 运行类型取决于每个key
            System.out.println(next + " - " + map.get(next));
        }

        Collection values = map.values();// 声明类型 Collection
        System.out.println(values.getClass()); // 运行类型 HashMap$Values
        for (Object o :values) { // 运行类型取决于每个value
            System.out.println(o);
        }

        Set entrySet = map.entrySet();// 声明类型 Set
        System.out.println(entrySet.getClass()); // 运行类型 HashMap$EntrySet
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry)o; // 转换为Entry，便于使用getter获取k-v
            // 运行类型 HashMap$Node
            System.out.println(entry.getClass() + ": " +
                    entry.getKey() + " - " + entry.getValue());
        }
    }
}
