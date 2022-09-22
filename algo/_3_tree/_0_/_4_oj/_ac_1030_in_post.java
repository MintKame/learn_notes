package _3_tree._0_._4_oj;
import java.util.Scanner;
/* 中序与后序 -> pre
BADC
BDCA
ABCD
*/
//post从后往前分割in
public class _ac_1030_in_post {
    static void recur(String in, String post) {
//        System.out.println("in: " + in + "\tpost: " + post);
        int len = in.length();
        //base:
        if (len <= 1) {
            System.out.print(in);
            return;
        }
        // root c, c divide inOrder -> 2 sub tree -> recur
        char c = post.charAt(len - 1); //分割的字符
        int pos = in.indexOf(c);
        //pre order: self - l - r
        System.out.print(c);
        recur(in.substring(0, pos), post.substring(0, pos));
        recur(in.substring(pos + 1, len), post.substring(pos, len - 1));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        recur(in.nextLine(), in.nextLine());
    }
}
