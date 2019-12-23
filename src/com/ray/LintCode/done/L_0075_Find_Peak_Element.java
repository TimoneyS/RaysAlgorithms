package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      你给出一个整数数组(size为n)，其具有以下特点：
 *          相邻位置的数字是不同的
 *          A[0] < A[1] 并且 A[n - 2] > A[n - 1]
 *      假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
 *
 * 用例：
 *      Example 1:
 *      	Input:  [1, 2, 1, 3, 4, 5, 7, 6]
 *      	Output:  1 or 6
 *      
 *      Example 2:
 *      	Input: [1,2,3,4,1]
 *      	Output:  3
 *
 * 挑战：
 *      Time complexity O(logN)
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-peak-element/description
 * @date   2019-07-11 18:29:52
 */
public class L_0075_Find_Peak_Element {

    static class Solution {
        
        public int findPeak(int[] A) {
            
            int l = 1, r = A.length - 2; // 1.答案在之间，2.不会出界
            
            while (l + 1 < r) {
                int m = (l + r) / 2;
                if (A[m] < A[m + 1]) {
                    l = m;
                } else {
                    r = m;
                }
            }
            
            if (A[l] < A[r]) {
                return r;
            } else {
                return l;
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        int[] A = {1,2,3,4,5,1};
        
        Out.p(new Solution().findPeak(A));
        
    }


}
