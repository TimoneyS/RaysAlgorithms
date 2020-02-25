package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/generate-parentheses/
 * @since   2020-02-24 22:49:28
 */
public class L0022_Generate_Parentheses {
    /**
     * 试想 n = 2 两对括号的情况
     *
     * 1 第一个只能是左括号 (
     *   1.1 第二个是左括号 ((
     *      1.1.1 第三个只能是右括号，因为左括号用完了
     *   1.2 第二个是右括号 ()
     *      1.2.1 第三个只能是左括号，因此前两个括号互相匹配了 ()(
     *
     * 因此可以总结如下，只要之前左右括号全部互相了匹配，下一个字符只能是左括号了
     *                 只要之前的左右括号不能全部匹配，下一个字符可能是右括号也可能是左括号，
     *
     * 可以用 left 和 right 表示剩下的左括号和右括号的数量，用一个栈保存已经放置的括号字符
     * 如果 left == right 栈中的左右括号互相匹配，此时只能向栈中放入左括号(left - 1)
     * 除此之外，左右括号都可以放入(left - 1 or right - 1)
     * 算法保证了left 一定是 <= right 的，因此不会出现错位的情况
     *
     */
    static class Solution {
        public List<String> generateParenthesis(int n) {
            return helper(0, new ArrayList<>(), new char[2*n], n, n);
        }

        private List<String> helper(int start, List<String> rs, char[] chars, int left, int right) {
            if (left == 0 && right == 0) {
                rs.add(new String(chars));
            } else {
                if (left > 0) {
                    chars[start] = '(';
                    helper(start+1, rs, chars, left - 1, right);
                }
                if (left < right) {
                    chars[start] = ')';
                    helper(start+1, rs, chars, left, right - 1);
                }
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
