package _9_sort;/*
 * @Author: 闫昭
 * @Date: 2020-12-10- 12:18:00
 * @LastEditors:
 * @Description:
 */

public class Shell {
    static int cmp, move;
    public static void shellSort(int[] arr, int first, int last) {
        cmp = move = 0;
        int inc = last - first + 1; // len
        do{
            inc = inc / 3 + 1;  // update inc
            // traverse num to be inserted (num start with inc !!)
            for (int num = inc + first; num <= last; num++) {
                cmp++;
                // whether need to move (why -> dec the step: tmp == )
                if (arr[num - inc] > arr[num]){
                    move++;
                    int tmp = arr[num], prior; // store the num to be inserted
                    for (prior = num - inc; prior >= first && arr[prior] > tmp; prior -= inc) {    // prior move back
                        // err: arr[prior] cmp with arr[num], should be tmp (arr[num] already changed)
                        arr[prior + inc] = arr[prior];
                        cmp++;
                        move++;
                    }
                    arr[prior + inc] = tmp;
                    move++;
                }
            }
        }while (inc > 1); // already sorted   //why here: inc == 1 -> change, still 1
        System.out.println("shell\t" + cmp + "\t" + move);
    }
}