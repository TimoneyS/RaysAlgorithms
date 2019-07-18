package com.ray.LintCode.tostudy;

/**
 * 描述：
 *      <p>Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.</p>
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:[1,2,4]
 *      Output:1
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:[3,2,1]
 *      Output:6
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/permutation-index/description
 * @date   2019-07-11 18:31:50
 */
public class L_0197_Permutation_Index {

    static class Solution {
        public long permutationIndex(int[] A) {

            long rs = 1, allFact = 1;

            for (int i = A.length - 1; i >= 0; i--) {
                // i后有几个比i小的
                int rank = rank(A, A[i], i + 1, A.length - 1);
                // 排列组合一下
                rs += allFact * rank;
                allFact *= (A.length - i);
            }

            return rs;
        }

        private int rank(int[] A, int target, int start, int end) {
            int rank = 0;
            for (int i = start; i < A.length; i++)
                if (A[i] < target)
                    rank++;
            return rank;
        }

    }

}
