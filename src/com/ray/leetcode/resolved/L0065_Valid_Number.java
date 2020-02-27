package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * Valid Number
 *
 * Validate if a given string can be interpreted as a decimal number.
 * Some examples:
 * 0 => true
 *  0.1  => true
 * abc => false
 * 1 a => false
 * 2e10 => true
 *  -90e3    => true
 *  1e => false
 * e3 => false
 *  6e-1 => true
 *  99e2.5  => false
 * 53.5e93 => true
 *  --6  => false
 * -+3 => false
 * 95a54e53 => false
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
 * 	Numbers 0-9
 * 	Exponent - e
 * 	Positive/negative sign - +/-
 * 	Decimal point - .
 * Of course, the context of these characters also matters in the input.
 *
 * Level : Hard
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/valid-number/
 * @since   2020-02-27 22:42:35
 */
public class L0065_Valid_Number {
    /**
     * 跳过字符串开始的所有空格，然后跳过开始的+-符号
     * 跳过字符串结尾的所有空格
     *
     * 如果字符串包含 e 则判断e两侧都是纯数字
     * 如果字符串包含 . 则判断.两侧至少有一侧是数字，另一侧为空
     * 如果都不包含，则检测字符串为纯数字
     */
    static class Solution {

        public boolean isNumber(String s) {
            int l = 0, r = s.length() - 1;
            while (l < s.length() && s.charAt(l) == ' ') l++;
            while (r >= 0 && s.charAt(r) == ' ') r--;
            return isNumber(s, l, r);
        }

        public boolean isNumber(String s, int l, int r) {
            if (l < s.length() && ( s.charAt(l) == '+' || s.charAt(l) == '-') ) {
                l++;
            }
            int index = -1;
            if ((index = s.indexOf('e')) != -1 && index >= l && index <= r) {
                boolean rs = isNumber(s, l, index-1);
                if (index + 1 < s.length() && (s.charAt(index+1) == '+' || s.charAt(index+1) == '-')) {
                    index ++;
                }
                rs &= isJustNumber(s, index+1, r);
                return rs;
            } else if ((index = s.indexOf('.')) != -1) {
                boolean rs1 = isJustNumber(s, l, index-1);
                boolean rs2 = isJustNumber(s, index+1, r);
                return rs1 && (rs2 || r < index + 1) || (rs1 || l > index-1) && rs2;
            } else {
                return isJustNumber(s, l, r);
            }
        }

        public boolean isJustNumber(String s, int start, int end) {
            if (start > end) return false;
            for (int i = start; i <= end; i ++) {
                char c = s.charAt(i);
                if ( c < '0' || c > '9') return false;
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        String s = " .-4";
        Out.p(new Solution().isNumber(s));
    }
}
