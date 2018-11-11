package com.ray.LintCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Given number n. Print number from 1 to n. But:
 * <li>when number is divided by 3, print "fizz".
 * <li>when number is divided by 5, print "buzz".
 * <li>when number is divided by both 3 and 5, print "fizz buzz".
 * <p>
 * Example
 * <p>
 * If n = 15, you should return:    <br>
 * [                        <br>
 *  "1", "2", "fizz",       <br>
 *  "4", "buzz", "fizz",    <br>
 *  "7", "8", "fizz",       <br>
 *  "buzz", "11", "fizz",   <br>
 *  "13", "14", "fizz buzz" <br>
 * ]                        <br>
 * Challenge
 * <p>
 * Can you do it with only one if statement?
 * @author rays1
 *
 */
public class L_0009_Fizz_Buzz {

    static class Solution {
        /**
         * @param n: An integer
         * @return: A list of strings.
         */
        public List<String> fizzBuzz(int n) {
            // write your code here
            
            List<String> rs = new LinkedList<String>();
            
            for (int i = 1; i <= n; i++) {
                
                boolean a = i % 3 == 0;
                boolean b = i % 5 == 0;
                
                if (a && b)
                    rs.add("fizz buzz");
                else if (a)
                    rs.add("fizz");                    
                else if (b)
                    rs.add("buzz");
                else
                    rs.add(i+"");
                
            }
            
            return rs;
        }
    }
    
    public static void main(String[] args) {
        new Solution().fizzBuzz(10);
    }
    
}
