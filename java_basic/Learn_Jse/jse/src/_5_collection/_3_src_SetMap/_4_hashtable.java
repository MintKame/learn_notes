package _5_collection._3_src_SetMap;

import java.util.Hashtable;

public class _4_hashtable {
    // Hashtable：使用方法基本同HashMap
    //          key, value 都不能为null
    // 子类:Properties(见IO
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        /*
            public Hashtable() { this(11, 0.75f); }  // cap=11，加载因子为0.75

            数组：private transient Entry<?,?>[] table;
            private static class Hashtable.Entry<K,V> implements Map.Entry<K,V> {
                final int hash;
                final K key;
                V value;
                Entry<K,V> next;
         */
        table.put("123", "123");
        /*
            1.确保v非空：if (value == null) { throw new NullPointerException(); }
            2.若key存在，覆盖并返回旧value
            3.addEntry：count >= threshold，则rehash
                newCapacity = (oldCapacity << 1) + 1
                重新放置节点
            4.创建并放入新entry
         */
    }
}
