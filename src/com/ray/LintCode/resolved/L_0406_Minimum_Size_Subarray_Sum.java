package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定 n 个正整数的数组和和一个正整数 s，找到和 ≥ s 的长度最小的子数组
 * 如果没有，则返回-1。
 *
 * 如 [2,3,1,2,4,3] s = 7，[4, 3] 是符合条件的
 *
 * 时间复杂度 O(nlog n) 到  O(n)
 * @author rays1
 *
 */
public class L_0406_Minimum_Size_Subarray_Sum {

    /**
     * 去尾法
     * 
     * 不断的计算数组和，当某个位置求和大于s时，便找到了一个子数组。
     * 去掉当前子数组的尾部，直到其数字之和小于s，再次基础上继续向前寻找下一个符合条件的子数组。
     * 
     * 一个优化的点时，当找到了一个子数组后，向前求和时，就算再次找到符合的子数组，其长度可能也是大于先前找到的结果。
     * 因此再向前前进时，可以将尾部也同时向前移动，这样保证找到的子数组一定小于先前找到的结果。
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int minimumSize(int[] nums, int s) {
            
            int sum = 0, m = -1, l = 0;
            
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                
                if (m != -1)
                    sum -= nums[l++];
                
                while (sum >= s) {
                    if (m == -1) m = i-l+1;
                    else m = Math.min(m, i-l+1);
                    sum -= nums[l++];
                }
            }
            
            return m;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {1,1,2,2,1,1};
        int s = 4;
        
        Out.p(new Solution().minimumSize(nums, s));
        
    }

}
