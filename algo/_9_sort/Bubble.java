package _9_sort;/*
 * @Author: 闫昭
 * @Date: 2020-12-01- 21:18:00
 * @LastEditors:
 * @Description:
 */

public class Bubble {
    static int cmp = 0, move = 0;
    public static void bubbleSort(int[] arr, int first, int last){
        cmp = move = 0;
        boolean isFinish = false;   // whether this loop hasn't swap
        for (int i = first; i < last && !isFinish; i++) {    //times
            isFinish = true; //this turn no swap
            //each time, sink the largest
            for (int j = first; j < last - i; j++) {    //compare pairs(j's lower index)
                cmp ++;
                if (arr[j] > arr[j + 1]){   //swap
                    move += 3;          // 1 swap = 3 move
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isFinish = false;   //change flag
                }
            }
        }
        System.out.println("bubble\t" + cmp + "\t" + move);
    }
}
