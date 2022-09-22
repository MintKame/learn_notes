package _0_;

import java.util.*;

/*
*/
public class Solution8 {
    // canJump 改为 times
    //    从当前位置到最后所需最少次数（-1表示不可达）
    public int jump(int[] nums) {
        // if(nums.length == 1) return 0; // 特殊情况
        int[] times = new int[nums.length];
        Arrays.fill(times, -1);
        times[times.length - 1] = 0;
        // dp:从后往前遍历，记录最少跳跃次数
        for(int i = nums.length - 2; i >= 0; i--){
            // 从i位置，能直接完成
            if(i + nums[i] >= nums.length - 1){
                times[i] = 1;
                continue;
            }
            // 从i位置，跳j步，跳到一个能完成的位置？
            for(int j = 1; j <= nums[i]; j++){
                if(times[i + j] != -1){ // 跳到一个能完成的位置
                    int s = 1 + times[i+j]; // 选择先跳j步,此方式所需最少次数
                    if(times[i] == -1 || times[i] > s){ // 若更优则更新
                        times[i] = s;
                    }
                }
            }
        }
        return times[0];
    }
}

