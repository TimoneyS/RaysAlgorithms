package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * 给定一个非负的整数 N，寻找小于等于 N 的 最大的单调递增的数字。
 * 当且仅当每对相邻的数字 x 和 y 满足 x <= y 时, 这个整数才是单调递增数
 * 给出 N = 10, 返回 9
 * 给出 N = 12345, 返回 12345
 * 给出 N = 10000, 返回 9999
 * @author rays1
 *
 */
public class L_0743_Monotone_Increasing_Digits {

    /**
     * 暴力算法，也可以从数字本身入手，以后改进
     * @author rays1
     *
     */
    static class Solution {
    
        public int monotoneDigits(int num) {
            while (true) {
                if (isInc(num)) break;
                num --;
            }
            return num;
        }
        
        private boolean isInc(int num) {
            int prev = 9;
            while (true) {
                if (num % 10 > prev) return false;
                prev = num % 10;
                num = num /10;
                if (num == 0) break;
            }
            return true;
        }
    
    }
    
    public static void main(String[] args) {
        
        int num = 123454;
        Out.p(new Solution().monotoneDigits(num));
        
    }

}
