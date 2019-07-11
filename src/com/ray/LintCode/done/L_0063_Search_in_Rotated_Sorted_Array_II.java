package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Follow up for [Search in Rotated Sorted Array](http://www.lintcode.com/problem/search-in-rotated-sorted-array/ "Search in Rotated Sorted Array"):
 *      
 *      What if **duplicates** are allowed?
 *      
 *      Would this affect the run-time complexity? How and why?
 *      
 *      Write a function to determine if a given target is in the array.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      []
 *      1
 *      Output:
 *      false
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      [3,4,4,5,7,0,1,2]
 *      4
 *      Output:
 *      true
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-in-rotated-sorted-array-ii/description
 * @date   2019-07-11 18:20:47
 */
public class L_0063_Search_in_Rotated_Sorted_Array_II {

    static class Solution {
        /**
         * @param A: an integer ratated sorted array and duplicates are allowed
         * @param target: An integer
         * @return: a boolean 
         */
        public boolean search(int[] A, int target) {
            
            int l = 0, r = A.length - 1;
            if (r == -1) return false;
            if (A[0] == target) return true;
            
            int border = A[0]+1;
            while (l<=r)  {
                int m = (l+r)/2;
                if (A[m] == target) return true;
                
                if ((border > target) ^ (A[m] >= border) ^ (A[m] > target)) { 
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                
            }
            
            l = 0;
            r = A.length - 1;
            border = A[0];
            while (l<=r)  {
                int m = (l+r)/2;
                if (A[m] == target) return true;
                
                if ((border > target) ^ (A[m] >= border) ^ (A[m] > target)) { 
                    l = m + 1;
                } else {
                    r = m - 1;
                }
                
            }
            
            return false;
        }
    }
    
    public static void main(String[] args) {

        //int[] A = { 9,5,6,7,8,9,9,9,9,9,9};
        int[] A = {9, 9, 9, 9, 9, 9, 5, 6, 7, 8, 9};
        
        int target = 8;
        Out.p(A);

        Out.p(new Solution().search(A, target));

    }

}
