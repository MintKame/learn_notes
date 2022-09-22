package _3_tree._0_._4_oj;

import java.util.Scanner;

//in, pre -> post
public class _ac_1827_pre_in {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        recur(in.nextLine(), in.nextLine());
//        recur("abcdefg", "cbedafg");
    }

    static void recur(String in, String pre){
        int len = pre.length();
        //base
        if(len <= 1){
            System.out.print(pre);
            return;
        }
        char c = pre.charAt(0);
        int llen = in.indexOf(c);
        //left child
        recur(in.substring(0, llen), pre.substring(1, llen + 1));
        //right child
        recur(in.substring(llen + 1, len), pre.substring(llen + 1, len));
        System.out.print("" + c);
        //post-order: r - l - self
    }
}
