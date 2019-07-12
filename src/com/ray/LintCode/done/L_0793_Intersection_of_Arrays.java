package com.ray.LintCode.done;

import java.util.HashSet;

import com.ray.io.Out;

/**
 * 描述：
 *      Give a number of arrays, find their intersection, and output their intersection size.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      	Input:  [[1,2,3],[3,4,5],[3,9,10]]
 *      	Output:  1
 *      	
 *      	Explanation:
 *      	Only '3' in all three array.
 *      ```
 *      
 *      **Example 2:**
 *      ```
 *      	Input: [[1,2,3,4],[1,2,5,6,7][9,10,1,5,2,3]]
 *      	Output:  2
 *      	
 *      	Explanation:
 *      	The set is [1,2].
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/intersection-of-arrays/description
 * @date   2019-07-11 18:36:48
 */
public class L_0793_Intersection_of_Arrays {


    /**
     * 偷懒使用 set
     * 
     * @author rays1
     *
     */
    static class Solution {
    
        public int intersectionOfArrays(int[][] arrs) {
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();
            for (int i : arrs[0]) set1.add(i);
            for (int i = 1; i < arrs.length; i++) {
                for (int n : arrs[i]) {
                    if (set1.contains(n)) set2.add(n);
                }
                set1 = set2;
                set2 = new HashSet<>();
            }
            
            return set1.size();
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
