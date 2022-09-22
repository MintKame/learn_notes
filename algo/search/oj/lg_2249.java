package search.oj;/*
 * @Author: 闫昭
 * @Date: 2020-11-29- 17:55:00
 * @LastEditors:
 * @Description:
 */

import java.util.Scanner;

public class lg_2249 {
    static Scanner input = new Scanner(System.in);
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        n = input.nextInt();
        arr = new int[n];
        int m = input.nextInt();
        //input
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        //quest
        for (int i = 0; i < m; i++) {
            System.out.print(bs_lb(input.nextInt()) + " ");
        }
    }
    static int bs_lb(int target){
        int l = 0, r = n - 1;
        int mid = 0;
        int pos = 0;
        while (l <= r){
            mid = l + (r - l) / 2;
            if (arr[mid] >= target){
                r = mid - 1;
            } else {
                pos = mid + 1;  //may be ans
                l = mid + 1;
            }
        }
        if (arr[pos] != target) // not found
            return -1;
        else {
            return pos + 1;
        }
    }
}
