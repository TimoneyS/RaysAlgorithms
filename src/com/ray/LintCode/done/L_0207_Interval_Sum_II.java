package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array in the construct method, implement two methods `query(start, end)` and `modify(index, value)`:
 *      
 *      - For query(*start*, *end*), return the **sum** from index *start* to index *end* in the given array.
 *      - For modify(*index*, *value*), modify the number in the given index to *value*
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      [1,2,7,8,5]
 *      [query(0,2),modify(0,4),query(0,1),modify(2,1),query(2,4)]
 *      Output: [10,6,14]
 *      Explanation:
 *      Given array A = [1,2,7,8,5].
 *      After query(0, 2), 1 + 2 + 7 = 10,
 *      After modify(0, 4), change A[0] from 1 to 4, A = [4,2,7,8,5].
 *      After query(0, 1), 4 + 2 = 6.
 *      After modify(2, 1), change A[2] from 7 to 1，A = [4,2,1,8,5].
 *      After query(2, 4), 1 + 8 + 5 = 14.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      [1,2,3,4,5]
 *      [query(0,0),query(1,2),quert(3,4)]
 *      Output: [1,5,9]
 *      Explantion:
 *      1 = 1
 *      2 + 3 = 5
 *      4 + 5 = 9
 *      ```
 *
 * 挑战：
 *      O(logN) time for `query` and `modify`.
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/interval-sum-ii/description
 * @date   2019-07-11 18:31:57
 */
public class L_0207_Interval_Sum_II {

    static class Solution {

        long[] sum;
        int[]  A;

        public Solution(int[] A) {
            this.A = A;
            sum = new long[A.length + 1];
            sum(0);
        }

        private void sum(int start) {
            for (int i = start + 1; i < sum.length; i++)
                sum[i] = sum[i - 1] + A[i - 1];
        }

        public long query(int start, int end) {
            return sum[end + 1] - sum[start];
        }

        public void modify(int index, int value) {
            A[index] = value;
            sum(index);
        }
    }

    public static void main(String[] args) {

        int[] A = { 1, 2, 7, 8, 5 };

        Solution sol = new Solution(A);

        Out.p(sol.query(0, 2));
        sol.modify(0, 4);
        Out.p(sol.query(0, 1));
        sol.modify(2, 1);
        Out.p(sol.query(2, 4));

    }

}
