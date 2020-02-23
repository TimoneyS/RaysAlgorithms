package com.ray.leetcode.resolved;

import com.ray.io.Out;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer
 *
 * Roman numerals are represented by seven different symbols:&nbsp;I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example,&nbsp;two is written as II&nbsp;in Roman numeral, just two one&#39;s added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * 	I can be placed before V (5) and X (10) to make 4 and 9.&nbsp;
 * 	X can be placed before L (50) and C (100) to make 40 and 90.&nbsp;
 * 	C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example:
 *      Example 1
 *      Input:&nbsp;III
 *      Output: 3
 *      Example 2
 *      Input:&nbsp;IV
 *      Output: 4
 *      Example 3
 *      Input:&nbsp;IX
 *      Output: 9
 *      Example 4
 *      Input:&nbsp;LVIII
 *      Output: 58
 *      Explanation: L = 50, V= 5, III = 3.
 *      Example 5
 *      Input:&nbsp;MCMXCIV
 *      Output: 1994
 *      Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * Level : Easy
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/roman-to-integer/
 * @since   2020-02-23 20:44:54
 */
public class L0013_Roman_to_Integer {
    /**
     * 遍历字符串，将每个字符转换为罗马数字对应的10进制数字
     * 如果当前字符小于下一个字符，说明该字符属于被减的部分，则该字符对应的值设置为负数
     * 累加即可
     */
    static class Solution {
        static Map<Character, Integer> hash = new HashMap<>();
        static {
            hash.put('I', 1    );
            hash.put('V', 5    );
            hash.put('X', 10   );
            hash.put('L', 50   );
            hash.put('C', 100  );
            hash.put('D', 500  );
            hash.put('M', 1000 );
        }

        public int romanToInt(String s) {
            int rs = 0;
            for (int i = 0; i < s.length(); i++) {
                int val = hash.get(s.charAt(i));
                if (i < s.length() - 1 && hash.get(s.charAt(i+1)) > val)
                    val = -val;
                rs += val;
            }
            return rs;
        }
    }
    
    public static void main(String[] args) {
        Out.p(new Solution());
    }
}
