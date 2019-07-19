package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      两个有序的数组 A 和 B 和 大小分别为 m 和 n
 *      寻找两个数组的中位数
 *      
 *      如果数组尺寸是奇数，中位数是中间数组，如果数组尺寸为偶数，中位数是中间两个数字的平均数。
 *
 * 用例：
 *      **Example 1**
 *      Input:
 *      A = [1,2,3,4,5,6]
 *      B = [2,3,4,5]
 *      Output: 3.5
 *      
 *      **Example 2**
 *      Input:
 *      A = [1,2,3]
 *      B = [4,5]
 *      Output: 3
 *
 * 挑战：
 *      时间复杂度 O(log (m +n))
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/median-of-two-sorted-arrays/description
 * @date   2019-07-11 18:29:42
 */
public class L_0065_Median_of_two_Sorted_Arrays {

    /**
     * 
     * A B 大小为 m n
     * 
     * 取 i = m / 2
     * 
     * A[i] 在 B 中的排名 Ri。
     * 
     * @author rays1
     *
     */
    static class Solution {
        
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
