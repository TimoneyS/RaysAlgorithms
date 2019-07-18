package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Given a non-negative integer `N`, find the largest number that is less than or equal to N with monotone increasing digits.
 *      
 *      (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 *
 * 用例：
 *      Given `N` = `10`, return `9`
 *      Given `N` = `12345`, return `12345`
 *      Given `N` = `10000`, return `9999`
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/monotone-increasing-digits/description
 * @date   2019-07-11 18:35:59
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
        
        Out.p(new Solution());
        
    }

}
