package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given an integer array in the construct method, implement two methods `query(start, end)` and `modify(index, value)`:
 *      
 *      - For query(*start*, *end*), return the **sum** from index *start* to index *end* in the given array.
 *      - For modify(*index*, *value*), modify the number in the given index to *value*
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      [1,2,7,8,5]
 *      [query(0,2),modify(0,4),query(0,1),modify(2,1),query(2,4)]
 *      Output: [10,6,14]
 *      Explanation:
 *      Given array A = [1,2,7,8,5].
 *      After query(0, 2), 1 + 2 + 7 = 10,
 *      After modify(0, 4), change A[0] from 1 to 4, A = [4,2,7,8,5].
 *      After query(0, 1), 4 + 2 = 6.
 *      After modify(2, 1), change A[2] from 7 to 1，A = [4,2,1,8,5].
 *      After query(2, 4), 1 + 8 + 5 = 14.
 *      ```
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      [1,2,3,4,5]
 *      [query(0,0),query(1,2),quert(3,4)]
 *      Output: [1,5,9]
 *      Explantion:
 *      1 = 1
 *      2 + 3 = 5
 *      4 + 5 = 9
 *      ```
 *
 * 挑战：
 *      O(logN) time for `query` and `modify`.
 *
 * 难度： Hard
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/interval-sum-ii/description
 * @date   2019-07-11 18:31:57
 */
public class L_0207_Interval_Sum_II {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
