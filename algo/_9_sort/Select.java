package _9_sort;/*
 * @Author: 闫昭
 * @Date: 2020-12-01- 21:19:00
 * @LastEditors:
 * @Description:
 */

public class Select {
    static int cmp = 0, move = 0;
    public static void selectSort(int[] arr, int first, int last){
        cmp = move = 0;
        //each turn: choose min to index = i
        for (int i = first; i < last; i++) {
            //select min
            int minIndex = i;
            for (int j = i + 1; j <= last; j++) {
                cmp++;
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (i != minIndex){
                move += 3;  //swap
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        System.out.println("select\t" + cmp + "\t" + move);
    }
}
