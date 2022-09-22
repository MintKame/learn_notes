package _9_sort;/*
 * @Author: 闫昭
 * @Date: 2020-12-10- 14:01:00
 * @toEditors:
 * @Description:
 */

public class Heap {
    static int cmp, move;
    public static void heapSort(int[] arr) {
        cmp = move = 0;
        // build an arr to sort (not necessary, data may be already satisfy)
        int[] subArr = new int[arr.length + 1];    // + [0] is empty
        for (int i = 1; i < subArr.length; i++) {
            subArr[i] = arr[i - 1];
        }
        // build heap
        int lastIndex = subArr.length - 1;
        for (int i = lastIndex / 2; i >= 1; i--) {   // traverse all non-leaf node
            heapAdjust(subArr, i, lastIndex);
        }
        // swap [1], adjust heap
        for (int i = lastIndex; i >= 2; i--){
            move += 3; // swap
            int tmp = subArr[1];
            subArr[1] = subArr[i];
            subArr[i] = tmp;
            heapAdjust(subArr, 1, i - 1);
        }
        // write back to original arr
        for (int i = 1; i < subArr.length; i++) {
            arr[i - 1] = subArr[i];
        }
        System.out.println("heap\t" + cmp + "\t" + move);
    }

    // except [from], all nodes satisfy big_heap
    private static void heapAdjust(int[] arr, int from, int to){
        move++;
        int node = from, child = from * 2, val = arr[from]; // keep 2 ptr
        // break 1 - node reach leaf
        while (child <= to){
            cmp++;
            // choose bigger child
            if (child + 1 <= to && arr[child] < arr[child + 1]){
                child++;
            }
            cmp++;
            // break 2 - smaller than child (already heap)
            if (arr[child] <= val){
                break;
            }
            move++;
            arr[node] = arr[child];
            // update ptr
            node = child;
            child *= 2;
        }
        move++;
        // store to the right pos
        arr[node] = val;
    }
}
