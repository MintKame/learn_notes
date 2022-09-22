package search;/*
 * @Author: 闫昭
 * @Date: 2020-11-26- 16:15:00
 * @LastEditors:
 * @Description:
 */

public class BS {
    static int bs(int num, int []arr) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {    //<=
            mid = low + (high - low) / 2; // to avoid overflow
            if (arr[mid] == num) {  // find
                return mid;
            } else if (arr[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;  // not found
    }
    static int lowerBound(int num, int []arr) //the largest num lower than num
    {
        int l = 0, r = arr.length - 1;
        int lastPos = -1; //best solution
        while (l <= r)
        {
            int mid = l + (r - l) / 2; //avoid overflow
            if (arr[mid] >= num) {
                r = mid - 1;
            } else {  //arr[mid] < num (maybe ans)
                lastPos = mid;
                l = mid + 1;
            }
        }
        return lastPos;
    }

    public static void main(String[] args) {
        System.out.print(lowerBound(5, new int[]{0, 1, 2, 3, 4, 5, 5, 6, 7, 8}));
    }
}
