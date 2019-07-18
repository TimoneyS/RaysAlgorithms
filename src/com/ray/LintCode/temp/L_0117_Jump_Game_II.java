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
 *      Your goal is to reach the last index in the minimum number of jumps.
 *      </p>
 *
 * 用例：
 *      ***Example 1***
 *      ```
 *      Input : [2,3,1,1,4]
 *      Output : 2
 *      Explanation : The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/jump-game-ii/description
 * @date   2019-07-11 18:30:46
 */
public class L_0117_Jump_Game_II {

    static class Solution {
        
        public int jump(int[] A) {
            
            int jumpCount = 0;
            int cursor = A.length-1;
            while (true) {
                for (int i = 0; i <= cursor; i++) {
                    if (cursor == i) return 0;
                    if (A[i]+i >= cursor) {
                        cursor = i;
                        jumpCount ++;
                        break;
                    }
                }
                if (cursor == 0) break;
            }
            
            return jumpCount;
        }
        
    }
    
    public static void main(String[] args) {
        
        int[] A = {2};
        
        Out.p(new Solution().jump(A));
    }

}
