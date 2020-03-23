package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Lexicographical Numbers
 * -----------------------------------------------------------------------------
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 * Example:
 *      
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/lexicographical-numbers/
 * @since   2020-03-23 21:52:03
 */
public class L0386_Lexicographical_Numbers {
    static class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> rs = new ArrayList<>();
            helper(0, n, rs);
            return rs;
        }

        private void helper(int base, int n, List<Integer> rs) {
            for (int i = 0; i < 10; i++) {
                if (base * 10 + i > n) break;
                if (base * 10 + i == 0) continue;
                rs.add(base * 10 + i);
                helper( base * 10 + i, n, rs);
            }
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
