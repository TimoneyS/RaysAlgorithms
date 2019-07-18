package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      There are two sorted arrays _A_ and _B_ of size _m_ and _n_ respectively. Find the **median** of the two sorted arrays.
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      A = [1,2,3,4,5,6]
 *      B = [2,3,4,5]
 *      Output: 3.5
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      A = [1,2,3]
 *      B = [4,5]
 *      Output: 3
 *      ```
 *
 * 挑战：
 *      The overall run time complexity should be `O(log (m+n))`.
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/median-of-two-sorted-arrays/description
 * @date   2019-07-11 18:29:42
 */
public class L_0065_Median_of_two_Sorted_Arrays {

    static class Solution {
        /*
         * @param A: An integer array
         * @param B: An integer array
         * @return: a double whose format is *.5 or *.0
         */
        public double findMedianSortedArrays(int[] A, int[] B) {
            
            int la = 0, ra = A.length - 1;
            int lb = 0, rb = B.length - 1;
            
            while (ra+rb-la-lb > 0) {
                Out.pf("%s - %s; %s - %s\n", la, ra, lb, rb);
                if (la > ra) {
                    lb++;
                    rb--;
                } else if (lb > rb) {
                    la++;
                    ra--;
                } else {
                    if (A[la] <= B[lb]) {
                        la++;
                    } else {
                        lb++;
                    }
                    
                    if (A[ra] >= B[rb]) {
                        ra--;
                    } else {
                        rb--;
                    }
                }
                
            }
            Out.pf("%s - %s; %s - %s\n", la, ra, lb, rb);
            
            if (ra < la) {
                return (double)((double)B[lb] + (double)B[rb]) / 2;
            } else if (rb < lb) {
                return (double)((double)A[la] + (double)A[ra]) / 2;
            } else {
                return (double)((double)A[la] + (double)B[lb]) / 2;
            }
        }
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,3};
        int[] B = {2147483646,2147483647};
        
        Out.p(new Solution().findMedianSortedArrays(A, B));
        
    }

}
