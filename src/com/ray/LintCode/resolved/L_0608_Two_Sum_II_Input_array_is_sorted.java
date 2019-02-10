package com.ray.LintCode.resolved;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 给定一个已经按升序排列的数组，找到两个数之和等于特定数。
 * 返回这两个数的位次，index1 必须小于 index2
 * 
 * 例如
 *     给定数组为 [2,7,11,15]，target = 9
 *     返回 [1,2]
 *
 *
 * @author rays1
 *
 */
public class L_0608_Two_Sum_II_Input_array_is_sorted {

    /**
     * 对每个数字在后续的数字中寻找是否存在 value - num
     * 因为数组有序，因此后续的查询可以使用二分搜索
     * 
     * 复杂度为 {log n + log n-1 + ... + log 1} = O(log n!)
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int[] twoSum(int[] nums, int target) {
            
            int index1 = 0, index2 = 0;
                
            for (int i = 0; i < nums.length - 1; i++) {
                int rs = Arrays.binarySearch(nums, i + 1, nums.length, target - nums[i]);
                if (rs > 0) {
                    index1 = i + 1;
                    index2 = rs + 1;
                    break;
                }
            }
            
            if (index1 * index2 != 0)
                return new int[] {index1, index2};
            return new int[] {};
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
