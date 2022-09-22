package _5_collection._1_usage;

import java.util.*;

public class _4_collections {
    public static void main(String[] args) {
        String[] arr = {"a", "boy", "c", "different", "easy"};
        //! Collections 操作Set，List，Map的工具类
        List list = Arrays.asList(arr);
        // swap
        Collections.swap(list, 1, 3);
        // replace
        Collections.replaceAll(list, "c", "cc");
        System.out.println(list); // [a, different, cc, boy, easy]

        System.out.println(Collections.frequency(list, "a")); // 1

        // 按字符串比较
        System.out.println(Collections.max(list)); // easy
        System.out.println(Collections.min(list)); // a
        // 自定义：按字符串长度
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length() ;
            }
        };
        System.out.println(Collections.max(list, comparator)); // different
        System.out.println(Collections.min(list, comparator)); // a

        //! op: can change collections
        Arrays.sort(arr);        // arr
        Collections.sort(list);   // ArrList, 此处按字符串比较，从小到大
        System.out.println(list); // [a, boy, cc, different, easy]

        Collections.sort(list, comparator);
        System.out.println(list); // [a, cc, boy, easy, different]

        Collections.reverse(list);
        System.out.println(list); // [different, easy, boy, cc, a]

        Collections.shuffle(list);    //random order
        System.out.println(list);



        //! copy
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(null);
        }
        /* 需要先在des装入元素
            public static <T> void copy(List<? super T> dest, List<? extends T> src) {
            int srcSize = src.size();
            if (srcSize > dest.size())
                throw new IndexOutOfBoundsException("Source does not fit in dest");
         */
        Collections.copy(arrayList, list); // des, src
        System.out.println(arrayList);
        Collections.emptyIterator();
    }
}
