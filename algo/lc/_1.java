package lc;/*
 * @Author: 闫昭
 * @Date: 2020-11-27- 16:29:00
 * @LastEditors:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Arrays;
public class _1 {

    public static void main(String[] args) {

        System.out.print(Arrays.toString(solve( new int[]{2, 7, 11, 15}, 9)));
        System.out.print(Arrays.toString(solve( new int[]{3,2,4}, 6)));
        System.out.print(Arrays.toString(solve( new int[]{3, 3}, 6)));
    }

    static int[] solve(int[] arr, int target){
        int[] sortArr = new int[arr.length];
        for(int i : arr){
//            sortArr =
        }
        Arrays.sort(arr);
        int l, r;
        for (int i = 0; i < arr.length; i++) {
            int find = target - arr[i];
            l = i + 1; r = arr.length - 1;
            while (l <= r){
                int mid = l + (r - l) / 2;
                if (arr[mid] == find){
                    return new int[]{i, mid};
                }else if (arr[mid] < find){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return null;
    }
}
