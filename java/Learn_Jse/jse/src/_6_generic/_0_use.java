package _6_generic;

import org.junit.jupiter.api.Test;

import java.util.*;

public class _0_use {
    // 泛型：jdk5
    // 注释：泛型使用细节abcde,传统方式的问题*2
    // 传统方式============================
    @Test
    void listTradition(){
        ArrayList list1 = new ArrayList();
        //! 等价 a. 没显式指定类型，默认类型为Object
        // ArrayList<Object> list1 = new ArrayList<>();
        list1.add("1"); //! b. 指定具体类型后，可以传入类型的子类（Object的子类String）
        list1.add("22");
        list1.add("333");
        // list1.add(4444);
        // ! 问题1. 之后运行时转成String出错
        for (Object o : list1) {
            String s = (String)o; //! 问题2. 每个都要类型转换，效率低
            System.out.println(s.length());
        }
    }
    // 泛型============================
    @Test
    void listGeneric(){
        ArrayList<String> list2 = new ArrayList<>(); // 编译时,由此就知道具体类型为String
        //! c.右侧简写，编译器进行类型推断

        // new ArrayList<int>()
        //! d. 类型只能为引用类型，不可以primitive
        list2.add("1");
        list2.add("22");
        list2.add("333");
        // list2.add(4444); // 编译时检查类型为String,安全。
        // 只要编译时没警告，运行时不产生ClassCastException
        for (String s : list2) { // 取出即为String
            System.out.println(s.length());
        }

        //! e
        Object o = new String("123"); // 可以用Object引用String
        // ArrayList<Object> list = new ArrayList<String>(); // 泛型必须一致
    }

    // eg============================
    @Test
    void hmGeneric(){
        // public class HashMap<K,V>
        HashMap<String, Integer> hm = new HashMap<>();
        // 编译时，由此句可知 K为String，V为Integer
        //        泛型类被实例化为普通类，并创建该普通类的对象

        hm.put("abc",123);
        hm.put("def",456);
        hm.put("ghi",789);

        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        // HashMap的方法：
        //      public Set<Map.Entry<K,V>> entrySet()

        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        // HashMap.EntrySet的方法：
        //      public final Iterator<Map.Entry<K,V>> iterator()
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}