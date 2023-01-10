package _5_collection._3_src_SetMap;

import java.util.HashSet;

public class _1_4_hash_tree {
    static class ObjA{ public int hashCode() {return 100;}} // 所有对象，索引相同；但因不equals，可以加上

    public static void main(String[] args) {

        // 树化：add后，某条链表元素个数 > TREEIFY_THRESHOLD(8)，
        //      且table cap大小 >= TREEIFY_CAPACITY(64)
        //      若链表元素个数>8，但table cap不足，则不树化，而是扩容2倍，目的是分散node，使链表长度减少

        // case 2: 在一个索引上加node
        HashSet set = new HashSet();
        for (int i = 1; i <= 8; i++) {
            set.add(new ObjA());
        }                    //   添加后
        set.add(new ObjA()); // a 链表长度9 >8，cap=16<64，table扩容到32,
        set.add(new ObjA()); //   链表长度10>8，cap=32<64，table扩容到64
        set.add(new ObjA()); // b 链表长度11>8，cap=64>=64，树化
        // 节点运行类型 HashMap$Node => HashMap$TreeNode

        /* 简化版
            final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
            Node<K,V>[] tab; Node<K,V> p; int n, i;

            if ((tab = table) == null || (n = tab.length) == 0)
                n = (tab = resize()).length;

            if(index元素为空)...
            else {
                Node<K,V> e; K k;
                if(新节点与index元素相同) ...
                else if(index元素为树) ...
                else { // ab: index元素为链表
                    for (int binCount = 0; ; ++binCount) {
                        if ((e = p.next) == null) { // ab 添加到链表
                            p.next = newNode(hash, key, value, null);
                            if (binCount >= TREEIFY_THRESHOLD - 1)
                                // binCount:     a 7 | b 9
                                // 添加后链表长度: a 9 | b 11
                                treeifyBin(tab, hash); // a 扩容 | b 树化
                            break;
                        }
                        if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    } // end for
                }// end else

                if (e != null) {
                    ...
                    return oldValue;
                }
            }
            if (++size > threshold) resize();
            return null;
        } */

        /* 树化或扩容
            final void treeifyBin(Node<K,V>[] tab, int hash) {
            int n, index; Node<K,V> e;

            // tab.length a 16 | b 64
            if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY) // 64
                resize(); // a cap未到64，先不树化，而是扩容
            else if ((e = tab[index = (n - 1) & hash]) != null) { // b 树化
                TreeNode<K,V> hd = null, tl = null;
                do {
                    TreeNode<K,V> p = replacementTreeNode(e, null);
                    if (tl == null)
                        hd = p;
                    else {
                        p.prev = tl;
                        tl.next = p;
                    }
                    tl = p;
                } while ((e = e.next) != null);
                if ((tab[index] = hd) != null)
                    hd.treeify(tab);
                }
            }
         */
    }
}
