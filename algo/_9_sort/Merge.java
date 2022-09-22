package _9_sort;/*
 * @Author: 闫昭
 * @Date: 2020-12-10- 14:01:00
 * @LastEditors:
 * @Description:
 */

public class Merge {
    static int cmp, move;

    public static void main(String[] args) {
        int[] arr = new int[]{5, 1 ,4};
        mergeSort_Iterate(arr);
    }

    public static void mergeSort_Iterate(int[] arr){
        cmp = move = 0;
        int[] tmp = new int[arr.length];
        for (int len = 1; len < arr.length; ) {
            // 2 times -> result in arr
            mergeSwap(arr, tmp, len);   // merge each pair of subs of arr
            len *= 2;
            mergeSwap(tmp, arr, len);
            len *= 2;
        }
        System.out.println("mergeI\t" + cmp + "\t" + move);
    }

    // each pair of a.sub --merge--> b
    private static void mergeSwap(int[] a, int[] b, int len){
        int pair = a.length / (len * 2);
        int base = 0;
        // merge each complete pair
        for(int i = 0; i < pair; i++, base += 2 * len){     // each pair
            // merge subArr
            merge(a, b, base, base + len, base + 2 * len - 1);
        }
        // merge remains
        int remains = a.length - base;
        if (remains > 0){
            if (remains <= len){ // last single
                while (base < a.length){
                    move++;
                    b[base] = a[base];
                    base++;
                }
            } else {  // last pair
                merge(a, b, base, base + len, a.length - 1);
            }
        }
    }

    public static void mergeSort(int[] arr) {
        cmp = move = 0;
        int[] tmpArr = new int[arr.length];
        recur(arr, tmpArr, 0, arr.length - 1);
        arr = tmpArr;
        System.out.println("merge\t" + cmp + "\t" + move);
    }

    // a[from..to] -> b[from..to] (sorted)
    private static void recur(int[]a, int[]b, int from, int to){
        if (from == to) {    // base
            move++;
            b[from] = a[from];
            return;
        }
        int mid = from + (to - from) / 2;
        int[] tmp = new int[a.length];
        recur(a, tmp, from, mid);
        recur(a, tmp, mid + 1, to);   // why from use (mid + 1) ?  mid near to from
        merge(tmp, b, from, mid + 1, to);
    }

    //  merge A[sub1..sub2 - 1] + A[sub2..tail] -> B[sub1..tail]
    //  arr: A(sub1 + sub2), B
    private static void merge(int[] arrA, int[] arrB, int head1, int head2, int tail2){
        int tail1 = head2 - 1, indexB = head1;
        // merge 至 其中一个 array 用完
        while (head1 <= tail1 && head2 <= tail2){
            cmp++;
            move++;
            if (arrA[head2] < arrA[head1]){
                arrB[indexB++] = arrA[head2++];
            }else {
                arrB[indexB++] = arrA[head1++];
            }
        }
        // merge 剩余部分
        while (head1 <= tail1){
            move++;
            arrB[indexB++] = arrA[head1++];
        }
        while (head2 <= tail2){
            move++;
            arrB[indexB++] = arrA[head2++];
        }
    }

}
