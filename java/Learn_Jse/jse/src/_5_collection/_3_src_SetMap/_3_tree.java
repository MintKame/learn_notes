package _5_collection._3_src_SetMap;

import java.util.*;

public class _3_tree {
    public static void main(String[] args) {
        List list = Arrays.asList("a", "boy", "c", "different", "easy");
        // TreeSet，TreeMap：有序（小到大） ===============================
        // 无参ctor，按照加入元素的compareTo()排序
        TreeSet set1 = new TreeSet();
        for (Object o : list) {set1.add(o);}
        System.out.println(set1); // 按字符串比较排序 [a, boy, c, different, easy]

        // 有参ctor，按照传入的比较方式排序
        TreeSet set2 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        for (Object o : list) {set2.add(o);}
        System.out.println(set2); // 按字符串长度排序 [a, boy, easy, different]

        // 去重 ===============================
        //      hashMap：根据hash和equals去重
        //      treeMap：传入的comparator 或 Comparable接口的方法，返回0则需要去重
        set1.add(new Object()); // exception: set1没传入comparator，且添加的元素未实现Comparable接口



        /*
        public V put(K key, V value) {
            Entry<K,V> t = root;  // 第一次添加，设置为root
            if (t == null) {
                compare(key, key); // type (and possibly null) check
                root = new Entry<>(key, value, null);
                size = 1;
                modCount++;
                return null;
            }
            int cmp;
            Entry<K,V> parent;

            // split comparator and comparable paths
            // 按传入的比较方式 ==========================================
            Comparator<? super K> cpr = comparator;
            if (cpr != null) {
                do { // 加入到树中合适位置
                    parent = t;
                    cmp = cpr.compare(key, t.key); // 动态绑定，调用创建map时定义的compare函数
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else
                        return t.setValue(value); // key相等，不加入新节点，覆盖原来的值
                } while (t != null);
            }
            // 按加入元素实现的Comparable接口的compareTo() ===========================================
            else {
                if (key == null)
                    throw new NullPointerException();
                @SuppressWarnings("unchecked")
                // ex: 添加的元素未实现Comparable接口
                    Comparable<? super K> k = (Comparable<? super K>) key;
                do {
                    parent = t;
                    cmp = k.compareTo(t.key);
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else
                        return t.setValue(value); // key相等，不加入新节点，覆盖原来的值
                } while (t != null);
            }
            // 退出循环时，t为null，parent为新节点的parent ===========================
            Entry<K,V> e = new Entry<>(key, value, parent);
            if (cmp < 0)
                parent.left = e;
            else
                parent.right = e;
            fixAfterInsertion(e);
            size++;
            modCount++;
            return null;
        }
         */

    }
}
