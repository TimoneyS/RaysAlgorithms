package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.LinkedList;
import java.util.List;

/**
 * Fizz Buzz
 * -----------------------------------------------------------------------------
 * Write a program that outputs the string representation of numbers from 1 to n.
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *      Example 1
 *      n = 15,
 *      Return:
 *      [
 *          "1",
 *          "2",
 *          "Fizz",
 *          "4",
 *          "Buzz",
 *          "Fizz",
 *          "7",
 *          "8",
 *          "Fizz",
 *          "Buzz",
 *          "11",
 *          "Fizz",
 *          "13",
 *          "14",
 *          "FizzBuzz"
 *      ]
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/fizz-buzz/
 * @since   2020-03-11 21:57:20
 */
public class L0412_Fizz_Buzz {
    static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> rs = new LinkedList<String>();
            for (int i = 1; i <= n; i++) {
                boolean a = i % 3 == 0;
                boolean b = i % 5 == 0;
                if (a && b)
                    rs.add("Fizz Buzz");
                else if (a)
                    rs.add("Fizz");
                else if (b)
                    rs.add("Buzz");
                else
                    rs.add(i+"");
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
