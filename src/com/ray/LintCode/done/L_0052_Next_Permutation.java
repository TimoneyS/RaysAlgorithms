package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a list of integers, which denote a permutation.
 *      
 *      Find the next permutation in ascending order.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:[1]
 *      Output:[1]
 *      ```
 *      
 *      
 *      Example 2:
 *      ```
 *      Input:[1,3,2,3]
 *      Output:[1,3,3,2]
 *      ```
 *      
 *      Example 3:
 *      ```
 *      Input:[4,3,2,1]
 *      Output:[1,2,3,4]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/next-permutation/description
 * @date   2019-07-11 18:04:40
 */
public class L_0052_Next_Permutation {

    static class Solution {
        /**
         * @param nums: A list of integers
         * @return: A list of integers
         */
        public int[] nextPermutation(int[] nums) {
            
            // 1. 寻找 k
            int k = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i+1]) {
                    k = i;
                    break;
                }
            }
            
            if (k == -1) {
                reverse(nums, 0, nums.length-1);
                return nums;
            }
            
            // 2. 寻找 l,从右侧找到第一个大于 nums[l] > nums[k] 的 l 
            int l = -1;
            for (int i = nums.length-1; i > k; i--) {
                if (nums[i] > nums[k]) {
                    l = i;
                    break;
                }
            }

            // 3. 交换 nums[k] nums[l]
            swap(nums, k, l);
            
            // 4. 翻转 nums[k+1..n]
            reverse(nums, k+1, nums.length-1);
            
            return nums;
            
        }
        
        private void reverse(int[] nums , int s, int t) {
            for (int i = 0; i < (t-s+1)/2; i++) swap(nums, s+i, t-i);
        }
        
        private void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2};
        
        new Solution().nextPermutation(nums);
        
        Out.p(nums);
    }

}
