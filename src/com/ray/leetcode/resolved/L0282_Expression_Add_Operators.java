package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Expression Add Operators
 * -----------------------------------------------------------------------------
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Example:
 *      Example 1
 *      Input: num = 123, target = 6
 *      Output: [1+2+3, 1*2*3] 
 *      Example 2
 *      Input: num = 232, target = 8
 *      Output: [2*3+2, 2+3*2]
 *      Example 3
 *      Input: num = 105, target = 5
 *      Output: [1*0+5,10-5]
 *      Example 4
 *      Input: num = 00, target = 0
 *      Output: [0+0, 0-0, 0*0]
 *      Example 5
 *      Input: num = 3456237490, target = 9191
 *      Output: []
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/expression-add-operators/
 * @since   2020-03-10 01:57:20
 */
public class L0282_Expression_Add_Operators {
    static class Solution {

        public List<String> addOperators(String num, int target) {
            List<String> rs = new ArrayList<>();
            helper(num, 0, target, 0, 0, "", rs);
            return rs;
        }


        void helper(String num, int start, int target, long prev, long base, String exp, List<String> rs) {
            if (num.length() == start && base == target) {
                rs.add(exp);
                return;
            }

            long curr = 0;
            for (int i = start; i < num.length(); i++) {
                curr = curr * 10 + num.charAt(i) - '0'; // 当前数字
                if (exp.length() > 0) {
                    // 之前的表达式 + 当前数字
                    helper(num, i+1, target,        curr,               base + curr, exp + "+" + curr, rs);
                    // 之前的表达式 - 当前数字
                    helper(num, i+1, target,       -curr,               base - curr, exp + "-" + curr, rs);
                    // 之前的表达式 * 当前数字
                    helper(num, i+1, target, prev * curr, base - prev + prev * curr, exp + "*" + curr, rs);
                } else {
                    // 之前的表达式直接和当前数字连接
                    helper(num, i+1, target,        curr,                      curr,        curr + "", rs);
                }

                if (curr == 0) break;
            }
        }

    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
