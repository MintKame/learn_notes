package _1_1_array;

import java.util.Arrays;

public class _6_59 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        // 初始化：只移动end，找到第一个满足 和>target 的终止位置
        // 若没有，返回0
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0; // [start, end]
        for (; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target){
                minLen = Math.min(minLen, end - start + 1);
                sum -= nums[start++]; // 运行后，和不一定>target
            }
        }
        return minLen;
    }
}
