package com.ray.leetcode.resolved;

import com.ray.io.In;
import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Different Ways to Add Parentheses
 * -----------------------------------------------------------------------------
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways
 * to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1
 *      Input: 2-1-1
 *      Output: [0, 2]
 *      Explanation: 
 *      ((2-1)-1) = 0 
 *      (2-(1-1)) = 2
 * Example 2
 *      Input: 2*3-4*5
 *      Output: [-34, -14, -10, -10, 10]
 *      Explanation: 
 *      (2*(3-(4*5))) = -34 
 *      ((2*3)-(4*5)) = -14 
 *      ((2*(3-4))*5) = -10 
 *      (2*((3-4)*5)) = -10 
 *      (((2*3)-4)*5) = 10
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * @since   2020-03-09 22:03:54
 */
public class L0241_Different_Ways_to_Add_Parentheses {
    /**
     * 不同的括号，就是操作符的先后运算。
     *
     * 如果一个表达式有 0 1 2 3 4 5 6 个操作符
     * 则如果从某个操作符加括号如： (0 1 2) 3 (4 5 6)
     * 显然 3 操作符左右的部分，还可以进一步的加括号，而且两部分加括号的方式是独立的
     * 那么问题可以划分为子问题
     * dp[i][j] 表示计算操作符 i 到 j 可能的计算结果
     * dp[i][j] = {  dp[i][k-1] X dp[k+1][j] } (k = i ~ j)
     */
    static class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> numbers = new ArrayList<>();
            List<Character> operate = new ArrayList<>();
            parse(input, numbers, operate);
            return dp(0, operate.size()-1, operate, numbers);
        }

        private List<Integer> dp(int l, int r, List<Character> operate, List<Integer> numbers) {
            List<Integer> rs = new ArrayList<>();
            if (l > r) {
                rs.add(numbers.get(l));
            } else {
                for (int i = l; i <= r; i++) {
                    for (int nl : dp(l, i-1, operate, numbers))
                        for (int nr : dp(i+1, r, operate, numbers))
                            rs.add(comp(nl, nr, operate.get(i)));
                }
            }
            return rs;
        }

        private Integer comp(int nl, int nr, Character character) {
            switch(character) {
                case '*': return nl * nr;
                case '+': return nl + nr;
                case '-': return nl - nr;
            }
            throw new RuntimeException("Invalid Operate");
        }

        private void parse(String input, List<Integer> numbers, List<Character> operate) {
            for (int i = 0, j = 0; j <= input.length(); j++) {
                if (j == input.length()) {
                    numbers.add(i);
                } else {
                    char c = input.charAt(j);
                    if (c == '*' || c == '+' || c == '-') {
                        numbers.add(i);
                        operate.add(c);
                        i = 0;
                    } else {
                        i = i * 10 + (c - '0');
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String input = "2*3-4*5"; // [-34, -14, -10, -10, 10]
        Out.p(new Solution().diffWaysToCompute(input));
    }
}
