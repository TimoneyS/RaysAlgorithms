package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team, like make the rank 1 team play with the rank nth team, which is a good strategy to make the contest more interesting. Now, you're given `n` teams, and you need to output their **final** contest matches in the form of a string.
 *      
 *      The `n` teams are given in the form of positive integers from 1 to n, which represents their initial rank. (Rank 1 is the strongest team and Rank n is the weakest team.) We'll use parentheses `()` and commas `,`  to represent the contest team pairing - parentheses `()` for pairing and commas `,` for partition. During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair with the rather weak one.
 *
 * 用例：
 *      **Example 1:**
 *      
 *      ```
 *      Input: 2
 *      Output: "(1,2)"
 *      ```
 *      
 *      **Example 2:**
 *      
 *      ```
 *      Input: 4
 *      Output: "((1,4),(2,3))"
 *      Explanation: 
 *        In the first round, we pair the team 1 and 4, the team 2 and 3 together, as we need to make the strong team and weak team together.
 *        And we got (1,4),(2,3).
 *        In the second round, the winners of (1,4) and (2,3) need to play again to generate the final winner, so you need to add the paratheses outside them.
 *        And we got the final answer ((1,4),(2,3)).
 *      ```
 *      
 *      **Example 3:**
 *      
 *      ```
 *      Input: 8
 *      Output: "(((1,8),(4,5)),((2,7),(3,6)))"
 *      Explanation:
 *        First round: (1,8),(2,7),(3,6),(4,5)
 *        Second round: ((1,8),(4,5)),((2,7),(3,6))
 *        Third round: (((1,8),(4,5)),((2,7),(3,6)))
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Medium
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/output-contest-matches/description
 * @date   2019-07-11 18:38:15
 */
public class L_0879_Output_Contest_Matches {


    static class Solution {
    
        public String findContestMatch(int n) {
            String[] arr = new String[n];
            for (int i = 1; i <= n; i++) arr[i-1] = String.valueOf(i);
            while (true) {
                String[] tem = new String[arr.length/2];
                for (int i = 0; i < tem.length; i++) {
                    tem[i] = "(" + arr[i] + "," + arr[arr.length-i-1] + ")";
                }
                if (tem.length == 1) return tem[0];
                arr = tem;
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
