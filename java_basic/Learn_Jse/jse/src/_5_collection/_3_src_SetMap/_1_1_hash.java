package _5_collection._3_src_SetMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _1_1_hash {
    public static void main(String[] args) {
        // HashSet实际是HashMap：
        //      public HashSet() { map = new HashMap<>(); }
        //      public HashMap() { this.loadFactor = DEFAULT_LOAD_FACTOR; } // table为空，cap=0

        /* HashMap: 数组 + 单向链表 + 红黑树（见图片）
             数组: transient Node<K,V>[] table;

             static class HashMap.Node<K,V> implements Map.Entry<K,V> {
                  final int hash; // 每个节点存hash，用于添加新节点时，判断能否加入
                  final K key;
                  V value;
                  Node<K,V> next;
         */
        HashMap map  = new HashMap();

        map.put(123, null); // 类型：HashMap.Node
        map.put(456, null);
        map.put("abc", null);
        map.put("def", null);

        // 遍历：entrySet和存放的节点 的 声明类型，运行类型？
        Set entrySet = map.entrySet(); // 声明类型 Set
        System.out.println(entrySet.getClass()); // 运行类型 HashMap.EntrySet
        for (Object o : entrySet) {
            // Object转换为Map.Entry，便于使用getter获取k-v
            Map.Entry entry = (Map.Entry)o;  // 声明类型 Map.Entry
            System.out.println(entry.getClass() + ": " +  // 运行类型 HashMap.Node （是 Map.Entry的子类
                    entry.getKey() + " - " + entry.getValue());
        }
        // 实际上，entrySet()没有创建新节点
        // 创建的 EntrySet 中不包含属性，只提供了方法，这些方法直接作用于HashMap的属性（数组table及其节点）
    }
}
