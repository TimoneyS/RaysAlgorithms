package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * K-Concatenation Maximum Sum
 * -----------------------------------------------------------------------------
 * 给你一个整数数组 arr 和一个整数 k。
 * 首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。
 * 举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。
 * 然后，请你返回修改后的数组中的最大的子数组之和。
 * 注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 * 由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。 
 *
 * Example 1
 *      Input: arr = [1,2], k = 3
 *      Output: 9
 * Example 2
 *      Input: arr = [1,-2,1], k = 5
 *      Output: 2
 * Example 3
 *      Input: arr = [-1,-2], k = 7
 *      Output: 0
 *      Constraints:
 *      	1 <= arr.length <= 10^5
 *      	1 <= k <= 10^5
 *      	-10^4 <= arr[i] <= 10^4
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/k-concatenation-maximum-sum/
 * @since   2020-03-24 21:43:07
 */
public class L1299_K_Concatenation_Maximum_Sum {
    /**
     * 求从左侧开始的最大值 lmax、从右侧开始的最大值 rmax，局部的最大值 local，总和 sum
     * 最后的结果一定是
     *      lmax + rmax
     *      local + sum *(k-1)
     *      local
     * 三个之一
     */
    static class Solution {
        public int kConcatenationMaxSum(int[] arr, int k) {
            long mod = (long) (Math.pow(10, 9) + 7);
            int min = 0, max = 0, localMax = 0, sum = 0;
            for(int i = 0; i < arr.length; i++) {
                sum += arr[i];
                min = Math.min(min, sum);
                max = Math.max(max, sum);
                localMax = Math.max(sum - min, localMax);
            }
            long kn = (localMax + (k - 1)*(long)sum) % mod;
            return (int) ((k == 1)? localMax : (Math.max(localMax, Math.max(max + sum - min, kn))));
        }
    }
    
    public static void main(String[] args) {
//        Out.p(new Solution().kConcatenationMaxSum(new int[]{-1,-2}, 7));
//        Out.p(new Solution().kConcatenationMaxSum(new int[]{1,-2,1}, 5));
        Out.p(new Solution().kConcatenationMaxSum(new int[]{-5,-2,0,0,3,9,-2,-5,4}, 5));
//        Out.p(new Solution().kConcatenationMaxSum(new int[]{1,-1}, 1));
    }
}
