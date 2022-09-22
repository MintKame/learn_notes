package _9_sort;/*
 * @Author: 闫昭
 * @Date: 2020-12-01- 21:06:00
 * @LastEditors:
 * @Description:
 */

import java.util.Random;
// cnt cmp(between elements), move(element)
// (3-case: random, in order, reverse)
public class test {
    static Random rand = new Random();
    public static void main(String[] args) {
        // init data
        int size = 60;
        int[][] arr = {new int[size], new int[size], new int[size]}; //Random, reverse, sorted
        for (int i = 0; i < size; i++) {
            arr[0][i] = Math.abs(rand.nextInt() % (2 * size));
            arr[1][i] = size - i - 1;
            arr[2][i] = i;
        }
        //  sort && print analyse
        String[] msg = {"random", "reverse", "sorted"}; // data's type
        for (int i = 0; i < 3; i++) {
            System.out.println(msg[i] + "\tcmp\t\tmove" );
            // simple
            Bubble.bubbleSort(arr[i].clone(), 0, size - 1);

            Select.selectSort(arr[i].clone(), 0, size - 1);

            Insert.insertSort(arr[i].clone(), 0, size - 1);
            Insert.biInsertSort(arr[i].clone(), 0, size - 1);
            Insert.bi2InsertSort(arr[i].clone());
            // complex
            Quick.quickSort(arr[i].clone(), 0, size - 1, 0);
            Quick.quickSort(arr[i].clone(), 0, size - 1, 1);

            Heap.heapSort(arr[i].clone());

            Shell.shellSort(arr[i].clone(), 0, size - 1);

            Merge.mergeSort(arr[i].clone());
            Merge.mergeSort_Iterate(arr[i].clone());

            System.out.println();
        }
    }
}
/*
            int cmp = move = 0;
            System.out.println("\t" + cmp + "\t" + move);

            System.out.println(Arrays.toString(arr));
* */