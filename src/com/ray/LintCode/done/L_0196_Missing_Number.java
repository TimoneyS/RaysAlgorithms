package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array contains *N* numbers of 0 .. *N*, find which number doesn't exist in the array.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:[0,1,3]
 *      Output:2
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:[1,2,3]
 *      Output:0
 *      ```
 *
 * 挑战：
 *      Do it in-place with O(1) extra memory and O(n) time.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/missing-number/description
 * @date   2019-07-11 18:31:49
 */
public class L_0196_Missing_Number {

    static class Solution {
        public int findMissing(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0 || nums[i] == i+1) continue;
                while (nums[i] > 0 && nums[i] != i+1) {
                    int temp = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
            
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i+1) return i+1;
            }
            
            return 0;
        }
    }
    
    public static void main(String[] args) {
        
        int[] nums = {4,0,2,1};
        
        Out.p(new Solution().findMissing(nums));
        
        Out.p(nums);
        
    }

}
