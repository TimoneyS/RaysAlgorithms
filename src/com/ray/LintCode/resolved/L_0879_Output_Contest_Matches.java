package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 * During the NBA playoffs, we always arrange the rather strong team to play with the rather weak team,
 * like make the rank 1 team play with the rank nth team, which is a good strategy to make the contest more interesting.
 * Now, you're given n teams, and you need to output their final contest matches in the form of a string.
 * 
 * The n teams are given in the form of positive integers from 1 to n, which represents their initial rank. 
 * (Rank 1 is the strongest team and Rank n is the weakest team.) We'll use parentheses () and commas ,
 * to represent the contest team pairing - parentheses () for pairing and commas , for partition.
 * During the pairing process in each round, you always need to follow the strategy of making the rather strong one pair 
 * with the rather weak one.
 *
 * @author rays1
 * @url    
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
        
        Out.p(new Solution().findContestMatch(8));
        
    }

}
