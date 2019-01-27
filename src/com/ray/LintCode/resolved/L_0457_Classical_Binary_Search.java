package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 二分搜索
 *
 * @author rays1
 *
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
