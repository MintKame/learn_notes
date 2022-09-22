package _0_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 */
public class Solution7 {
    // 回溯 暴力遍历所有 跳跃方式（每次跳不同步数
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        boolean[] canJump = new boolean[nums.length];
        // dp:从后往前遍历，记录能否完成
        for(int i = nums.length - 2; i >= 0; i--){
            // 从i位置，能直接完成
            if(i + nums[i] >= nums.length - 1){
                canJump[i] = true;
                continue;
            }
            // 从i位置，跳j步，跳到一个能完成的位置？
            for(int j = 1; j <= nums[i]; j++){
                if(canJump[i + j]){
                    canJump[i] = true;
                    continue;
                }
            }
        }
        return canJump[0];
    }
}

