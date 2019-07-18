package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      In combinatorial mathematics, a derangement is a permutation of the elements of a set, such that no element appears in its original position.
 *      
 *      There's originally an array consisting of `n` integers from `1` to `n` in ascending order, you need to find the number of derangement it can generate.
 *      
 *      Also, since the answer may be very large, you should return the output mod `10^9 + 7`.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 3
 *      Output: 2
 *      Explanation: 
 *        The original array is [1,2,3]. 
 *        The two derangements are [2,3,1] and [3,1,2].
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 2
 *      Output: 1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-the-derangement-of-an-array/description
 * @date   2019-07-11 18:38:08
 */
public class L_0869_Find_the_Derangement_of_An_Array {

    /**
     * 统计可以发现规律
     * 
     * 奇数 n 其排列个数为 dp[n-1] * n - 1 
     * 偶数 n 其排列个数为 dp[n-1] * n + 1
     * 
     * 试想 n-1 个数字的排列个数为 dp[n-1]
     *  那么将第 n 个数字放到所有排列之后，会有 dp[n-1] 个新的排列
     *  将这第 n 个数字和其之前的排列中的每个数字交换，每个排列都会产生 n 个新的排列
     *  一种会产生 n * dp[n-1] 个排列。
     *  
     *  奇数个不包含逆序的紊乱，而偶数个是可以包含的，因此需要考虑特殊情况的加减
     *  这里还需要仔细讨论，暂时只总结基本经验
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int findDerangement(int n) {
            long rs = 0;
            for (int i = 2; i <= n; i++) {
                rs = ((rs% 1000000007) * i) % 1000000007;
                if (i % 2 != 0) {rs -= 1;}
                if (i % 2 == 0) {rs += 1;}
                rs = rs % 1000000007;
            }
            return (int) rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
