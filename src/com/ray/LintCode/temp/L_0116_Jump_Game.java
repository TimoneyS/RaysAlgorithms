package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      <p>
 *      Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *      </p>
 *      <p>
 *      Each element in the array represents your maximum jump length at that position. 
 *      </p>
 *      <p>
 *      Determine if you are able to reach the last index.
 *      </p>
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [2,3,1,1,4]
 *      Output : true
 *      ```
 *      
 *      ***Example 2***
 *      ```
 *      Input : [3,2,1,0,4]
 *      Output : false
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/jump-game/description
 * @date   2019-07-11 18:30:45
 */
public class L_0116_Jump_Game {

    static class Solution {
        
        public boolean canJump(int[] A) {
            if (A.length <= 1) return true;
            
            int n = A.length;
            int cursor = n-1;
            for (int i = n-2; i >= 0; i--) {
                if (A[i]+i >= cursor) {
                    cursor = i;
                }
            }
            return cursor == 0;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {3, 2, 1, 0, 4};
        Out.p(new Solution().canJump(A));
    }

}
