package com.ray.leetcode.resolved;

import com.ray.io.Out;

/**
 * ZigZag Conversion
 *
 * The string PAYPALISHIRING is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: PAHNAPLSIIGYIR
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example:
 *      Example 1
 *      Input: s = PAYPALISHIRING, numRows = 3
 *      Output: PAHNAPLSIIGYIR
 *      Example 2
 *      Input: s = PAYPALISHIRING, numRows =&nbsp;4
 *      Output:&nbsp;PINALSIGYAHRPI
 *      Explanation:
 *      P     I    N
 *      A   L S  I G
 *      Y A   H R
 *      P     I
 *
 * Level : Medium
 *
 * @author  ray
 * @link    https://leetcode-cn.com/problems/zigzag-conversion/
 * @since   2020-02-23 18:37:28
 */
public class L0006_ZigZag_Conversion {
    static class Solution {
        public String convert(String s, int numRows) {
            if (numRows <= 1) return s;
            StringBuilder[] arr = new StringBuilder[numRows];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new StringBuilder();
            }
            int num = numRows * 2 - 2;
            for (int i = 0; i < s.length(); i++) {
                int row = num/2 - Math.abs(i%num - num/2);
                arr[row].append(s.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            for (StringBuilder sbt: arr) {
                sb.append(sbt);
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;

        Out.p(new Solution().convert(s, numRows));
    }
}
