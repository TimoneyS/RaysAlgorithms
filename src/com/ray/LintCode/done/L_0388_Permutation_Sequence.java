package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given *n* and *k*, find the kth permutation of the dictionary order in the full permutation of n.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: n = 3, k = 4
 *      Output: "231"
 *      Explanation:
 *      For n = 3, all permutations are listed as follows:
 *      "123", "132", "213", "231", "312", "321"
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: n = 1, k = 1
 *      Output: "1"
 *      ```
 *
 * 挑战：
 *      O(n\*k) in time complexity is easy, can you do it in O(n^2) or less?
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/permutation-sequence/description
 * @date   2019-07-11 18:32:25
 */
public class L_0388_Permutation_Sequence {

    /**
     * 
     * 以 n = 4， k = 15 为例
     * n = 4 可能的排列组合共有 4! 个
     * 以 1 开始的排列组合共有 3! 个，2、3、4 排列同理
     * 
     * k = 15 的开始数字是 (15-1)/3! = 2，也就是从当前开始第 3 个数字即 3
     *  
     * 3 开始的之前是 1 开始和2开始的排列组合，这两个组合共有 2 * 3! = 12 个
     * 因此 需要寻找以 3 开始的第 15 - 12 = 3 个组合
     *
     * 等效为在 1 2 4 三个数字的 第 k = 3 个组合，寻找方法和之前一致。 
     * 
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public String getPermutation(int n, int k) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i ++) nums[i] = i + 1;
            long factorial = 1;
            for (int i = 1; i < n; i ++) factorial *= i;
            
            for (int i = 0; i < n; i++) {
                if (k <= 1) break;
                int idx = (int) ((k - 1) / factorial);
                move(nums, i + idx, i);
                k = (int) (k - idx * factorial);
                factorial = factorial / (n-i-1);
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i : nums) sb.append(i);
            return sb.toString();
        }

        private void move(int[] nums, int src, int dst) {
            if (src <= dst) return;
            int t = nums[src];
            for (int i = src; i > dst; i --)
                nums[i] = nums[i-1];
            nums[dst] = t;
        }
        
    }
    
    public static void main(String[] args) {
        
        int n = 3;
        int k = 4;
        
        Solution sol = new Solution();
        Out.p(sol.getPermutation(n, k));
        
    }

}
