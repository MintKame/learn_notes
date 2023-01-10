package _5_collection._3_src_SetMap;

import java.util.HashSet;
import java.util.Objects;

public class _1_2_hash_same {

    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("hello");
        set.add("hello"); // fail：同一obj

        set.add(new String("world"));
        set.add(new String("world")); // fail
        // 不同obj，但String重载了 hashCode() equals()，使得相同内容的string，add时判定为相同

        set.add(new Obj1("aaa"));
        set.add(new Obj1("aaa")); // success
        // 内容一致的不同obj，没有重载 hashCode() equals()
        // hashCode每个对象都不同 => index 不一定相同
        // equals 不同 => 可以加入

        set.add(new Obj2("bbb"));
        set.add(new Obj2("bbb")); // fail
        // 内容一致的不同obj，重载 hashCode() equals()，根据name计算
        // so，相同name的Obj2： hashCode()相同（hash，index相同）， equals()为true => 不可加入

        //! 特：某个类A 含有属性（自定义类B）的对象
        // 类A和B都需要重载 hashCode() equals()
        // eg，A重载，B没重载，对于内容一致的a1和a2，分别含有内容一致的b1和b2（不同对象）
        //       b1b2的 hashCode 不同，导致 a1a2的hashCode不同
        //       b1.equals(b2)为false，导致a1a2也为false（A的equals调用了B的equals，而B的equals等价于==）

        System.out.println(set); // [Obj2(bbb), world, Obj1(aaa), hello, Obj1(aaa)]
        // 无序 不可重复 至多1个null

        /* add:
            public boolean add(E e) { return map.put(e, PRESENT)==null; }
            // HashSet 属性PRESENT用于占位：
            //      private static final Object PRESENT = new Object();

            public V put(K key, V value) { return putVal(hash(key), key, value, false, true); }
            // 计算：hashCode -> hash -> index
            // 计算hash(key): (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

            final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
                Node<K,V>[] tab; Node<K,V> p; int n, i;
                if ((tab = table) == null || (n = tab.length) == 0)
                    n = (tab = resize()).length;

                // 1. index处的元素赋给p
                // 无元素，直接放入
                if ((p = tab[i = (n - 1) & hash]) == null)
                    tab[i] = newNode(hash, key, value, null);

                // 2. index有元素
                else {
                    Node<K,V> e; K k; // tips: 需要局部变量时，再创建

                    // 2.1 index的元素 与新node 相同（hash相同 && equals），不加入
                    if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                        e = p;

                    // 2.2 index的元素 为 红黑树
                    else if (p instanceof TreeNode)
                        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);

                    // 2.3 index的元素 为 链表，遍历链表
                    else {
                        for (int binCount = 0; ; ++binCount) { // 死循环

                            // 2.3.1 全都与新node不同，添加到链表
                            if ((e = p.next) == null) {
                                p.next = newNode(hash, key, value, null);
                                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                    treeifyBin(tab, hash);
                                break;
                            }

                            // 2.3.2 出现 与新node 相同的节点，退出遍历
                            if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                                break;
                            p = e;
                        }
                    }

                    // 3. e非空，表示出现： 与新node 相同的节点
                    // 把 e的value 替换为 新node的value
                    if (e != null) { // existing mapping for key
                        V oldValue = e.value;
                        if (!onlyIfAbsent || oldValue == null)
                            e.value = value;
                        afterNodeAccess(e);
                        return oldValue;
                    }
                }
                ++modCount;
                if (++size > threshold)
                    resize();
                afterNodeInsertion(evict);
                return null;
            }
         */

    }
}
