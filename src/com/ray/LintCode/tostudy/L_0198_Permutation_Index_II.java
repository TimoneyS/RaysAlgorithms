package com.ray.LintCode.tostudy;

import java.util.HashMap;
import java.util.Map;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input :[1,4,2,2]
 *      Output:3
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input :[1,6,5,3,1]
 *      Output:24
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/permutation-index-ii/description
 * @date   2019-07-11 18:31:51
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
