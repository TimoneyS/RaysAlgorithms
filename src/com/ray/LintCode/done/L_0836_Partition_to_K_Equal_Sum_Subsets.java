package com.ray.LintCode.done;

import java.util.Arrays;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an array of integers `nums` and a positive integer `k`, find whether it's possible to divide this array into` k` non-empty subsets whose sums are all equal.
 *
 * 用例：
 *      **Example1**
 *      
 *      ```
 *      Input: nums = [4, 3, 2, 3, 5, 2, 1] and k = 4
 *      Output: True
 *      Explanation:
 *      It's possible to divide it into 4 subsets (5), (1, 4), (2, 3), (2, 3) with equal sums.
 *      ```
 *      
 *      **Example2**
 *      
 *      ```
 *      Input: nums = [1, 3, 2, 3, 5, 3, 1] and k = 3
 *      Output: True
 *      Explanation:
 *      It's possible to divide it into 3 subsets (1, 2, 3), (1, 5), (3, 3) with equal sums.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/partition-to-k-equal-sum-subsets/description
 * @date   2019-07-11 18:37:17
 */
public class L_0836_Partition_to_K_Equal_Sum_Subsets {

    /**
     * 可以理解为 k 次背包问题
     * 
     * 第一次选择 和为 sum 的元素，共 n1 种 第二次选择 剔除第一次已经选择的元素有 n2 种
     * 
     * 每次 和为 sum 的元素，都可以表示成一个状态，即每一位的数字选择或不选择，这种状态一共有 2^n 种
     * 
     * 那么只需要沿着状态递增，选择互不冲突的状态即可
     * 
     * @author rays1
     *
     */
    static class Solution {

        public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            if (sum % k > 0)
                return false;

            boolean[] visit = new boolean[1 << nums.length]; // 2 ^ n
            return search(0, visit, sum, nums, sum / k);
        }
        
        boolean search(int used, boolean[] visit, int todo, int[] nums, int target) {
            if (todo == 0) {
                return true;
            }
            
            if (!visit[used]) {
                visit[used] = true;
                int remain = (todo - 1) % target + 1;
                for (int i = 0; i < nums.length; i++) {
                    if (((used >> i) & 1) == 1 || nums[i] > remain ) continue;
                    if (search(used | (1<<i), visit, todo - nums[i], nums, target)) {
                        return true;
                    }
                }
            }
            return false;
        }
        
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
