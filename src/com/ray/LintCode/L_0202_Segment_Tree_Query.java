package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree, each node stores an extra attribute `max` to denote the maximum number in the interval of the array (index from start to end).
 *      
 *      Design a `query` method with three parameters `root`, `start` and `end`,  find the maximum number in the interval [start, end] by the given root of segment tree.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input："[0,3,max=4][0,1,max=4][2,3,max=3][0,0,max=1][1,1,max=4][2,2,max=2][3,3,max=3]",1,2
 *      Output：4
 *      Explanation：
 *      For array [1, 4, 2, 3], the corresponding Segment Tree is :
 *      
 *      	                  [0, 3, max=4]
 *      	                 /             \
 *      	          [0,1,max=4]        [2,3,max=3]
 *      	          /         \        /         \
 *      	   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
 *      The maximum value of [1,2] interval is 4
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input："[0,3,max=4][0,1,max=4][2,3,max=3][0,0,max=1][1,1,max=4][2,2,max=2][3,3,max=3]",2,3
 *      Output：3
 *      Explanation：
 *      For array [1, 4, 2, 3], the corresponding Segment Tree is :
 *      
 *      	                  [0, 3, max=4]
 *      	                 /             \
 *      	          [0,1,max=4]        [2,3,max=3]
 *      	          /         \        /         \
 *      	   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
 *      The maximum value of [2,3] interval is 3
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/segment-tree-query/description
 * @date   2019-07-11 18:31:53
 */
public class L_0202_Segment_Tree_Query {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
