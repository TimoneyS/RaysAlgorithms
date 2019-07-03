package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given an array arr of integers (**not necessarily distinct**), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 *   
 *   What is the most number of chunks we could have made?
 *
 * Example :
 *   **Example 1:**
 *   ```
 *   Input: arr = [5,4,3,2,1]
 *   Output: 1
 *   Explanation:
 *   Splitting into two or more chunks will not return the required result.
 *   For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
 *   ```
 *   **Example 2:**
 *   ```
 *   Input: arr = [2,1,3,4,4]
 *   Output: 4
 *   Explanation:
 *   We can split into two chunks, such as [2, 1], [3, 4, 4].
 *   However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
 *   ```
 *
 * Challenge :
 *   
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/max-chunks-to-make-sorted-ii/description
 * @date   2019-07-03 17:37:08
 */
public class L_1040_Max_Chunks_To_Make_Sorted_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
