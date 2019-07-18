package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      一个有序数组被旋转了若干位(例如 0 1 2 4 5 6 7 可能变为了 4 5 6 7 0 1 2).
 *      给定一个目标值，寻找目标在数组中的索引。
 *      数组中没有重复元素。
 *
 * 用例：
 *      Example 1:
 *      Input: [4, 5, 1, 2, 3] and target=1, 
 *      Output: 2.
 *      
 *      Example 2:
 *      Input: [4, 5, 1, 2, 3] and target=0, 
 *      Output: -1.
 *
 * 挑战：
 *      O(logN) time
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/search-in-rotated-sorted-array/description
 * @date   2019-07-11 18:20:39
 */
public class L_0062_Search_in_Rotated_Sorted_Array {

    /**
     *             |-|
     *           |-| |
     *         |-| | |
     *       |-| | | |
     *     |-| | | | |
     *   |-| | | | | |
     * |-| | | | | | |
     * | | | | | | | |
     * | | | | | | | |       |-| 
     * | | | | | | | |     |-| | 
     * | | | | | | | |   |-| | | 
     * | | | | | | | | |-| | | | 
     * | | | | | | | |-| | | | | 
     * | | | | | | | | | | | | |  
     * -------------------------
     *  l                     r
     * 
     * 旋转数组可以分为两大部分，左侧和右侧，左侧值均大于右侧。
     * 如果对旋转数组进行二分搜索:
     *      首先 target 可能在左侧，也可能在右侧，构成条件： 
     *          a = target > arr[0]
     *      然后 m 可能落在左侧，也可能落在右侧，构成条件：
     *          b = arr[m] > arr[0]
     *      然后 arr[n]，可能大于或小于target，构成条件：
     *          c = arr[m] > target
     *
     * 各条件下的情况如下
     * --------------------------------------------------
     * | a | b  | c |            描述                      | 搜索范围
     * ----|---------------------------------------------
     * | T | T  | T | 目标在左，中点在左且大于目标 | [l, m]
     * | T | T  | F | 目标在左，中点在左且小于目标 | [m, r]
     * | T | F  | T | 目标在左，中点在右且大于目标 | 不可能
     * | T | F  | F | 目标在左，中点在右且小于目标 | [l, m]
     * | F | T  | T | 目标在右，中点在左且大于目标 | [m, r]
     * | F | T  | F | 目标在右，中点在左且小于目标 | 不可能
     * | F | F  | T | 目标在右，中点在右且大于目标 | [l, m]
     * | F | F  | F | 目标在右，中点在右且小于目标 | [m, r]
     * --------------------------------------------------
     * 
     * 总结可得          
     *      a ^ b ^ c 时， 在 [l, m] 中搜索   
     *           
     * @author rays1
     *
     */
    static class Solution {
        
        public int search(int[] A, int target) {
            
            int l = 0, r = A.length - 1;
            if (r == -1) {
                return -1;
            }
            if (A[0] == target) {
                return 0;
            }
            
            while (l <= r) {
                int m = (l + r) / 2;
                if (A[m] == target) {
                    return m;
                }
                if ((target > A[0]) ^ (A[m] >= A[0]) ^ (A[m] > target)) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            
            return -1;
        }
        
    }

    public static void main(String[] args) {
        
        int[] A = {1,2,3,4,5};
        int target = 4;
        
        Out.p( new Solution().search(A, target));
        
        
    }

}
