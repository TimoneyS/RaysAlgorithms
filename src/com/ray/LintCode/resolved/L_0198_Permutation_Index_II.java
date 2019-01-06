package com.ray.LintCode.resolved;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 给定可能包含重复数字的序列，返回字典序索引。索引从1开始
 *
 * @author rays1
 *
 */
public class L_0198_Permutation_Index_II {

    static class Solution {
        public long permutationIndexII(int[] A) {

            Map<Integer, Integer> count = new HashMap<>();

            long rs = 1, repFact = 1, allFact = 1;

            for (int i = A.length - 1; i >= 0; i--) {

                // i 后重复数字的个数，计算 i 位时要除以 multi
                add(count, A[i]);
                repFact *= count.get(A[i]);
                // i后有几个比i小的
                int rank = rank(A, A[i], i+1, A.length-1);
                // 排列组合一下
                rs += allFact * rank / repFact;
                allFact *= (A.length - i);
            }

            return rs;
        }
        
        private void add(Map<Integer, Integer> map, int num) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        private int rank(int[] A, int target, int start, int end) {
            int rank = 0;
            for (int i = start; i < A.length; i++)
                if (A[i] < target)
                    rank++;
            return rank;
        }
        
    }

    public static void main(String[] args) {

        int[] A = { 4, 1, 1 };

        Out.p(new Solution().permutationIndexII(A));

    }

}
