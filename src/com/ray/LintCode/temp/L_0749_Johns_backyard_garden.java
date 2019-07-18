package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      John wants to build a back garden on the empty space behind his home. There are two kinds of bricks now, one is `3` dm high and the other is `7` dm high. John wants to enclose a high `x` dm wall. If John can do this, output YES, otherwise NO.
 *
 * 用例：
 *      **Example 1:**
 *      ```
 *      Input : x = 10
 *      Output : "YES"
 *      Explanation :
 *      x = 3 + 7:That is, you need one batch of 3 dm height bricks and one batch of 7 dm height bricks.
 *      ```
 *      **Example 2:**
 *      ```
 *      Input : x = 5
 *      Output : "NO"
 *      Explanation:
 *      John can not enclose a high 5 dm wall with 3 dm height bricks and 7 dm height bricks.
 *      ```
 *      **Example 3:**
 *      ```
 *      Input : x = 13
 *      Output : "YES"
 *      Explanation :
 *      x = 2 * 3 + 7:That is, you need two batch of 3 dm height bricks and one batch of 7 dm height bricks.
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/johns-backyard-garden/description
 * @date   2019-07-11 18:36:02
 */
public class L_0749_Johns_backyard_garden {

    /**
     * 任意数模 7 的结果一定是 0 1 2 3 4 5 6
     *  0 3 6 的情况，可以
     *  2 4 5 的情况只要挪一个7或者两个7到余数中，就能成立
     * @author rays1
     *
     */
    static class Solution {
    
        public String isBuild(int x) {
            int t = x % 7;
            if (t%3 == 0 || x/t >2)
                return "YES";
            return "NO";
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
