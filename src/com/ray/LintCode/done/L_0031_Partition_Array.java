package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个整数数组 nums 和一个整数 k，分割数组使得：
 *          小于k的数字都移动到左侧
 *          大于等于k的数字都移动到右侧。
 *      返回分割后的索引
 *
 * 挑战：
 *      Can you partition the array in-place and in O(n)?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/partition-array/description
 * @date   2019-07-11 16:20:38
 */
public class L_0031_Partition_Array {

    /**
     * 单从题目要求，更简单的解法是一次遍历。
     * 实际上题目要考察的是快速排序算法的基础
     * 
     * int index = 0;
     * for (int i : nums) if (i < k) index ++;
     * return index;
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int partitionArray(int[] nums, int k) {
            if (nums.length == 0)
                return 0;

            int l = 0;
            int r = nums.length - 1;
            while (true) {
                while (l < nums.length && nums[l] < k) {
                    l++;
                }
                while (r >= 0 && nums[r] >= k) {
                    r--;
                }
                if (l < r)
                    swap(nums, l, r);
                else
                    break;
            }
            return l;
        }
        
        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
