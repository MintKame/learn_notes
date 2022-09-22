package lc.wa1;/*
 * @Author: 闫昭
 * @Date: 2020-11-27- 16:59:00
 * @LastEditors:
 * @Description:
 */

public class _7 {

    public static void main(String[] args) {
        System.out.println(solve(0));
        System.out.println(solve(1));
        System.out.println(solve(-1));
        System.out.println(solve(123));
        System.out.println(solve(-123));
        System.out.println(solve(-120));
        System.out.println(solve(-2147483412));
    }
    //0, 1, -1, 123, -123
    static int solve(int x){  //not consider neg ( neg % pos -> neg )
        int ans = 0;
        while (x != 0){
            int tail = x % 10;
            //judge overflow (bf overflow happen)
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tail > Integer.MAX_VALUE % 10) ){
                return 0;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && tail < Integer.MIN_VALUE % 10)){
                return 0;
            }
            x /= 10;
            ans = ans * 10 + tail;
        }
        return ans;
    }
}
