package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      For an array, we can build a `SegmentTree` for it, each node stores an extra attribute `count` to denote the number of elements in the the array which value is between interval start and end. (The array may not fully filled by elements)
 *      
 *      Design a `query` method with three parameters `root`, `start` and `end`,  find the number of elements in the in array's interval [*start*, *end*] by the given root of value SegmentTree.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input："[0,3,count=3][0,1,count=1][2,3,count=2][0,0,count=1][1,1,count=0][2,2,count=1][3,3,count=1]",[[1, 1], [1, 2], [2, 3], [0, 2]]
 *      Output：[0,1,2,2]
 *      Explanation：
 *      The corresponding value Segment Tree is:
 *      
 *      	                     [0, 3, count=3]
 *      	                     /             \
 *      	          [0,1,count=1]             [2,3,count=2]
 *      	          /         \               /            \
 *      	   [0,0,count=1] [1,1,count=0] [2,2,count=1], [3,3,count=1]
 *      
 *      Input : query(1,1), Output: 0
 *      
 *      Input : query(1,2), Output: 1
 *      
 *      Input : query(2,3), Output: 2
 *      
 *      Input : query(0,2), Output: 2
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input："[0,3,count=3][0,1,count=1][2,3,count=2][0,0,count=1][1,1,count=0][2,2,count=0][3,3,count=1]",[[1, 1], [1, 2], [2, 3], [0, 2]]
 *      Output：[0,0,1,1]
 *      Explanation：
 *      The corresponding value Segment Tree is:
 *      
 *      	                     [0, 3, count=2]
 *      	                     /             \
 *      	          [0,1,count=1]             [2,3,count=1]
 *      	          /         \               /            \
 *      	   [0,0,count=1] [1,1,count=0] [2,2,count=0], [3,3,count=1]
 *      
 *      Input : query(1,1), Output: 0
 *      
 *      Input : query(1,2), Output: 0
 *      
 *      Input : query(2,3), Output: 1
 *      
 *      Input : query(0,2), Output: 1
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/segment-tree-query-ii/description
 * @date   2019-07-11 18:32:05
 */
public class L_0247_Segment_Tree_Query_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
