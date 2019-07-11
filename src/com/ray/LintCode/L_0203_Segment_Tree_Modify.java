package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      For a `Maximum Segment Tree`, which each node has an extra value `max` to store the maximum value in this node's interval.
 *      
 *      Implement a `modify` function with three parameter `root`, `index` and `value` to change the node's value with _**[start, end] = [index, index]**_ to the new given value. Make sure after this change, every node in segment tree still has the **max** attribute with the correct value.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input："[1,4,max=3][1,2,max=2][3,4,max=3][1,1,max=2][2,2,max=1][3,3,max=0][4,4,max=3]",2,4
 *      Output："[1,4,max=4][1,2,max=4][3,4,max=3][1,1,max=2][2,2,max=4][3,3,max=0][4,4,max=3]"
 *      Explanation：
 *      For segment tree:
 *      
 *      	                      [1, 4, max=3]
 *      	                    /                \
 *      	        [1, 2, max=2]                [3, 4, max=3]
 *      	       /              \             /             \
 *      	[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=3]
 *      
 *      if call modify(root, 2, 4), we can get:
 *      
 *      	                      [1, 4, max=4]
 *      	                    /                \
 *      	        [1, 2, max=4]                [3, 4, max=3]
 *      	       /              \             /             \
 *      	[1, 1, max=2], [2, 2, max=4], [3, 3, max=0], [4, 4, max=3]
 *      ```
 *      
 *      
 *      **Example 2:**
 *      ```
 *      Input："[1,4,max=3][1,2,max=2][3,4,max=3][1,1,max=2][2,2,max=1][3,3,max=0][4,4,max=3]",4,0
 *      Output："[1,4,max=4][1,2,max=4][3,4,max=0][1,1,max=2][2,2,max=4][3,3,max=0][4,4,max=0]"
 *      Explanation：
 *      For segment tree:
 *      
 *      	                      [1, 4, max=3]
 *      	                    /                \
 *      	        [1, 2, max=2]                [3, 4, max=3]
 *      	       /              \             /             \
 *      	[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=3]
 *      if call modify(root, 4, 0), we can get:
 *      	
 *      	                      [1, 4, max=2]
 *      	                    /                \
 *      	        [1, 2, max=2]                [3, 4, max=0]
 *      	       /              \             /             \
 *      	[1, 1, max=2], [2, 2, max=1], [3, 3, max=0], [4, 4, max=0]
 *      ```
 *
 * 挑战：
 *      Do it in `O(h)` time, h is the height of the segment tree.
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/segment-tree-modify/description
 * @date   2019-07-11 18:31:54
 */
public class L_0203_Segment_Tree_Modify {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
