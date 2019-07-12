package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      Assume you have an array of length `n` initialized with all `0`'s and are given `k` update operations.
 *      
 *      Each operation is represented as a triplet: `[startIndex, endIndex, inc]` which increments each element of subarray `A[startIndex ... endIndex]` (startIndex and endIndex inclusive) with `inc`.
 *      
 *      Return the modified array after all `k` operations were executed.
 *
 * 用例：
 *      ```
 *      Given:
 *      length = 5,
 *      updates = 
 *      [
 *      [1,  3,  2],
 *      [2,  4,  3],
 *      [0,  2, -2]
 *      ]
 *      return [-2, 0, 3, 5, 3]
 *      
 *      Explanation:
 *      Initial state:
 *      [ 0, 0, 0, 0, 0 ]
 *      After applying operation [1, 3, 2]:
 *      [ 0, 2, 2, 2, 0 ]
 *      After applying operation [2, 4, 3]:
 *      [ 0, 2, 5, 5, 3 ]
 *      After applying operation [0, 2, -2]:
 *      [-2, 0, 3, 5, 3 ]
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/range-addition/description
 * @date   2019-07-11 18:38:29
 */
public class L_0903_Range_Addition {

    static class Solution {
        
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] rs = new int[length];
            for (int[] update : updates) {
                for (int i = update[0]; i <= update[1]; i++) {
                    rs[i] += update[2];
                }
            }
            return rs;
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
