package com.ray.LintCode.resolved;

/**
 * 给定无重复数字的序列，返回字典序索引。索引从1开始
 *
 * [1,2,4] 返回 1
 * 
 * @author rays1
 *
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
