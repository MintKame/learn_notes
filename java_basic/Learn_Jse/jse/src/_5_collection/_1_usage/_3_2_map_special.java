package _5_collection._1_usage;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class _3_2_map_special {
    public static void main(String[] args) {
        Map lhm = new LinkedHashMap();
        lhm.put(123, null);
        lhm.put("abc", null);
        lhm.put("abc", "abc");
        lhm.put(null, 123);
        lhm.put(null, 456);
        lhm.put("def", null);
        System.out.println(lhm);
        // 有序（加入顺序） {123=null, abc=abc, null=456, def=null}

        Map treeMap = new TreeMap();
        treeMap.put(1, 1);
        treeMap.put(3, 333);
        treeMap.put(5, 55555);
        treeMap.put(2, 22);
        treeMap.put(4, 4444);
        System.out.println(treeMap);
        // 有序（按大小）{1=1, 2=22, 3=333, 4=4444, 5=55555}

        Map map  = new Hashtable();
        // key, value 都不能为null，nullPointerException
//        map.put(null, 123);
//        map.put(123, null);
    }
}
