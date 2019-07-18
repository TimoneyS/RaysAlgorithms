package com.ray.LintCode.tostudy;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *      
 *      If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:1,2,3
 *      Output:1,3,2
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:3,2,1
 *      Output:1,2,3
 *      ```
 *      
 *      **Example 3:**
 *      ```
 *      Input:1,1,5
 *      Output:1,5,1
 *      ```
 *
 * 挑战：
 *      The replacement must be in-place, do not allocate extra memory.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/next-permutation-ii/description
 * @date   2019-07-11 18:31:46
 */
public class L_0190_Next_Permutation_II {
    static class Solution {
        public void nextPermutation(int[] nums) {
            int k = next(nums);
            if (k == -1)
                Arrays.sort(nums);
        }
        
        public int next(int[] nums) {
            
            // 1. 寻找 k
            int k = -1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i+1]) {
                    k = i;
                    break;
                }
            }
            
            if (k == -1) return -1;
            
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
            for (int i = k+1; i <= (k+nums.length)/2; i++) {
                swap(nums, i, (k+nums.length)-i);
            }
            
            return k;
        }
        
        // 交换
        public void swap(int[] nums, int i, int j) {
            if (i == j) return;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] nums = {3,2,1};
        
        new Solution().nextPermutation(nums);
        
        Out.p(nums);
        
    }
}
