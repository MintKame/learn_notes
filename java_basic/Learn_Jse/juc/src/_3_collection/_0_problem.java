package _3_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _0_problem {
    public static void main(String[] args) {

        //1. unsafe: may add when the list is changing
        //           => err: not 10 elements
        ArrayList<Integer> list1 = new ArrayList<>();

        //2. Vector, Stack, Hashtable: old
        //      not recommend: should self decide need safe or not
        Vector<Integer> list2 = new Vector<>();
        // replace:
        //  Vector      ->  ArrayList
        //  Stack       ->  LinkedList
        //  Hashtable   ->  Map

        //3. synchronization wrapper: old
        // what can be wrapped ? List, Map, Set, SortedMap, SortedSet
        List<Integer> list3 = Collections.synchronizedList(new ArrayList());

        //4. juc
        // CopyOnWriteArrayList, CopyOnWriteHashMap, ConcurentHashSet
        List<Integer> list4 = new CopyOnWriteArrayList<>();
        // read concurently;
        // write: a.copy b.write c.save back

        // eg: 创建10个线程，每个向collection中，添加一个元素
        List<Integer> list = list1;
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            es.execute(()->{
                int a = (int)(Math.random() * 100);
                list.add(a);
            });
        }
        es.shutdown();
        System.out.println(list);
    }
}

