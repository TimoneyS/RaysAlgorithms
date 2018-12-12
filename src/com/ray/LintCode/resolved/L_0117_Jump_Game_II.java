package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2.
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * @author rays1
 *
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
