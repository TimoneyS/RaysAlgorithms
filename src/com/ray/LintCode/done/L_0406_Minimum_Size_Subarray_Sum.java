package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of `n` positive integers and a positive integer `s`, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: [2,3,1,2,4,3], s = 7
 *      Output: 2
 *      Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: [1, 2, 3, 4, 5], s = 100
 *      Output: -1
 *      ```
 *
 * 挑战：
 *      If you have figured out the O(nlog n) solution, try coding another solution of which the time complexity is O(n).
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/minimum-size-subarray-sum/description
 * @date   2019-07-11 18:32:37
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
