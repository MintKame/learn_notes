package _5_collection._1_usage;

import java.util.*;

public class _1_list {
    public static void main(String[] args) {
        List list = new ArrayList();
//        List list = new Vector();
//        List list = new LinkedList();

        // 转化
        Integer[] num1 = {4, 1,};
        List num2 = Arrays.asList(num1); //arr -> ArrList
        num2.toArray(num1);//ArrList -> arr
        new ArrayList(new HashMap<>().values()); // collection -> list

        //! 支持索引 有序 =========================================
        list.add(0, "abc");
        list.add(0, 123);// 放到下标为0处
        list.add(2, null);
        System.out.println(list); // [123, abc, null]

        list.addAll(1, list); // 第一个放到下标为1处
        System.out.println(list);
        // [123, 123, abc, null, abc, null] // 可重复，可多个null

        // list.remove(123); // 默认按索引删，返回元素
        Object obj1 = list.remove(new Integer(123));//solve: primitive -> wrapped
        System.out.println(list); // [123, abc, null, abc, null]

        Object obj2 = list.set(3, 456); // 返回元素
        System.out.println(list); // [123, abc, null, 456, null]

        System.out.println("子list(2,4)" + list.subList(2, 4)); // [null, 456]
        System.out.println("第2个元素：" + list.get(2)); // null
        System.out.println("123索引：" + list.indexOf(123)); // 0
        System.out.println("最后一个123索引：" + list.lastIndexOf(123)); // 0

        //! 遍历 * 3 ============================================
        System.out.println("============================");
        // 迭代器，所有Collection子类都有
        // 用于遍历集合，本身不存放对象
        Iterator iterator = list.iterator(); // 快捷：itit
        while (iterator.hasNext()) {
            Object next =  iterator.next(); // 指针移动到下一个元素，返回该元素
            System.out.println(next);
        }
        // 此时iterator指向最后的元素，hasNext() 为false
        // 再调用iterator.next() => NoSuchElementExcception
        iterator = list.iterator(); // 想遍历需重置
        System.out.println("============================");
        // 增强for：底层为iterator，可以用在数组
        for (Object o : list) {// 快捷：I
            System.out.println(o);
        }
        System.out.println("============================");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
