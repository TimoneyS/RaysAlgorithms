package com.ray.LintCode.temp;

/**
 * 描述：
 *      Given an **unsorted** integer array, find the first **missing** positive integer.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input:[1,2,0]
 *      Output:3
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      Input:[3,4,-1,1]
 *      Output:2
 *      ```
 *
 * 挑战：
 *      Your algorithm should run in O(_n_) time and uses constant space.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/first-missing-positive/description
 * @date   2019-07-11 18:31:46
 */
public class L_0189_First_Missing_Positive {

    static class Solution {

        public int firstMissingPositive(int[] A) {
            if (A == null) return 1;

            for (int i = 0; i < A.length; i++) {
                while (A[i] > 0 && A[i] <= A.length && A[i] != (i + 1)) {
                    int tmp = A[A[i] - 1];
                    if (tmp == A[i]) {
                        break;
                    }
                    A[A[i] - 1] = A[i];
                    A[i] = tmp;
                }
            }

            for (int i = 0; i < A.length; i++)
                if (A[i] != i + 1) return i + 1;

            return A.length + 1;
        }
    }

}
