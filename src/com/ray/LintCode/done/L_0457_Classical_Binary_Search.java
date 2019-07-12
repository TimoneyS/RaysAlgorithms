package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Find any position of a target number in a sorted array. Return `-1` if target does not exist.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input: nums = [1,2,2,4,5,5], target = 2
 *      Output: 1 or 2
 *      ```
 *      **Example 2:**
 *      ```
 *      Input: nums = [1,2,2,4,5,5], target = 6
 *      Output: -1
 *      ```
 *
 * 挑战：
 *      O(logn) time
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/classical-binary-search/description
 * @date   2019-07-11 18:33:18
 */
public class L_0457_Classical_Binary_Search {
    
    static class Solution {
        
        public int findPosition(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = (l+r)/2;
                if (nums[m] == target)      return m;
                else if (nums[m] > target)  r = m - 1;
                else                        l = m + 1;
            }
            return -1;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
