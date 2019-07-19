package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个n个整数的数组和一个目标整数target
 *      找到下标为i、j、k的数组元素0 <= i < j < k < n，满足条件nums[i] + nums[j] + nums[k] < target.
 *
 * 用例：
 *      **用例1**
 *      输入:  nums = [-2,0,1,3], target = 2
 *      输出: 2
 *      解释:
 *      Because there are two triplets which sums are less than 2:
 *      [-2, 0, 1]
 *      [-2, 0, 3]
 *      
 *      **用例2**
 *      输入: nums = [-2,0,-1,3], target = 2
 *      输出: 3
 *      解释:
 *      Because there are three triplets which sums are less than 2:
 *      [-2, 0, 1]
 *      [-2, 0, 3]
 *      [-2, -1, 3]
 *
 * 挑战：
 *      Could you solve it in O(n2) runtime?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/3sum-smaller/description
 * @date   2019-07-19 10:51:18
 */
public class L_0918_3Sum_Smaller {

    /**
     * 如果
     *      nums[i] + nums[j] + nums[k] < target
     * 则有
     *      nums[j] + nums[k] < target - nums[i]
     * 则有
     *      nums[k] < target - nums[i] - nums[j]
     * 
     * 因此对于 任意 nums[i]，nums[k]
     *      寻找符合 nums[k] < target - nums[i] - nums[j] 的 nums[k] 即可
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int threeSumSmaller(int[] nums, int target) {
            
            Arrays.sort(nums);
            
            int rs = 0;
            for (int i = 0; i < nums.length; i++) {
                rs += towSumSmaller(nums, i, target);
            }
            
            return rs;
        }

        // 从 i 开始寻找两个数字，和小于 target
        private int towSumSmaller(int[] nums, int i, int target) {
            
            int rs = 0;
            for (int j = i + 1; j < nums.length; j++) {
                // 在 [ j, n] 寻找 小于 target - nums[i] - nums[j] 的数字，这里可以该为2分搜索
                for (int k = j + 1; k < nums.length; k ++) {
                    if (nums[k] < (target - nums[i] - nums[j])) {
                        rs ++;
                    }
                }
            }
            
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        int[] nums = {-2,0,1,3};
        int target = 2;
        
        Out.p(new Solution().threeSumSmaller(nums, target));
        
    }

}
