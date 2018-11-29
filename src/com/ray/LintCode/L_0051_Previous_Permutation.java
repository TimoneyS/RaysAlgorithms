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
         * 序列的上一个字典序列
         * <p>
         * 1. 从右往左 找到第一个 a[k] > a[k+1]
         * 2. 反转 a[k+1..n]
         * 3. 从 k 向右找到，第一个 a[l] < a[k]
         * 4. 交换 a[l] a[k]
         * @param nums
         */
        public void next(List<Integer> nums) {
            
            // 从右往左 找到第一个 a[k] > a[k+1]
            int k = -1;
            for (int i = nums.size()-2; i >= 0; i--) {
                if (nums.get(i) > nums.get(i+1)) {
                    k = i;
                    break;
                }
            }
            
            // 反转 a[k+1..n]
            reverse(nums, k+1, nums.size()-1);

            if (k == -1 ) return ;
            
            // 从 k 向右找到，第一个 a[l] < a[k]
            int l = -1;
            for (int i = k+1; i < nums.size(); i++) {
                if (nums.get(i) < nums.get(k)) {
                    l = i;
                    break;
                }
            }
            // 交换 a[l] a[k]
            swap(nums, k, l);
            
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
        
        // For [1,3,2,3], the previous permutation is [1,2,3,3]
        // For [1,2,3,4], the previous permutation is [4,3,2,1]
        
        Integer[] arr = {1,2,3,4};
        
        List<Integer> nums = Arrays.asList(arr);
        
        new Solution().previousPermuation(nums);
        
        Out.p(nums);
        
    }

}
