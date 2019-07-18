package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *      
 *      You may assume **NO** duplicates in the array.
 *
 * 用例：
 *      `[1,3,5,6]`, 5 → 2
 *      
 *      `[1,3,5,6]`, 2 → 1
 *      
 *      `[1,3,5,6]`, 7 → 4
 *      
 *      `[1,3,5,6]`, 0 → 0
 *
 * 挑战：
 *      O(log(n)) time
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-insert-position/description
 * @date   2019-07-11 18:20:27
 */
public class L_0060_Search_Insert_Position {

    static class Solution {
        /**
         * @param A: an integer sorted array
         * @param target: an integer to be inserted
         * @return: An integer
         */
        public int searchInsert(int[] A, int target) {
            int l = 0,r = A.length-1;
            if (r==-1) return 0;
            while (l<r) {
                int m = (l+r)/2;
                if (target == A[m]) return m;
                if (target > A[m])      l = m+1;
                else if (target < A[m]) r = m-1;
            }
            return (l>r) ? l : (A[r] >= target) ? r : r+1;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {5};
        int target = 5;
        
        Out.p(new Solution().searchInsert(A, target));
        
        
    }

}
