package _0_cls_base;

public class _2_func_varPara {
    public static void main(String[] args) {
        sum("a", 1,10);
        sum("b", 1, 10, 100);
        sum("c", new int[]{1, 10, 100});
    }

    //varPara:
    // must at last of paraList
    // size >= 0
    // can pass an arr
    public static void sum(String name, int ... nums){
        int res = 0;
        for(int num : nums)
            res+=num;
        System.out.println(name + " : " + res);
    }
}
