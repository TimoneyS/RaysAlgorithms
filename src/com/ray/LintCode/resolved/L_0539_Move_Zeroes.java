package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 保持数组中其他元素顺序不变，将所有等于0的元素移到数组末尾
 *
 * @author rays1
 *
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
        
        int[] nums = {4,0,1,0,-2,0,0,1};
        new Solution().moveZeroes(nums);
        
        Out.p(nums);
        
    }

}
