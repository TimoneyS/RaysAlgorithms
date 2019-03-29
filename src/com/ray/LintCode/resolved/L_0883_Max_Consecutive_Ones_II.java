package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 *
 * @author rays1
 * @url    
 */
public class L_0883_Max_Consecutive_Ones_II {

    /**
     * 可以使用动态规划写出更通用的方法
     * @author rays1
     *
     */
    static class Solution {
    
        public int findMaxConsecutiveOnes(int[] nums) {
            
            int n = nums.length;
            int[] l = new int[n];
            int[] r = new int[n];
            
            int c = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) c = 0;
                else l[i] = ++c; 
            }
            c = 0;
            for (int i = n-1; i >= 0; i--) {
                if (nums[i] == 0) c = 0;
                else r[i] = ++c; 
            }
            
            c = 0;
            for (int i = 1; i < n-1; i ++) {
                c = Math.max(c, l[i-1] + r[i+1]+1);
            }
            return c;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,0,1,1,0};
        Out.p(new Solution().findMaxConsecutiveOnes(nums));
        
    }

}
