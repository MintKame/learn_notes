package _9_sort;/*
 * @Author: 闫昭
 * @Date: 2020-12-01- 21:19:00
 * @LastEditors:
 * @Description:
 */

public class Insert {
    static int cmp, move;

    public static void insertSort(int[] arr, int first, int last){
        cmp = move = 0;
        for (int i = first + 1; i <= last; i++) {  //traverse (2nd - last) elem to be inserted
            cmp++;
            if (arr[i - 1] > arr[i]){   // whether need to move
                int tmp = arr[i], j;
                move++;
                for (j = i - 1; j >= first && arr[j] > tmp; j--) { //part of prior elem move_back
                    arr[j + 1] = arr[j];
                    cmp++;
                    move++;
                }
                move++;
                arr[j + 1] = tmp;   //insert to right place
                //another way: set arr[0] as inserted elem
                // => not need to check index - j >= 0
            }
        }
        System.out.println("insert\t" + cmp + "\t\t" + move);
    }

    public static void biInsertSort(int[] arr, int first, int last) {
        cmp = move = 0;
        for (int i = first + 1; i <= last; i++) {   // index of item to be inserted
            move++;
            int tmp = arr[i];
            // binary search
            int l = first, r = i - 1, mid;
            while (l <= r){
                mid = l + (r - l) / 2;
                cmp++;
                if (arr[mid] < tmp){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            // insert between r && l
            for (int j = i - 1; j >= l; j--) {
                move++;
                arr[j + 1] = arr[j];
            }
            move++;
            arr[l] = tmp;
        }
        System.out.println("biIns\t" + cmp + "\t\t" + move);
    }

    public static void bi2InsertSort(int[] arr) {
        cmp = move = 0;
        // create circular arr
        int[] tmpArr = new int[arr.length];
        move++;
        tmpArr[0] = arr[0];
        int minIndex = 0, maxIndex = 0;     // record min, max index
        for (int i = 1; i < arr.length; i++) {  // insert each item
            move++;
            int toIns = arr[i];
            // check: not appear arr
            // if == [0] => must satisfy both 2 block's if
            cmp++;
            if (toIns < tmpArr[0]){ // 1 -> min
                cmp++;
                if (toIns <= tmpArr[minIndex]){
                    move++;
                    tmpArr[minIndex + 1] = toIns;
                } else {
                    // bs
                    int mid, l = 1, r = minIndex; // dec
                    while (l <= r){
                        mid = l + (r - l) / 2 ;
                        cmp++;
                        if (toIns < tmpArr[mid]){
                            l = mid + 1;
                        }else {
                            r = mid - 1;
                        }
                    }   // r >= 0. not need to handle -
                    // insert to r & l
                    for (int j = minIndex; j >= l ; j--) {
                        move++;
                        tmpArr[j + 1] = tmpArr[j];
                    }
                    move++;
                    tmpArr[l] = toIns;
                }
                minIndex ++;
            }else { // max -> len - 1
                cmp++;
                if (toIns >= tmpArr[maxIndex]){
                    move++;
                    tmpArr[(maxIndex - 1 + arr.length) % arr.length] = toIns;
                }else {
                    // bs
                    int mid, l = maxIndex, r = arr.length - 1;   // dec
                    while (l <= r){
                        mid = l + (r - l) / 2 ;
                        cmp++;
                        if (toIns < tmpArr[mid]){
                            l = mid + 1;
                        }else {
                            r = mid - 1;
                        }
                    }   // l <= len
                    // insert to r & l
                    for (int j = maxIndex; j <= r ; j++) {
                        move++;
                        tmpArr[j - 1] = tmpArr[j];
                    }
                    move++;
                    tmpArr[r] = toIns;
                }
                maxIndex = (maxIndex - 1 + arr.length) % arr.length;
            }
        }
        // back to arr
        int index = 0;
        for (int i = minIndex; ; i = (i - 1 + arr.length) % arr.length) {
            move++;
            arr[index++] = tmpArr[(i + arr.length) % arr.length];
            if (i == maxIndex){
                break;
            }
        }
//        System.out.println("bi2Ins\n" + Arrays.toString(arr));
//        System.out.println("tmp\n" + Arrays.toString(tmpArr));
                System.out.println("bi2Ins\t" + cmp + "\t\t" + move);
    }
}
