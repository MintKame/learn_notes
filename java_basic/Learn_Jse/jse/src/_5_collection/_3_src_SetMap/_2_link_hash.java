package _5_collection._3_src_SetMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class _2_link_hash {
    // LinkedHashSet 的底层 LinkedHashMap

    /* LinkedHashMap: hash表（数组 + 单向链表 + 红黑树） + 双向链表 （见图片）
        作为HashMap的子类，继承了HashMap的hash表：HashMap.Node[] table

        // 所有节点串成双向链表,记录节点加入的顺序
        static class LinkedHashMap.Entry<K,V> extends HashMap.Node<K,V> {
                LinkedHashMap.Entry<K,V> before, after;

        // 双线链表的首尾
        transient LinkedHashMap.Entry<K,V> head;
        transient LinkedHashMap.Entry<K,V> tail;
     */


    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        LinkedHashMap map;
        //  map = new LinkedHashMap<>(16, .75f); // 初始cap=16，加载因子为0.75

        set.add(123);
        set.add(456);
        set.add(789);
        /* 有序（加入顺序）
             调用HashMap的putVal
             不同之处：newNode()调用linkNodeLast(p)；节点会链接到双向链表，记录加入顺序
         */

    }
}
