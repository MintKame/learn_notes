package _5_collection._3_src_SetMap;

import java.util.HashSet;
import java.util.Set;

public class _1_3_hash_inc {
    static class ObjA{ public int hashCode() {return 100;}} // 所有对象，索引相同；但因不equals，可以加上
    static class ObjB{ public int hashCode() {return 200;}}

    public static void main(String[] args) {
        // 扩容: cap 0 -> 16（首次add）
        //             -> *2（add后，元素个数size > threshold=cap*loadfactor（0.75）// 此处size包含链表和树上的node
        //                  （或add后，某链表长度>8，但不满足树化条件table不到64）

        // threshold：防止突然大量add，造成阻塞

        // case 1: 分别在两个索引加6,7个node（只看扩容，避免树化）
        HashSet set  = new HashSet();
        set.add(new ObjA()); // a 首次扩容到16
        for (int i = 2; i <= 6; i++) {
            set.add(new ObjA());
        }
        for (int i = 7; i <= 12; i++) {
            set.add(new ObjB());
        }
        set.add(new ObjB()); // b 第13个node > thr，扩容cap到32

        /* 简化版（关注三处123），具体版见 _1_1_hash_same

            final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;

            //1.a 第一次扩容 到 16个cap
            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;

            if(index元素为空)... // a
            else {
                Node<K,V> e; K k;
                if(新节点与index元素相同) ...
                else if(index元素为树) ...
                else { // b加到链表，不树化
                    // index元素为链表 ...
                }

                // 2. 旧node e非空，e与新node相同：
                if (e != null) { // existing mapping for key
                    // 把 e的value 替换为 新node的value
                    // size 未变，返回不考虑扩容
                    return oldValue;
                }
            }

            //3.b 到达临界值，扩容
            if (++size > threshold) resize();

            return null;
        }
         */

        /* 扩容
            final Node<K,V>[] resize() {
            Node<K,V>[] oldTab = table;
            int oldCap = (oldTab == null) ? 0 : oldTab.length; // a 0 | b 16
            int oldThr = threshold; // a 0 | b 12
            int newCap, newThr = 0;

            获取newCap，newThr ==========================================
            if (oldCap > 0) {
                if (oldCap >= MAXIMUM_CAPACITY) {
                    threshold = Integer.MAX_VALUE;
                    return oldTab;
                }
                else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                         oldCap >= DEFAULT_INITIAL_CAPACITY)
                    // b newCap=32 newThr=24
                    newThr = oldThr << 1; // double threshold
            }
            else if (oldThr > 0) // initial capacity was placed in threshold
                newCap = oldThr;
            else {               // zero initial threshold signifies using defaults
                // a newCap=16 newThr=12
                newCap = DEFAULT_INITIAL_CAPACITY; // 16
                newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); // 16*0.75
            }

            if (newThr == 0) {
                float ft = (float)newCap * loadFactor;
                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                          (int)ft : Integer.MAX_VALUE);
            }
            重建table，元素新位置？ ====================================================
            threshold = newThr;
            @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
            table = newTab;

            // a: table为null，不需要重新放置旧node
            if (oldTab != null) {
                for (int j = 0; j < oldCap; ++j) {
                    Node<K,V> e;
                    if ((e = oldTab[j]) != null) { // 遍历table所有非空元素e
                        oldTab[j] = null;

                        // 1. 单个node：计算新index，放入
                        //    因为扩容后新index为：旧index(+oldCap)，不可能索引到有元素的位置
                        if (e.next == null)
                            newTab[e.hash & (newCap - 1)] = e;

                        // 2. 红黑树
                        else if (e instanceof TreeNode)
                            ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);

                        // 3. 链表: 由于扩容为2倍，索引为i处的node，新索引只可能为 i（+oldCap）
                        // 对于b 重置数组后，仍在两个index，因为每个类的所有obj相同hash
                        else { // preserve order
                            Node<K,V> loHead = null, loTail = null; // 记录 索引为i
                            Node<K,V> hiHead = null, hiTail = null; // 记录 索引为（i + oldCap）
                            Node<K,V> next;
                            do {
                                next = e.next;
                                if ((e.hash & oldCap) == 0) { // 索引为i
                                    if (loTail == null)
                                        loHead = e;
                                    else
                                        loTail.next = e;
                                    loTail = e;
                                }
                                else { // 索引为（i + oldCap）
                                    if (hiTail == null)
                                        hiHead = e;
                                    else
                                        hiTail.next = e;
                                    hiTail = e;
                                }
                            } while ((e = next) != null);
                            if (loTail != null) { // 放到 索引i处
                                loTail.next = null;
                                newTab[j] = loHead;
                            }
                            if (hiTail != null) { // 放到 索引（i + oldCap）处
                                hiTail.next = null;
                                newTab[j + oldCap] = hiHead;
                            }
                        }
                    }
                }
            }
            return newTab;
        }
         */
    }
}
