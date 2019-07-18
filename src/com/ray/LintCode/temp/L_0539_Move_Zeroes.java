package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array `nums`, write a function to move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input: nums = [0, 1, 0, 3, 12],
 *      Output: [1, 3, 12, 0, 0].
 *      ```
 *      Example 2:
 *      ```
 *      Input: nums = [0, 0, 0, 3, 1],
 *      Output: [3, 1, 0, 0, 0].
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/move-zeroes/description
 * @date   2019-07-11 18:33:53
 */
public class L_0539_Move_Zeroes {

    /**
     * 
     * 先按照简单的思路，创建一个临时数组 temp
     * 然后遍历数组 num 每次遇到不是0的元素，则有 temp[j++] = nums[i++]
     * 在遍历过程中，j 一定 小于等于 i
     * 因此可以将已经遍历过的部分，作为临时数组来使用
     * 
     * 则在遍历的过程中，遇到不是0的元素，则有 nums[j] = nums[i]
     * 
     * 然后需要将 j - nums.length-1的元素变为0
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public void moveZeroes(int[] nums) {
            
            int cursor = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                nums[cursor] = nums[i];
                if (cursor != i) nums[i] = 0;
                cursor++;
            }
            
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
