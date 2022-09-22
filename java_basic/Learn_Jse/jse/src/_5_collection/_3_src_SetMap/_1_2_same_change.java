package _5_collection._3_src_SetMap;

import java.util.HashSet;

public class _1_2_same_change {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        // Obj2 重载了 hashCode() equals()，根据name计算
        // 设：index(aaa)表示：内容为aaa时，计算的index
        //     hash(aaa)表示： 内容为aaa时，计算的hash
        Obj2 o1 = new Obj2("aaa");
        set.add(o1);
        o1.setName("bbb");
        // 已有节点：index(aaa)，hash(aaa)，bbb //index,hash未变，只有值改变

        set.remove(o1);
        System.out.println(set); // 删除失败
        // remove：由于o1内容为bbb，遍历index(bbb)，若hash相同 hash(bbb) 且equals，则删除
        //  情况 1. index(aaa) != index(bbb)
        //  情况 2. index(aaa) == index(bbb)，遍历到节点，满足（同一对象||equals），但不满足hash相同
        //  remove成功需要：aaa和bbb的 index和hash 都相同

        set.add(new Obj2("aaa")); // 添加成功 [Obj2(bbb),  Obj2(aaa)]
        System.out.println(set);
        // 已有节点：index(aaa)，hash(aaa)，bbb
        // 新增节点：index(aaa)，hash(aaa)，aaa
        // add必成功：在index(aaa)遍历，满足hash相同，但不equals

        set.add(new Obj2("bbb")); // 添加成功 [Obj2(bbb), Obj2(bbb), Obj2(aaa)]
        System.out.println(set);
        // 已有节点：index(aaa)，hash(aaa)，bbb
        //          index(aaa)，hash(aaa)，aaa
        // 新增节点：index(bbb)，hash(bbb)，bbb
        // add失败需要：aaa和bbb的 index和hash 都相同
    }
}
