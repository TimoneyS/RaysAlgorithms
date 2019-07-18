package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      对 L_0062_Search_in_Rotated_Sorted_Array 的跟进问题
 *      如果数组中存在重复的元素，如何搜索。
 *
 * 用例：
 *      Example 1:
 *      Input:
 *      [3,4,4,5,7,0,1,2]
 *      4
 *      Output:
 *      true
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-in-rotated-sorted-array-ii/description
 * @date   2019-07-11 18:20:47
 */
public class L_0063_Search_in_Rotated_Sorted_Array_II {

    /**
     * 偷懒的解法
     * 
     * 进行两次二分搜索
     * 
     * 判断在左侧还是右侧时，一次使用 A[0]+1 做边界，一次使用 A[0] 做边界
     * 
     * 如果 A[0] 是重复元素，第一次就能够搜索到目标，且时间复杂度正常
     * 如果 A[0] 不是重复元素，第一次搜索可能未命中
     * 
     * 这样保证是在 A[0] 是重复元素时，也能够正常搜索
     * 
     * @author rays1
     *
     */
    static class Solution {
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
