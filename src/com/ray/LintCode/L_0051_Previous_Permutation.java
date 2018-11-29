package com.ray.LintCode;

import java.util.Arrays;
import java.util.List;

import com.ray.io.Out;

/**
 * Given a list of integers, which denote a permutation.
 * Find the previous permutation in ascending order.
 * <p>
 * For [1,3,2,3], the previous permutation is [1,2,3,3]
 * For [1,2,3,4], the previous permutation is [4,3,2,1]
 * 
 * @author rays1
 *
 */
public class L_0051_Previous_Permutation {

    static class Solution {
        /*
         * @param nums: A list of integers
         * @return: A list of integers that's previous permuation
         */
        public List<Integer> previousPermuation(List<Integer> nums) {
            next(nums);
            return nums;
        }
        
        /**
         * 序列的下一个字典序列
         * <p>
         * 
         * <li> 1. 在 序列中 找到所有满足 a[k] < a[k+1] 最大的 k 值，如果找不到，则说明当前排列是字典序最大者（逆序）。 
         * <li> 2. 在a[k+1..n]中，找到所有满足 a[l] > a[k] 的最小的 a[l]。
         * <li> 3. 交换a[l]与a[k].
         * <li> 4. 反转区间a[k+1..n]内元素的顺序。
         * <br>
         * 这样就得到了a[1...n]在字典序中的下一个排列。
         * @param nums
         */
        public void next(List<Integer> nums) {
            
            // 1. 寻找 k
            int k = -1;
            for (int i = 0; i < nums.size()-1; i++) {
                if (nums.get(i) < nums.get(i+1) && k < i) k = i;
            }
            
            if (k == -1) {
                reverse(nums, 0, nums.size()-1);
                return;
            };
            
            // 2. 寻找 l
            int l = -1;
            for (int i = k+1; i < nums.size(); i++) {
                // 注意 这里的判断如果是 nums[l] > nums[i]，则重复元素的情况会有误
                if (nums.get(i) > nums.get(k) && (l == -1 || nums.get(l) >= nums.get(i))) {
                    l = i;
                }
            }
            
            // 3. 交换 nums[k] nums[l]
            swap(nums, k, l);
            
            // 4. 翻转 nums[k+1..n]
            reverse(nums, k+1, nums.size()-1);
        }
        
        // 交换
        public void swap(List<Integer> nums, int i, int j) {
            if (i == j) return;
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
        
        public void reverse(List<Integer> nums, int s, int t) {
            for (int i = s; i <= (s + t)/2; i++) swap(nums, i, s+t-i);
        }
        
    }
    
    public static void main(String[] args) {
        Integer[] arr = {1,3,2,3};
        
        List<Integer> nums = Arrays.asList(arr);
        
        new Solution().previousPermuation(nums);
        
        Out.p(nums);
        
    }

}
