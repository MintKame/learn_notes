package lc.ac;/*
 * @Author: 闫昭
 * @Date: 2020-11-27- 17:37:00
 * @LastEditors:
 * @Description:
 */

import java.util.Arrays;

public class _66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solve(new int[]{0})));
        System.out.println(Arrays.toString(solve(new int[]{9, 1, 9})));
        System.out.println(Arrays.toString(solve(new int[]{ 9})));
        System.out.println(Arrays.toString(solve(new int[]{9, 9, 9})));
    }
    static int[] solve(int[] digits){
        boolean carry = true;   //最初进位，表示 + 1
        int index = digits.length - 1; //从最低位开始进位
        while (carry){
            if (10 != ++digits[index]){
                carry = false;
            }else {
                digits[index] = 0;
                if (index == 0){    //特殊情况，进位到最高位，数组不够用
                    int[] ret = new int[1 + digits.length];
                    ret[0] = 1;
                    for (int i = 0; i < digits.length; i++) {
                        ret[i + 1] = digits[i];
                    }
                    return ret;
                }
            }
            index--;
        }
        return digits;
    }
}
